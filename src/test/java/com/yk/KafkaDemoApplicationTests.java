package com.yk;

import com.yk.config.KafkaSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaDemoApplicationTests {


	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	KafkaSender sender;

	@Test
	public void contextLoads() {
		for (int i=1;i<=1000;i++){
			sender.send(i+"----"+UUID.randomUUID()+":"+System.currentTimeMillis());
		}
	}

}
