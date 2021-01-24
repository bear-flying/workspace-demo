package com.baidu.dept.bean;

import com.baidu.user.bean.User;


public class Dept {
	      private Integer id;
          private String deptName;
          private Dept pdept;
          private String firstUser;
          private String secondUser;
          private String secretary;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getDeptName() {
			return deptName;
		}
		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}
		
		public Dept getPdept() {
			return pdept;
		}
		public void setPdept(Dept pdept) {
			this.pdept = pdept;
		}
		
		public String getFirstUser() {
			return firstUser;
		}
		public void setFirstUser(String firstUser) {
			this.firstUser = firstUser;
		}
		public String getSecondUser() {
			return secondUser;
		}
		public void setSecondUser(String secondUser) {
			this.secondUser = secondUser;
		}
		public String getSecretary() {
			return secretary;
		}
		public void setSecretary(String secretary) {
			this.secretary = secretary;
		}
		
		@Override
		public String toString() {
			return "Dept [id=" + id + ", deptName=" + deptName + ", pdept="
					+ pdept + ", firstUser=" + firstUser + ", secondUser="
					+ secondUser + ", secretary=" + secretary + "]";
		}
		public Dept() {
			super();
		}
		
		
}
