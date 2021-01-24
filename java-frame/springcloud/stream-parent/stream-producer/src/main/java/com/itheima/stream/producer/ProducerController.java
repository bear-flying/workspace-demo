package com.itheima.stream.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//写一个Controller调用发送消息
// 并使用浏览器访问 观察RabbitMQ中的情况 正常情况应该是交换机被创建出来 有一条消息
@RestController
public class ProducerController {

    @Autowired
    private MessageProducer producer;


    @RequestMapping("/send")
        public String sendMsg(){
        producer.send();
        return "success";
    }
}
