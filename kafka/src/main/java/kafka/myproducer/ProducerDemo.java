package kafka.myproducer;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * 
 * @author qin
 *
 */
public class ProducerDemo
{
	public static void main(String[] args)
	{
		Random rnd = new Random();
		int events = 100;

		// 设置配置属性
		Properties props = new Properties();

		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.13:19092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

		// 创建producer
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		// 产生并发送消息
		long start = System.currentTimeMillis();
		for (long i = 0; i < events; i++)
		{
			Date runtime = new Date();
			String ip = "192.168.1.13";
			String msg = runtime + ",www.example.com," + ip;
			ProducerRecord<String, String> data = new ProducerRecord<String, String>("Hello", ip, msg);
			producer.send(data);
		}
		System.out.println("耗时:" + (System.currentTimeMillis() - start)+"ms");
		// 关闭producer
		producer.close();
	}
}
