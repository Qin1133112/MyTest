package com.springboot.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springboot.kafka.KafkaConsumerAction;

@Component
@Order(3)
public class KafkaConsumerRunner implements CommandLineRunner
{

	@Autowired
	KafkaConsumerAction kafkaConsumerAction;
	
	@Override
	public void run(String... args) throws Exception
	{
		kafkaConsumerAction.run();
	}

}
