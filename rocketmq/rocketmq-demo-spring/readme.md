## 消费监听
1.项目为maven web

2.启动tomcat默认会启动消费者监听

3.监听的配置在rocketmq-web/src/main/resources/spring-config-rocketmq.xml

4.监听的实现类在rocketmq-service/src/main/java/com.jd.wxz.rocketmq/SimpleRocketMqListener

## 生产测试
1.rocketmq-web/src/test/java/com.jd.wxz.rocketmq/TestRocketMq.test();
2.生产者的spring配置在rocketmq-web/src/test/resources/