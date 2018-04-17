package com.springboot.model;

import com.springboot.user.domain.User;

public class ExportModel
{
	private String type;
	
	private User user;

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
	
}
