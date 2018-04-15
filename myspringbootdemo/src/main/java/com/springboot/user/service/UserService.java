package com.springboot.user.service;

import java.util.List;

import com.springboot.user.domain.User;

public interface UserService
{
	public List<User> find(User user);
	
	public boolean add(User user);

	public boolean modify(User user);

	public boolean delete(User user);

	public boolean delete(List<Integer> ids);
}
