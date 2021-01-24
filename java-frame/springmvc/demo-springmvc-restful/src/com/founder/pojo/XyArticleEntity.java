package com.founder.pojo;

public class XyArticleEntity {
	// article主键
	Integer sys_documentid;
	// 文档库ID
	Integer sys_doclibid;
	Integer sys_folderid;
	Integer sys_deleteflag;
	Integer sys_currentflow;
	Integer sys_islocked;
	// 未发布 在发布 已发布
	Integer sys_currentnode;
	String sys_currentstatus;
	Integer a_status;
	// 排序字段
	Double a_order;
	// 标题
	String sys_topic;
	// 链接标题
	String a_leadTitle;
	// 发布地址
	String a_url;
	// 内容
	String a_content;
	// 来源
	String a_source;
	// 作者
	String sys_authors;
	// 创建/发布时间
	String sys_created;
	String a_pubTime;
	
	//最后修改时间
	String sys_lastmodified;
	// 主栏目
	String a_column;
	// 外链
	String a_multimediaLink;
	
	Integer a_channel = 1;
	//摘要
	String a_abstract;
	
	//站点
	Integer a_siteID;
	Integer a_type;
	Integer a_columnID;
	String a_columnAll;
	
	public void setRecord(Record record){
		//sys_documentid = Integer.parseInt(record.getRID());
		
		a_source = record.getIR_SITENAME();
		sys_authors = record.getIR_AUTHORS();
		a_multimediaLink = record.getIR_URLNAME();
		
		sys_topic = record.getIR_URLTITLE();
		a_leadTitle = record.getIR_URLTITLE();
		
		a_content = record.getIR_CONTENT();
		
		sys_created = record.getIR_URLTIME();
		a_pubTime = record.getIR_URLTIME();
		sys_lastmodified = record.getIR_URLTIME();
		
		a_abstract = record.getIR_ABSTRACT();
		
		//if(record.getSY_INFOTYPE()==9){
		//	a_type = 2;//视频
		//}else{
			a_type = 0;//文章
		//}
		
		//a_column = record.getIR_CHANNEL();
	}
	
	public String getA_abstract() {
		return a_abstract;
	}
	public void setA_abstract(String a_abstract) {
		this.a_abstract = a_abstract;
	}
	public Integer getA_siteID() {
		return a_siteID;
	}
	public void setA_siteID(Integer a_siteID) {
		this.a_siteID = a_siteID;
	}
	public Integer getA_type() {
		return a_type;
	}
	public void setA_type(Integer a_type) {
		this.a_type = a_type;
	}
	public Integer getA_columnID() {
		return a_columnID;
	}
	public void setA_columnID(Integer a_columnID) {
		this.a_columnID = a_columnID;
	}
	public String getA_columnAll() {
		return a_columnAll;
	}
	public void setA_columnAll(String a_columnAll) {
		this.a_columnAll = a_columnAll;
	}
	public Integer getA_channel() {
		return a_channel;
	}
	public void setA_channel(Integer a_channel) {
		this.a_channel = a_channel;
	}
	public String getA_source() {
		return a_source;
	}
	public void setA_source(String a_source) {
		this.a_source = a_source;
	}
	public String getSys_lastmodified() {
		return sys_lastmodified;
	}
	public void setSys_lastmodified(String sys_lastmodified) {
		this.sys_lastmodified = sys_lastmodified;
	}
	public Integer getSys_documentid() {
		return sys_documentid;
	}
	public void setSys_documentid(Integer sys_documentid) {
		this.sys_documentid = sys_documentid;
	}
	public Integer getSys_doclibid() {
		return sys_doclibid;
	}
	public void setSys_doclibid(Integer sys_doclibid) {
		this.sys_doclibid = sys_doclibid;
	}
	public Integer getSys_folderid() {
		return sys_folderid;
	}
	public void setSys_folderid(Integer sys_folderid) {
		this.sys_folderid = sys_folderid;
	}
	public Integer getSys_deleteflag() {
		return sys_deleteflag;
	}
	public void setSys_deleteflag(Integer sys_deleteflag) {
		this.sys_deleteflag = sys_deleteflag;
	}
	public Integer getSys_currentflow() {
		return sys_currentflow;
	}
	public void setSys_currentflow(Integer sys_currentflow) {
		this.sys_currentflow = sys_currentflow;
	}
	public Integer getSys_islocked() {
		return sys_islocked;
	}
	public void setSys_islocked(Integer sys_islocked) {
		this.sys_islocked = sys_islocked;
	}
	public Integer getSys_currentnode() {
		return sys_currentnode;
	}
	public void setSys_currentnode(Integer sys_currentnode) {
		this.sys_currentnode = sys_currentnode;
	}
	public String getSys_currentstatus() {
		return sys_currentstatus;
	}
	public void setSys_currentstatus(String sys_currentstatus) {
		this.sys_currentstatus = sys_currentstatus;
	}
	public Integer getA_status() {
		return a_status;
	}
	public void setA_status(Integer a_status) {
		this.a_status = a_status;
	}
	public Double getA_order() {
		return a_order;
	}
	public void setA_order(Double a_order) {
		this.a_order = a_order;
	}
	public String getSys_topic() {
		return sys_topic;
	}
	public void setSys_topic(String sys_topic) {
		this.sys_topic = sys_topic;
	}
	public String getA_leadTitle() {
		return a_leadTitle;
	}
	public void setA_leadTitle(String a_leadTitle) {
		this.a_leadTitle = a_leadTitle;
	}
	public String getA_url() {
		return a_url;
	}
	public void setA_url(String a_url) {
		this.a_url = a_url;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public String getSys_authors() {
		return sys_authors;
	}
	public void setSys_authors(String sys_authors) {
		this.sys_authors = sys_authors;
	}
	public String getSys_created() {
		return sys_created;
	}
	public void setSys_created(String sys_created) {
		this.sys_created = sys_created;
	}
	public String getA_pubTime() {
		return a_pubTime;
	}
	public void setA_pubTime(String a_pubTime) {
		this.a_pubTime = a_pubTime;
	}
	public String getA_column() {
		return a_column;
	}
	public void setA_column(String a_column) {
		this.a_column = a_column;
	}
	public String getA_multimediaLink() {
		return a_multimediaLink;
	}
	public void setA_multimediaLink(String a_multimediaLink) {
		this.a_multimediaLink = a_multimediaLink;
	}



	@Override
	public String toString() {
		return "XyArticleEntity [sys_documentid=" + sys_documentid + ", sys_doclibid=" + sys_doclibid
				+ ", sys_folderid=" + sys_folderid + ", sys_deleteflag=" + sys_deleteflag + ", sys_currentflow="
				+ sys_currentflow + ", sys_islocked=" + sys_islocked + ", sys_currentnode=" + sys_currentnode
				+ ", sys_currentstatus=" + sys_currentstatus + ", a_status=" + a_status + ", a_order=" + a_order
				+ ", sys_topic=" + sys_topic + ", a_leadTitle=" + a_leadTitle + ", a_url=" + a_url + ", a_content="
				+ a_content + ", a_source=" + a_source + ", sys_authors=" + sys_authors + ", sys_created=" + sys_created
				+ ", a_pubTime=" + a_pubTime + ", sys_lastmodified=" + sys_lastmodified + ", a_column=" + a_column
				+ ", a_multimediaLink=" + a_multimediaLink + ", a_channel=" + a_channel + ", a_siteID=" + a_siteID
				+ ", a_type=" + a_type + ", a_columnID=" + a_columnID + ", a_columnAll=" + a_columnAll + "]";
	}
	
	
	
}
