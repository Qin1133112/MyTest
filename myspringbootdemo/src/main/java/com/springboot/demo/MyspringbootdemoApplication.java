package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MyspringbootdemoApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(MyspringbootdemoApplication.class, args); 
	}
}