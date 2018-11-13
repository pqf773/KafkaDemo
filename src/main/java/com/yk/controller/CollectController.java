package com.yk.controller;

import com.yk.config.KafkaSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Date: 2018/11/12 16:53
 * @Version: 1.0
 * @Author: pengqingfeng
 * @Description:
 */
@RestController
@RequestMapping("/kafka")
public class CollectController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    KafkaSender sender;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public Map sendKafka(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        try {
            String message = request.getParameter("message");
            sender.send(message+"---"+ UUID.randomUUID()+"----"+System.currentTimeMillis());
            map.put("code", 200);
            map.put("message", "发送kafka成功");
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            map.put("code", 500);
            map.put("message", "发送kafka失败");
        }
        return map;
    }

}