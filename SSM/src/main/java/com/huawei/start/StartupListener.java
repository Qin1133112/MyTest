package com.huawei.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class StartupListener implements ApplicationListener<ContextRefreshedEvent >
{
	Logger logger = LoggerFactory.getLogger(StartupListener.class);
	int i = 0;
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
	{
		if(contextRefreshedEvent.getApplicationContext().getParent() == null)
		{
			i++;
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
//			System.out.println("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
			logger.info("启动spring容器后..........................."+i);
		}
	}

}
