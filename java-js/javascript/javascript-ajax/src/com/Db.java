package com;

import java.util.ArrayList;
import java.util.List;



public class Db {

	public List<Worker> showDb() {//����Ǽ���
		List<Worker> list = new ArrayList<Worker>();
		// ����һ��List<Worker>,����,Ҫ�󼯺�����Worker�༴Ҳ�з���
		Worker w1=new Worker(1, "������",'n', 26, 3);
		Worker w2=new Worker(2, "л���",'Ů', 24, 2);
		Worker w3=new Worker(3, "������",'c', 22, 2);
		Worker w4=new Worker(4, "����",'w', 18, 1);
		Worker w5=new Worker(5, "����",'2', 18, 1);
		list.add(w1);
		list.add(w2);
		list.add(w3);
		list.add(w4);
		list.add(w5);
		return list;
	}
}
