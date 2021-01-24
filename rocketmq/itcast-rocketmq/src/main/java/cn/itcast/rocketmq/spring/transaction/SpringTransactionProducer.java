package cn.itcast.rocketmq.spring.transaction;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class SpringTransactionProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送消息
     *
     * @param topic
     * @param msg
     */
    public void sendMsg(String topic, String msg) {
        Message message = MessageBuilder.withPayload(msg).build();
        /**
         * myTransactionGroup这个值不能随便定义
         * myTransactionGroup需要与Listener：
         *  （@RocketMQTransactionListener(txProducerGroup = "myTransactionGroup")）中定义的一致
         * 否则不在一个事务中
         */
        // myTransactionGroup要和 定义的一致
        this.rocketMQTemplate.sendMessageInTransaction("myTransactionGroup",
                topic,
                message,
                null);

        System.out.println("发送消息成功");
    }
}