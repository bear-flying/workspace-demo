package com.doctor.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.doctor.pojo.Doctor;
import com.doctor.pojo.Xl;
import com.doctor.service.DoctorService;
import com.doctor.service.Xlservice;
import com.doctor.utils.PageBean;

public class DoctorAction extends DispatchAction {

	private DoctorService ds = new DoctorService();
	private Xlservice xs = new Xlservice();
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：查询所有医生
	 */
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		String page = request.getParameter("page");

		String pageSize = request.getParameter("pageSize");
		
		
		if(page==null){
			page="1";
		}
		if(pageSize==null){
			pageSize="2";
		}
		
		System.out.println(page);
		
		PageBean<Doctor> pagebean = ds.queryAll(new Integer(page),new Integer(pageSize));
		
		request.setAttribute("pagebean", pagebean);
		
		return mapping.findForward("success");
	}
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：查询一个医生
	 */
	public ActionForward queryOne(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		// TODO Auto-generated method stub
		
		Doctor d = (Doctor)form;
		
		//System.out.println(d.getId());
		
		List<Xl> list = xs.query();
		//System.out.println(list.get(1).toString());
		
		Doctor dd = ds.queryOne(d.getId());
		
		request.setAttribute("list", list);
		
		request.setAttribute("dd", dd);
		
		return mapping.findForward("upsuccess");
	}
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：转到修改页面
	 */
	public ActionForward toSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		// TODO Auto-generated method stub
		
		List<Xl> list = xs.query();
		
		request.setAttribute("list", list);
		
		return mapping.findForward("sasuccess");
	}
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：添加医生
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		// TODO Auto-generated method stub
		
		Doctor d = (Doctor)form;
		
		
		
		ds.add(d);
	
		
		return mapping.findForward("addsuccess");
	}
	/**
	 * 作者：1405javab姜宇
	 * 时间：2015-09-07
	 * 功能：修改医生
	 */
	public ActionForward alter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		Doctor d = (Doctor)form;
		
		
		
		ds.alter(d);
	
		
		return mapping.findForward("altersuccess");
	}
	
	
}
