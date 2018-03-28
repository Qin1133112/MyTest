package com.huawei.service.impl;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.huawei.dao.PersonMapper;
import com.huawei.model.Person;
import com.huawei.service.IPersonService;

@Service("personService")
public class PersonServiceImpl implements IPersonService
{

	private PersonMapper personMapper;

	public PersonMapper getPersonMapper()
	{
		return personMapper;
	}

	@Autowired
	public void setPersonMapper(PersonMapper personMapper)
	{
		this.personMapper = personMapper;
	}

	public List<Person> loadPersons()
	{
		System.out.println("***************************************");
		System.out.println("客户端ip:" + getIpAddr(getRequest()));
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("服务器ip:" + getServerIP());
		System.out.println("***************************************");
		return null;
	}

	public void insert(Person person)
	{
		// System.out.println(person.getName());
		personMapper.insert(person);
	}

	public static HttpServletRequest getRequest()
	{
		ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ra.getRequest();
		return request;
	}

	public String getIpAddr(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
//		System.out.println("x-forwarded-for ip:"+ip);
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
//			System.out.println("Proxy-Client-IP:"+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
//			System.out.println("WL-Proxy-Client-IP:"+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
//			System.out.println("getRemoteAddr() ip:"+ip);
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
	
	public static String getServerIP()
	{
		String serverIP = "";
		
		Enumeration<?> allNetInterfaces;
		try
		{
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements())
			{
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
//				System.out.println(netInterface.getName());
				Enumeration<?> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements())
				{
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address && !ip.isLoopbackAddress())
					{
						serverIP = ip.getHostAddress();
						return serverIP;
					}
				}
			}
		} catch (SocketException e)
		{
		}
		return serverIP;
	}
//	public static void main(String[] args)
//	{
//		getServerIP();
//	}
}