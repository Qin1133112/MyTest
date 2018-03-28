package kafka.myconsumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerDemo
{

	public static void main(String[] args)
	{
		Properties props = new Properties();

		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				"192.168.1.11:19092,192.168.1.13:19092,192.168.1.14:19092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList("Hello","Test"));

		while (true)
		{
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records)
			{
				System.out.println("topic="+record.topic()+",key="+record.key()+",value="+record.value());
//				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
			}
			
			if(consumer.listTopics().isEmpty())
			{
				consumer.close();
			}
		}
	}

}
