package com.javase.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("-------设定要指定任务--------");
	}

}

public class TimerTest {

	public static void main(String[] args) {

		MyTask task = new MyTask();
		// timer1();
		// timer2(task);
		// timer3(task);
		timer4(task);
		// timer5(task);
		// timer6(task);
	}

	// 第一种方法：设定指定任务task在指定时间time执行
	// schedule(TimerTask task, Date time)
	/**
	 * 指定一个时间，到那个时间 就执行（仅执行一次）
	 */
	public static void timer1() {
		try {
			Timer timer = new Timer();
			String dateStr = "2017-02-22 17:23:00";
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			timer.schedule(new TimerTask() {
				public void run() {
					System.out.println("-------设定要指定任务--------");
					// this.cancel();// 定时器不会自己关闭 需要调用这个取消的方法（这是个静态方法）
				}
			}, format.parse(dateStr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 第二种方法：设定指定任务task,在延迟delay秒后执行
	// schedule(TimerTask task, long delay)
	/**
	 * 指定一个延迟时间delay，倒计时完成 就执行（仅执行一次）
	 */
	public static void timer2(MyTask task) {
		Timer timer = new Timer();
		timer.schedule(task, 5000);// 设定指定的时间time,此处为5000毫秒
	}

	// 第三种方法：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
	// schedule(TimerTask task,Date firstTime,long period)
	/**
	 * 指定初始执行的时间firstTime，到时间执行一次，从这个时间起，每延迟period 就执行一次
	 */
	public static void timer3(MyTask task) {
		try {
			Timer timer = new Timer();
			String dateStr = "2017-02-22 17:23:00";
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			timer.schedule(task, format.parse(dateStr),
					1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行一次

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// 第四种方法：设定指定任务task在指定延迟delay后进行固定延迟peroid的执行
	// schedule(TimerTask task, long delay, long period)
	/**
	 * 指定初始的延迟时间delay，到时间执行一次，从这个时间起，每延迟period 就执行一次
	 */
	public static void timer4(MyTask task) {
		Timer timer = new Timer();
		timer.schedule(task, 5000, 10000);
	}

	// 第五种方法：设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
	// scheduleAtFixedRate(TimerTask task, long delay, long period)
	/**
	 *
	 */
	public static void timer5(MyTask task) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 5000, 3000);
	}

	// 第六种方法：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
	// Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
	/**
	 *
	 */
	public static void timer6(MyTask task) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 12); // 控制时
		calendar.set(Calendar.MINUTE, 0); // 控制分
		calendar.set(Calendar.SECOND, 0); // 控制秒 Date time =
		Date time = calendar.getTime(); // 得出执行任务的时间,此处为今天的12：00：00

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, time,
				1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行一次
	}

}
