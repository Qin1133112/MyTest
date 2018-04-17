package com.springboot.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springboot.user.domain.User;
import com.springboot.user.service.UserService;
import com.springboot.utils.JackUtils;

//证明是controller层并且返回json
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.springboot.user.service" }) // 添加的注解
public class UserController
{
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@PostMapping("/find")
	public List<User> find(User user)
	{
		return userService.find(user);
	}

	@PostMapping("add")
	public String add(User user)
	{
		boolean add = userService.add(user);
		if (add)
		{
			logger.info("sucess");
			return "sucess";
		} else
		{
			logger.info("fail");
			return "fail";
		}
	}
	
	@PostMapping("modify")
	public String modify(User user)
	{
		boolean add = userService.modify(user);
		if (add)
		{
			logger.info("sucess");
			return "sucess";
		} else
		{
			logger.info("fail");
			return "fail";
		}
	}
	
	@PostMapping("remove")
	public String remove(User user)
	{
		boolean add = userService.delete(user);
		if (add)
		{
			logger.info("sucess");
			return "sucess";
		} else
		{
			logger.info("fail");
			return "fail";
		}
	}
	
	@PostMapping("removeAll")
	public String remove(@RequestBody List<Integer> ids)
	{
		boolean add = userService.delete(ids);
		if (add)
		{
			logger.info("sucess");
			return "sucess";
		} else
		{
			logger.info("fail");
			return "fail";
		}
	}
	
	@PostMapping("test")
	public String test(@RequestBody List<Integer> ids)
	{
		System.out.println(ids);
		String json = JackUtils.bean2Json(ids);
		return json;
		
	}
	
//	public static void main(String[] args)
//	{
//		List<Integer> ids = new ArrayList<>();
//		ids.add(1);
//		ids.add(2);
//		ids.add(3);
//		System.out.println(ids);
//		String idss = JackUtils.bean2Json(ids);
//		System.out.println(idss);
//		
//		List<Integer> is = JackUtils.json2Bean(idss, List.class);
//		System.out.println(is);
//	}

}
