package com.yk.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Date: 2018/11/12 17:39
 * @Version: 1.0
 * @Author: pengqingfeng
 * @Description:
 */
@Component
public class KafkaConsumer {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("接收消息为:" + record.value());
    }
}
