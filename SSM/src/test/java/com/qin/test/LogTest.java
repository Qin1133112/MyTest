package com.qin.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huawei.controller.PersonController;

/**
 * 日志管理测试
 * 
 * @author tuzongxun
 * @date 2017年2月22日 下午3:40:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class LogTest {
	static Logger  logger = LoggerFactory.getLogger(PersonController.class);
    @Test
    public void commonLogTest() {
    	logger.debug("AAAAAAAAAAAAAA");
    }

    @Test
    public void slf4jLogTest() {
    	logger.debug("AAAAAAAAAAAAAA");
    }

}
