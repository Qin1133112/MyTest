package com.springboot.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.ExportModel;
import com.springboot.user.domain.User;
import com.springboot.user.service.UserService;
import com.springboot.utils.JackUtils;

@RestController
public class KafkaProducerAction
{
	@Autowired
	UserService userService;
	
	@PostMapping("/produce")
	public String run(User user,String type)
	{
		if(StringUtils.isEmpty(type))
		{
			return "no type";
		}
		ExportModel exportModel = new ExportModel();
		exportModel.setType(type);
		exportModel.setUser(user);
		String value = JackUtils.bean2Json(exportModel);
		Producer<String, String> producer = createProducer();
		producer.send(new ProducerRecord<String, String>("test", value));
		return "sucess";
	}

	private Producer<String, String> createProducer()
	{
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.1.11:19092,192.168.1.13:19092,192.168.1.14:19092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		return producer;
	}
}
