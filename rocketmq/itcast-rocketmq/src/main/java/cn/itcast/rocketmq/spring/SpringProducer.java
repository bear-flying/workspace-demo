package cn.itcast.rocketmq.spring;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringProducer {

    // 注入rocketMQ的模板
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送消息
     *
     * @param topic
     * @param msg
     */
    public void sendMsg(String topic, String msg) {

        this.rocketMQTemplate.convertAndSend(topic, msg);
        //this.rocketMQTemplate.asyncSend(); 异步发送
        //this.rocketMQTemplate.syncSend(); 同步发送
    }

}
