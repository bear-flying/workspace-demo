package com.javasky.play;

import java.util.Scanner;

import com.javasky.dao.StudentDao;
import com.javasky.pojo.Student;

public class PlayStudent {
	/**
	 *程序运行界面如下：
	 *欢迎使用学员管理系统：(1)新增学员.(2)修改成绩.(3)删除学员.
	 *				 (4)成绩排序.(5)显示所有学生信息.(6)退出程序；
	 *选择(1)的情况：请输入学员姓名，请输入Java成绩,保存请按1，取消请按0，系统给出处理提示信息：（新增成功；用户取消）.
     *选择(2)的情况：请输入要修改的学生ID，请输入要修改的学生成绩，保存请按1，取消请按0，系统给出处理提示信息：（修改成功；学生不存在；分数不合法；用户取消）.
     *选择(3)的情况：请输入要删除的学生ID，删除请按1，取消请按0，系统给出处理提示信息：（删除成功；学生不存在；用户取消）.
     *选择(4)的情况：按照分数从高到低排序，系统给出处理提示信息：（排序完成）.
	 *选择(5)的情况：遍历显示所有学生信息，格式为：Xxx 60分. Yyy70分.
	 *选择(6)的情况：给出提示：谢谢使用.退出系统.
	 */
	public static void main(String[] args) {
		Student student = new Student();
		StudentDao studentdao = new StudentDao();
		boolean  isOver = false;//接收是否退出程序
		int cmd;//接收用户的功能选择
		int save;//是否保存
		int id;
		Scanner s = new Scanner(System.in);
		System.out.println("欢迎使用学员管理系统");
		while(!isOver){
			System.out.println("1.新增学员;2.修改成绩;3.删除学员;4.成绩排序;5.显示所有学生信息;6.退出程序;");
			cmd = s.nextInt();
			switch(cmd){
			case 1:
				System.out.println("请输入学员ID：");
				student.setId(s.nextInt());
				System.out.println("请输入学员姓名：");
				student.setName(s.next());
				System.out.println("请输入学员成绩：");
				student.setScore(s.nextInt());
				System.out.println("保存请按1，取消请按0。");
				save= s.nextInt();
				if(save==1){
					if(studentdao.save(student)){
						System.out.println("新增成功");
					}else{
						System.out.println("新增失败");
					}
				}else{
					System.out.println("用户取消");
				}
				break;
			case 2:
				System.out.println("请输入要修改的学生ID:");
				id = s.nextInt();
				while(true){
					if(!studentdao.selectId(id)){
						System.out.println("查无此人，请重新输入");
					}else{
						break;
					}
				}
				student.setId(id);
				System.out.println("请输入要修改的学生姓名");
				student.setName(s.next());
				System.out.println("请输入要修改的学生成绩");
				student.setScore(s.nextInt());
				System.out.println("保存请按1，取消请按0");
				cmd=s.nextInt();
				if(cmd==1){
					if(studentdao.update(student)){
						System.out.println("修改成功");
					}else{
						System.out.println("修改失败");
					}
				}else{
					System.out.println("用户取消");
				}
				break;
			case 3:
				System.out.println("请输入要删除的学生ID");
				id = s.nextInt();
				while(true){
					if(!studentdao.selectId(id)){
						System.out.println("查无此人，请重新输入");
					}else{
						break;
					}
				}
				System.out.println("删除请按1，取消请按0");
				cmd=s.nextInt();
				if(cmd==1){
					if(studentdao.delete(id)){
						System.out.println("删除成功");
					}else{
						System.out.println("删除失败");
					}
				}else{
					System.out.println("用户取消");
				}
				break;
			case 4:
				studentdao.sort();
				System.out.println("排序完成!");
				break;
			case 5:
				studentdao.select();
				break;
			case 6:
				isOver=true;
				s.close();
				System.out.println("谢谢使用，程序已退出");
				break;
			default:
				System.out.println("无此功能");
				break;
			}
		}
	}
}
