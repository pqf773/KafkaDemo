package com.yk.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Date: 2018/11/12 17:38
 * @Version: 1.0
 * @Author: pengqingfeng
 * @Description:
 */
@Component
public class KafkaSender {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 发送消息方法
    public void send(String key, String body) {
        kafkaTemplate.send("test", key, body);
        logger.info("发送消息完成,内容为: key:{}----body:{}", key, body);
    }

    // 发送消息方法
    public void send(String body) {
        kafkaTemplate.send("test", body);
        logger.info("发送消息完成,内容为: body:{}", body);
    }
}