package com.springboot.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.user.domain.User;
import com.springboot.user.service.UserService;

//证明是controller层并且返回json
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.springboot.user.service" }) // 添加的注解
public class UserController
{
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
			return "sucess";
		} else
		{
			return "fail";
		}
	}
	
	@PostMapping("modify")
	public String modify(User user)
	{
		boolean add = userService.modify(user);
		if (add)
		{
			return "sucess";
		} else
		{
			return "fail";
		}
	}
	
	@PostMapping("remove")
	public String remove(User user)
	{
		boolean add = userService.delete(user);
		if (add)
		{
			return "sucess";
		} else
		{
			return "fail";
		}
	}

}
