package com.springboot.kafka;

import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springboot.model.ExportModel;
import com.springboot.user.domain.User;
import com.springboot.user.service.UserService;
import com.springboot.utils.FileUtils;
import com.springboot.utils.JackUtils;

@Controller
public class KafkaConsumerAction
{
	Logger logger = LoggerFactory.getLogger(KafkaConsumerAction.class);
	@Autowired
	UserService userService;
	
	public void run()
	{
		final KafkaConsumer<String, String> consumer = createConsumer();
		consumer.subscribe(Arrays.asList("test"), new ConsumerRebalanceListener()
		{
			public void onPartitionsRevoked(Collection<TopicPartition> collection)
			{
			}

			public void onPartitionsAssigned(Collection<TopicPartition> collection)
			{
				// 将偏移设置到最开始
//				consumer.seekToBeginning(collection);
			}
		});
		while (true)
		{
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records)
			{
				ExportModel exportModel = JackUtils.json2Bean(record.value(), ExportModel.class);
				if(null != exportModel)
				{
					System.out.println("type:"+exportModel.getType());
					User user = exportModel.getUser();
					System.out.println("用户："+user.getName());
					if("export".equals(exportModel.getType()))
					{
						StringBuilder sb = new StringBuilder();
						sb.append(user.getName()).append("||").append(user.getSex()).append("||").append(user.getAge());
						System.out.println(sb.toString());
						FileUtils.write(sb.toString(), "a.txt");
					}else
					{
						boolean add = userService.add(user);
						if(add)
						{
							logger.info("成功");
						}else
						{
							logger.info("失败");
						}
					}
				}
			}
		}
	}

	private static KafkaConsumer<String, String> createConsumer()
	{
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.1.11:19092,192.168.1.13:19092,192.168.1.14:19092");
		props.put("group.id", getUUID());
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		final KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		return consumer;
	}

	private static synchronized String getUUID()
	{
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		return id;
	}
}
