package com.baidu.asset.bean;

import java.util.Date;

import com.baidu.user.bean.User;


public class Asset {
	
	    private String id;
        private String num;
        private String name;
        private Integer typeid;
        private Date buyDate;
        private User user;
        private Integer price;
        private Factory facto;
        private String content;
        
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
		public Integer getTypeid() {
			return typeid;
		}
		public void setTypeid(Integer typeid) {
			this.typeid = typeid;
		}
	
		public Date getBuyDate() {
			return buyDate;
		}
		public void setBuyDate(Date buyDate) {
			this.buyDate = buyDate;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Factory getFacto() {
			return facto;
		}
		public void setFacto(Factory facto) {
			this.facto = facto;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
        
		
}
