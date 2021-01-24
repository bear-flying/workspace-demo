package com.jiangyu.queue;

/**
 * 
 * 队列 ---- 模拟实现
 * 
 * @author JiangYu
 *
 */
public class Queue {
	private String[] datas;
	private int index = 0;

	public Queue(int capacity) {// 构造方法。
		datas = new String[capacity];
	}

	// 入队
	public void enqueue(String data) {
		// 当队列容量不足时，扩容。
		if (index >= datas.length) {
			String[] tmp = new String[datas.length + 5];
			for (int i = 0; i < datas.length; i++) {
				tmp[i] = datas[i];
			}
			datas = tmp;
		}
		datas[index++] = data;
	}

	// 出队
	public String dequeue() {
		if (index != 0) {
			// 返回队头的元素，并且其他元素向队头移动。
			String result = datas[0];
			// 移动操作
			for (int i = 0; i < index - 1; i++) {
				datas[i] = datas[i + 1];
			}
			index--;
			return result;
		}
		System.out.println("队列已空");
		return null;
	}

	// 清空队列元素。
	public void clear() {
		index = 0;
	}

	// 判断队列是否为空。
	public boolean isEmpty() {
		if (index == 0) {
			return true;
		} else {
			return false;
		}
	}

	// 显示队列中的所有元素，从队头到队尾。
	public void display() {
		for (int i = 0; i < index; i++) {
			System.out.print(datas[i] + "\t");
		}
		System.out.println("  ");
	}

}
