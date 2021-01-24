package cn.itcast.rocketmq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.HashMap;
import java.util.Map;

/**
 * 分布式事务消息 监听器
 */
public class TransactionListenerImpl implements TransactionListener {

    //要实现消息的回查 需要记录每一个事务的状态（KEY值是事务的ID ，VALUE值是事务的状态）
    private static Map<String, LocalTransactionState> STATE_MAP = new HashMap<>();

    /**
     * 执行具体的业务逻辑（发送消息之后 做一些本地业务的逻辑）
     *
     * @param msg 发送的消息对象
     * @param arg
     * @return
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        try {
            System.out.println("用户A账户减500元.");
            Thread.sleep(500); //模拟调用一个服务

//             System.out.println(1/0);//巧妙的模拟了上面调用服务成功 下面调用服务失败的情况

            System.out.println("用户B账户加500元.");
            Thread.sleep(800); //模拟调用一个服务


            STATE_MAP.put(msg.getTransactionId(), LocalTransactionState.COMMIT_MESSAGE);

            // 二次提交确认
//            return LocalTransactionState.UNKNOW;//返回未知的状态 让消息服务做一个回查
            return LocalTransactionState.COMMIT_MESSAGE;
        } catch (Exception e) {
            e.printStackTrace();
        }

        STATE_MAP.put(msg.getTransactionId(), LocalTransactionState.ROLLBACK_MESSAGE);
        // 回滚
        return LocalTransactionState.ROLLBACK_MESSAGE;
    }

    /**
     * 消息回查（回查的实现）
     *
     * 当做消息回查的时候 从MAP中 根据事务的ID获取事务的状态即可
     * @param msg
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        System.out.println("状态回查 ---> " + msg.getTransactionId() +" " +STATE_MAP.get(msg.getTransactionId()) );
        return STATE_MAP.get(msg.getTransactionId());
    }
}