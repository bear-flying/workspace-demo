package cn.itcast.rocketmq.sendmsg;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送消息：同步
 */
public class SyncProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("haoke");

        producer.setNamesrvAddr("172.16.55.185:9876");
        //集群的多个节点用分号分隔
        //producer.setNamesrvAddr("172.16.55.185:9876;172.16.55.185:9877");

        producer.start();

        //发送消息
        String msg = "我的第一个消息6!";

        /**
         * Message数据结构：
         * Topic 默认值：null 必填，线下环境不需要申请，线上环境需要申请后才能使用
         * Body 默认值：null 必填，二进制形式，序列化由应用决定，Producer 与 Consumer 要协商好序列化形式。
         * Tags 默认值：null 选填，使用tags设置操作类型，方便服务器过滤使用（Consumer通过匹配tags接收消息）。
         *      目前只支持每个消息设置一个 tag，
         * Keys 默认值：null 选填，代表这条消息的业务关键词，服务器会根据 keys 创建哈希索引，设置后，可以
         *      在 Console 系统根据 Topic、Keys 来查询消息，由于是哈希索引，请尽可能保证 key 唯一，例如订单号，商品 Id 等。
         * Flag 默认值：0 选填，完全由应用来设置，RocketMQ 不做干预
         * DelayTimeLevel 默认值：0 选填，消息延时级别，0 表示不延时，大于 0 会延时特定的时间才会被消费
         * WaitStoreMsgOK 默认值：TRUE 选填，表示消息是否在服务器落盘后才返回应答。
         */
        Message message = new Message("my-topic", "delete", msg.getBytes("UTF-8"));
        //发送消息后 返回消息ID
        SendResult sendResult = producer.send(message);
        System.out.println("消息id：" + sendResult.getMsgId());
        System.out.println("消息队列：" + sendResult.getMessageQueue());
        System.out.println("消息offset值：" + sendResult.getQueueOffset());
        System.out.println(sendResult);
        /**
         * 打印结果：
         * 消息状态：SEND_OK
         * 消息id：AC1037A0307418B4AAC2374062400000
         * 消息queue：MessageQueue [topic=haoke_im_topic, brokerName=broker_haoke_im, queueId=6]
         * 消息offset：0
         */
        producer.shutdown();
    }
}
