package com.huawei.start;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component  
public class Start
{
	Logger logger = LoggerFactory.getLogger(Start.class);
	@PostConstruct
	public void afterPropertiesSet() 
	{
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
		logger.debug("***********************************afterPropertiesSet***************************************");
	}

}
