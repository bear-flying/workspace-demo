package com.yixiaobai.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;

import java.util.Collections;
import java.util.List;

/**
 * 锁
 */
public class DemoServer {

	private ZooKeeper zkCli = null;
	boolean haveLock = false;
	private final String groupNode = "/locks";
	private String myNodePath;
	private static String hostname;

	/**
	 * ��ȡ��Ȼ��ȥ���ʹ�����Դ����ҵ����
	 * 
	 * @throws Exception
	 */
	public void gainLockAndDoSomething() throws Exception {

		// ����һ��zk�ͻ��ˣ�����һ��������
		zkCli = new ZooKeeper("hdp-server-01:2181", 2000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				
				if(event.getType()!=EventType.NodeChildrenChanged) return;
		try{
			// ��zk�ͻ���ȥ��ȡ��Ȩ��
			haveLock = gainLock();
			if (haveLock) {
				System.out.println(hostname + " gained the lock....");
				// �õ���֮�󣬵���ҵ���?������ҵ����
				doSomeThing();
				// �ͷ���
				releaseLock();
				// ���´�����ڵ㲢ע�����
				registerLock();
			}
				
		}catch(Exception e){
			
		}
			}
		});

		// ��zk�ͻ�����"/locks"��ע��һ���Լ�����ڵ�
		registerLock();

		// ���߳���΢����һ��
		Thread.sleep((long) (Math.random() * 500 + 500));

		// ��zk�ͻ���ȥ��ȡ��Ȩ��
		haveLock = gainLock();
		
		if (haveLock) {
			System.out.println(hostname + " gained the lock....");
			// �õ���֮�󣬵���ҵ���?������ҵ����
			doSomeThing();
			// �ͷ���
			releaseLock();
			// ���´�����ڵ㲢ע�����
			registerLock();
		}

	}

	/**
	 * ע����ڵ���Ϣ�����ھ�����Ȩ��
	 * 
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	public void registerLock() throws KeeperException, InterruptedException {

		// ��zookeeper��ע��һ���Լ�����ڵ㣬���Ѹ���ڵ�·����¼��myNodePath������
		myNodePath = zkCli.create(groupNode + "/lock", null, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

	}

	/**
	 * ��ȡ��Ȩ�� �߼��ǣ��Լ���������ڵ������������ڵ�����С��һ����������Ȩ��
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	public boolean gainLock() throws KeeperException, InterruptedException {

		List<String> children = zkCli.getChildren(groupNode, true);

		// ����ӽڵ��б��ֻ��1��Ԫ�أ���ô˵������ǰ��ֻ������һ���ڵ����ߣ��ҾͿ���ֱ�ӻ����Ȩ��
		if (children.size() == 1)
			return true;

		Collections.sort(children);

		// myNodePath : /locks/lock0000001

		if (children.get(0).equals(myNodePath.substring(groupNode.length() + 1))) {

			return true;
		} else {

			return false;
		}

	}

	/**
	 * ģ����ʹ�����Դ������ҵ����ķ���
	 * @throws InterruptedException 
	 */
	public void doSomeThing() throws InterruptedException {
		
		System.out.println("begin working .......");
		Thread.sleep((long)(Math.random()*1000+500));
		System.out.println("work has complished.....");
		
	}
	
	
	/**
	 * �ͷ���Ȩ��
	 * �߼���ɾ����Լ�����ڵ�
	 * @throws KeeperException 
	 * @throws InterruptedException 
	 */
	public void releaseLock() throws InterruptedException, KeeperException {

		zkCli.delete(myNodePath, -1);
		
	}


	/**
	 * ��������
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		hostname = args[0];

		// ȥ��ȡ���ҽ���ҵ����
		DemoServer demoServer = new DemoServer();
		demoServer.gainLockAndDoSomething();

		// ���߳�����
		Thread.sleep(Long.MAX_VALUE);

	}

}
