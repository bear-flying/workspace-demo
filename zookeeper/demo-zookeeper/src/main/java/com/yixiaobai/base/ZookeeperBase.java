package com.yixiaobai.base;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class ZookeeperBase {

    private static String HOST_PORT = "192.168.1.106:2181";
    private static int CONNECTION_TIMEOUT = 2000;
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    /**
     * @param args
     */
    public static void main(String[] args) {
        try{
            // 创建一个与服务器的连接
            ZooKeeper zk = new ZooKeeper(HOST_PORT,
                    CONNECTION_TIMEOUT, new Watcher() {
                // 监控所有被触发的事件
                public void process(WatchedEvent event) {
                    // 连接状态
                    KeeperState keeperState = event.getState();
                    // 事件类型
                    EventType eventType = event.getType();
                    if(KeeperState.SyncConnected==keeperState){
                        if (EventType.None == eventType) {
                            connectedSemaphore.countDown();
                            System.out.println("已经触发了" + event.getType() + "事件！");
                        }
                    }

                }
            });
            connectedSemaphore.await();
            System.out.println(zk.toString());
            // 创建一个目录节点
            zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);

            // 创建一个子目录节点
            zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                    Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

            System.out.println(new String(zk.getData("/testRootPath",false,null)));
            // 取出子目录节点列表

            System.out.println(zk.getChildren("/testRootPath",true));
            // 修改子目录节点数据
            zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1);
            System.out.println("目录节点状态：["+zk.exists("/testRootPath",true)+"]");
            // 创建另外一个子目录节点
            zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
                    Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));
            // 删除子目录节点
            zk.delete("/testRootPath/testChildPathTwo",-1);
            zk.delete("/testRootPath/testChildPathOne",-1);
            // 删除父目录节点
            zk.delete("/testRootPath",-1);
            // 关闭连接
            zk.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

