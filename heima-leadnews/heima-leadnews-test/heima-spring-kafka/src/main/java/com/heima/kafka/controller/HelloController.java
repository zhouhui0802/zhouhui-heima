package com.heima.kafka.controller;


import com.alibaba.fastjson.JSON;
import com.heima.kafka.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/3/5 9:01
 */
@RestController
public class HelloController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/hello")
    public String hello() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        kafkaTemplate.send("zhouhui", JSON.toJSONString(user));
        return "ok";
    }
}
