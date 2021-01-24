package cn.itcast.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class ConsumerDemo {

    public static void main(String[] args) throws Exception {

        // DefaultMQPushConsumer(服务端向消费者端推送消息)
        // DefaultMQPullConsumer(消费者端向服务端定时拉取消息)
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("haoke-consumer");
        consumer.setNamesrvAddr("172.16.55.185:9876");

        // 订阅条件，只要是进入名为my-topic的topic中的消息，全部都接收
        // consumer.subscribe("my-topic", "*");

        // 订阅条件，进入名为my-topic的topic中的消息，仅接收tags值为add或update的
        consumer.subscribe("my-topic", "add || update");

        consumer.setMessageModel(MessageModel.CLUSTERING);

        //MessageListenerConcurrently 表示并发消息（分布式事务消息）
        //MessageListenerOrderly 表示顺序消息 会通过同一个队列接收消息（同一个线程接收的都是同一个队列中的消息）
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {

                try {
                    for (MessageExt msg : msgs) {
                        System.out.println("消息:" + new String(msg.getBody(), "UTF-8"));
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                System.out.println("接收到消息 -> " + msgs);

                //接收到服务端推送的消息 消费以后 需要给服务端响应一个状态（这个消息是处理成功了还是失败了）
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动消费者
        consumer.start();

    }
}
