package com.springboot.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.springboot.user.dao.UserDao;
import com.springboot.user.domain.User;
import com.springboot.user.service.UserService;
import com.springboot.utils.JackUtils;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> find(User user)
	{
		List<User> users = userDao.findUsers(user);
//		if(!"".equals(user.getName()))
//		{
//			users = userDao.findByName(user);
//		}else
//		{
//			users = userDao.findAll();
//		}
		
		return users;
	}
	
	@Override
	public boolean add(User user)
	{
		return userDao.add(user);
	}

	@Override
	public boolean modify(User user)
	{
		return userDao.modify(user);
	}

	@Override
	public boolean delete(User user)
	{
		return userDao.delete(user);
	}

	@Override
	public boolean delete(List<Integer> ids)
	{
//		@SuppressWarnings("unchecked")
//		List<Integer> ids = JackUtils.json2Bean(json, List.class); 
		if(!CollectionUtils.isEmpty(ids))
		{
			return userDao.deleteBatch(ids);
		}
		 return false;
	}

}
