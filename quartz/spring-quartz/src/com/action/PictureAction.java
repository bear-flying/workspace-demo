package com.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.entity.Picture;
import com.service.PictureService;
import com.util.FileDownLoad;

public class PictureAction {
	private PictureService service;

	private List<?> list;

	private Picture picture;
	
	private File myfile;

	private String myfileFileName;

	public String list() {

		list = service.list();

		return "list";
	}

	public String addPicture() {
		String myfilename = getMyfileFileName();

		if (myfilename != null && !"".equals(myfilename)) {
			myfilename = UUID.randomUUID().toString().replace("-", "")
					+ myfilename.substring(myfilename.lastIndexOf("."));

			String filename = ServletActionContext.getServletContext()
					.getRealPath("")
					+ File.separator
					+ "upload"
					+ File.separator + myfilename;

			File newFile = new File(filename);
			try {
				FileUtils.copyFile(myfile, newFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			myfilename = "";
		}
		if (picture == null) {
			picture = new Picture();
		}
		picture.setFilename(myfilename);
		service.addPicture(picture);
		return "success";
	}

	
	public String download() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String filename = "/upload/" + picture.getFilename();
		FileDownLoad.download(filename, request, response);
		return null;
	}

	public PictureService getService() {
		return service;
	}

	public void setService(PictureService service) {
		this.service = service;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

}
