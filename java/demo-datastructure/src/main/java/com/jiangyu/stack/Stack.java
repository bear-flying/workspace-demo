package com.jiangyu.stack;

/**
 * 
 * 栈(堆栈) ---- 模拟实现
 * 
 * @author JiangYu
 *
 */
public class Stack {

	private String[] datas = new String[10];// 本站共有10个元素空间。
	private int index = 0;// index为元素个数。
	
	// 入栈。
	public void push(String data) {
		if (index >= datas.length) {// 如果超出栈容量，需要扩容。
			String[] tmp = new String[datas.length + 5];
			System.arraycopy(datas, 0, tmp, 0, datas.length);
			datas = tmp;
		}
		datas[index] = data;// 下标个数恰巧等于元素个数。
		index++;
	}

	public void display() {// 显示栈中的所有元素，从栈底到栈顶。
		for (int i = 0; i < index; i++) {
			System.out.println(datas[i]);
		}
	}

	public String pop() {// 出栈，需要注意栈空的情况。
		if (index > 0) {
			return datas[- -index];
		}
		System.out.println("栈已空");
		return null;
	}

	public String seek() {
		if (index > 0) {
			return datas[index - 1];
		}
		System.out.println("栈已空");
		return null;
	}

	public void dear() {// 清空栈中元素
		index = 0;
	}

}
