package com.springboot.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JackUtils
{
	static ObjectMapper objectMapper = new ObjectMapper();
	
	public static <T> T json2Bean(String json,Class<T> T) 
	{
		T t = null;
		try
		{
			t= (T) objectMapper.readValue(json, T);
		} catch (JsonParseException e)
		{
		} catch (JsonMappingException e)
		{
		} catch (IOException e)
		{
		}
		return t;
	}
	
	public static <T> String bean2Json(T t)
	{
		String json = "";
		try
		{
			json = objectMapper.writeValueAsString(t);
		} catch (JsonProcessingException e)
		{
		}
		return json;
	}
}
