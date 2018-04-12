package com.springboot.demo.myspeingbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MyspeingbootdemoApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(MyspeingbootdemoApplication.class, args);
	}
}
