package com.springboot.demo.myspeingbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
	@GetMapping("/helloworld")
	public String helloworld()
	{
		return "hello,world";
	}
}
