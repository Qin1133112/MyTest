package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
public class MyApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(MyApplication.class, args);
		
	}
}
