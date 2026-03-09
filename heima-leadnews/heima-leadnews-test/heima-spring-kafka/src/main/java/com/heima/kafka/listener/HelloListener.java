package com.heima.kafka.listener;


import com.alibaba.fastjson.JSON;
import com.heima.kafka.dto.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/5 11:06
 */
@Component
public class HelloListener {

    @KafkaListener(topics = "zhouhui")
    public void onMessage(String message) {
        if(!StringUtils.isEmpty(message)) {
            User user= JSON.parseObject(message, User.class);
            System.out.println(user);
        }
    }
}
