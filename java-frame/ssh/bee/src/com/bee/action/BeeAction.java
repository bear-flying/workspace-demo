package com.bee.action;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bee.pojo.Bee;
import com.bee.pojo.KindOfBee;
import com.bee.service.BeeService;
import com.bee.service.KindOfBeeService;
import com.bee.utils.FileDownLoad;
import com.bee.utils.FileUpload;
import com.bee.utils.JiangYuPageUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.beanutils.BeanUtils;


public class BeeAction extends ActionSupport implements ModelDriven<Bee> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BeeService bs = new BeeService();
	private KindOfBeeService ks = new KindOfBeeService();
	
	private JiangYuPageUtil<Bee> jiangYu = new JiangYuPageUtil<Bee>();
	private Bee bee = new Bee();
	private List<KindOfBee> list; 
	private List<String> hobbyList;
	
	public String findAll(){
		System.out.println("~~findAll~~");
		int page = (jiangYu.getCurrentPageNo()==null?1:jiangYu.getCurrentPageNo());
		int pageSize = 3;
		List<Bee> list = null;
		//List<Bee> list = bs.findAll(page,pageSize);
		System.out.println("---------"+bee.getName());
		if(bee.getName()!=null){
			list = bs.findAll2(page,pageSize,bee.getName());
		}else{
			list = bs.findAll(page,pageSize);
		}
		int result = bs.getCount();
		jiangYu = JiangYuPageUtil.page("bee", "bees", "bee!findAll.action", result, page, pageSize, list);
		return "found";
	}

	public String toAdd(){
		System.out.println("~~toAdd~~");
		list = ks.findAll();
		return "append";
	}
	public String change(){
		
		System.out.println("~~change~~");
		return "success";
	}
	
	public String add() throws Exception{
		System.out.println("~~add~~");
		//�����еõ������ϴ��� ͼƬλ�õ�ȫ·��
		System.out.println(bee.getFilepath());
		//���ַ�ת����File���� �ṩ�����
		File file = new File(bee.getFilepath());
		//ͨ����� ��ȫ·������ת��֮���ͼƬ��
		String f = FileUpload.upload(bee.getFilepath(), file);
		bee.setFilepath(f);
		bs.add(bee);
		
		return "success";
	}
	
	public String findOne() throws Exception{
		System.out.println("~~findOne~~");
		Bee b = bs.findOne(bee.getCid());
		BeanUtils.copyProperties(bee,b);
		if(bee.getHobby()!=null){
			String[] s = bee.getHobby().split(", ");
			hobbyList = Arrays.asList(s);
			//ServletActionContext.getRequest().setAttribute("hobbys", hobbyList);
		}
		list = ks.findAll();

		return "foundOne";
	}
	
	public String modify() throws Exception{
		System.out.println("~~modify~~");
		File file = new File(bee.getFilepath());
		String f = FileUpload.upload(bee.getFilepath(), file);
		bee.setFilepath(f);
//		String a = "";
//		System.out.println(hobbyList+"-----------");
//		for (String s : hobbyList) {
//			a=a+s+", ";
//		}
//		a= a.substring(0,a.length()-1);
//		System.out.println(a);
//		bee.setHobby(a);
		bs.modify(bee);
		return "success";
	}
	
	public String remove() throws Exception{
		System.out.println("~~remove~~");
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		System.out.println(ids+"````````````");
		bs.remove(ids);
		
		return "success";
	}

	
	public String download() throws Exception{
		System.out.println("~~download~~");
		//�õ��ļ���
		String filename = bee.getFilepath();
				
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//����
		FileDownLoad.download("\\upload\\"+filename, request, response);
		
		return NONE;
	}
	
	public Bee getModel() {
		// TODO Auto-generated method stub
		return bee;
	}

	public JiangYuPageUtil<Bee> getJiangYu() {
		return jiangYu;
	}

	public void setJiangYu(JiangYuPageUtil<Bee> jiangYu) {
		this.jiangYu = jiangYu;
	}

	public Bee getBee() {
		return bee;
	}

	public void setBee(Bee bee) {
		this.bee = bee;
	}

	public List<KindOfBee> getList() {
		return list;
	}

	public void setList(List<KindOfBee> list) {
		this.list = list;
	}



	public List<String> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}

	
	
}
