package com.founder.datamover.po;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.util.DateUtils;

public class Article implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(Article.class);
	
	private static Pattern imgPattern = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>",Pattern.CASE_INSENSITIVE);
	
	private String sourceSystem;
	
	// 稿件ID
	private String docId;

	// 稿件创建时间
	private String createTime;
	
	// 副题
	private String subTitle;
	
	// 链接标题
	private String linkTitle;
		
	// 标题
	private String title;	
	
	private String introTitle;

	// 摘要
	private String artAbstract;
	
	// 关键字
	private String keyword;
	
	private String tag;
	
	// 发布时间
	private String pubTime;

	// 发布状态	2已发布/3待签发
	private int publishState;
	
	// 来源名称
	private String sourceName;
		
	// 来源链接
	private String sourceUrl;
	
	private String region;
	
	// 作者（文章原始作者）
	private String author;
	
	private String editor;
	
	private String liability;
	
	//小标题图片
	private String smallTitlePic;
	
	private String middleTitlePic;
	
	private String bigTitlePic;
	
	private String targetLib;
	
	private String targetNode;
	
	// 栏目ID
	private String targetNodeId;
	
	private String relatedNodeId;
	
	private String userName;
	
	private String loginName;
	
	// 稿件属性
	private int attr = 63;
	
	private String hasTitlePic;
	
	
	private String picLinks;
	
	// 标题图片的流
	private byte[] piclinkIs;
	
	// 正文总字数
	private int wordCount;
	
	// 优先级
	private int importance;
	
	// 稿件的内容信息在这个连接中
	private String url;
	
	// 多媒体链接
	private String multiattach;
	
	// 图片个数
	private int picCount = 0;

	private int pageNo;
	// 正文
	private String content;
	
	// 组图字符串
	private String arrimg;
	
	private String expirationTime = "2099-12-31 23:59:59";
	
	// 本稿件是否置顶 0 不置顶 1 置顶
	private int isTop = 0;
	
	// 当前执行的SqlId
	private String currSqlId;
	
	private List<Attachement> attachementList = new ArrayList<Attachement>();
	
	//组图图片路径
	private String morepic;
	
	private List<Attachement> morepicList = new ArrayList<Attachement>();
	
	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getTargetLib() {
		return targetLib;
	}

	public void setTargetLib(String targetLib) {
		this.targetLib = targetLib;
	}

	public String getTargetNode() {
		return targetNode;
	}

	public void setTargetNode(String targetNode) {
		this.targetNode = targetNode;
	}

	public String getTargetNodeId() {
		return targetNodeId;
	}

	public void setTargetNodeId(String targetNodeId) {
		this.targetNodeId = targetNodeId;
	}

	public String getRelatedNodeId() {
		return relatedNodeId;
	}

	public void setRelatedNodeId(String relatedNodeId) {
		this.relatedNodeId = relatedNodeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getIntroTitle() {
		return introTitle;
	}

	public void setIntroTitle(String introTitle) {
		this.introTitle = introTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getArtAbstract() {
		return artAbstract;
	}

	public void setArtAbstract(String artAbstract) {
		this.artAbstract = artAbstract;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public int getAttr() {
		return attr;
	}

	public void setAttr(int attr) {
		this.attr = attr;
	}

	public String getHasTitlePic() {
		return hasTitlePic;
	}

	public void setHasTitlePic(String hasTitlePic) {
		if(hasTitlePic == null || hasTitlePic.length()==0){
			hasTitlePic = "0";
		}
		this.hasTitlePic = hasTitlePic;
	}

	public String getPicLinks() {
		return picLinks;
	}

	public void setPicLinks(String picLinks) {
		this.picLinks = picLinks;
	}

	public byte[] getPiclinkIs() {
		return piclinkIs;
	}

	public void setPiclinkIs(byte[] piclinkIs) {
		this.piclinkIs = piclinkIs;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPicCount() {
		return picCount;
	}

	public void setPicCount(int picCount) {
		this.picCount = picCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getContent() {
//		content = StringUtils.replace(content, "\n", "<br/>");
//		content = StringUtils.replace(content, "&nbsp;&nbsp;", "　");
//		content = StringUtils.replace(content, "　", "  ");
//		content = StringUtils.replace(content, "    ", "  ");
//		content = StringUtils.replace(content, "  ", "　　");
//		content = StringUtils.replace(content, "", "");
//		if(pageNo > 1){
//			content = StringUtils.replace(content, "#p#分页标题#e#", "<hr/>");
//		}
		if(content == null){
			return "";
		}
		content = StringUtils.replace(content, "\\\"", "\"");
		content = StringUtils.replace(content, "[!--empirenews.insertAd--]", "");
		content = content.replaceAll("<p(.*?)>\\[!--empirenews.page--\\]</p>", "<hr/>");
		//content = StringUtils.replace(content, "<p(.*?)>[!--empirenews.page--]</p>", "<hr/>");
		content = StringUtils.replace(content, "[!--empirenews.page--]", "<hr/>");
		Matcher contentMatcher = imgPattern.matcher(content);
		Attachement att = null;
		while(contentMatcher.find()){
			att = new Attachement();
			att.setAttPath(contentMatcher.group(1));
			att.setTitle(title);
			attachementList.add(att);
		}
//		if(StringUtils.startsWith(arrimg, TITLE_STR)){
//			arrimg = StringUtils.replace(arrimg, TITLE_STR, "");
//			arrimg = StringUtils.replace(arrimg, PIC_STR, "");
//			arrimg = StringUtils.replace(arrimg, THUMB_STR, "");
//			String[] arrimgs = StringUtils.substringsBetween(arrimg, "\"", "\"");
//			int piccount = arrimgs.length/3;
//			StringBuffer contentSb = new StringBuffer();
//			for(int i=0;i<piccount;i++){
//				att = new Attachement();
//				att.setAttPath(arrimgs[i+piccount]);
//				att.setTitle(arrimgs[i]);
//				attachementList.add(att);
//				contentSb.append("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"><tr><td align=\"center\">");
//				contentSb.append("<img src=\"").append(att.getAttPath()).append("\"");
//				if(att.getTitle()!=null && att.getTitle().trim().length()>0){
//					contentSb.append(" alt=\"").append(att.getTitle()).append("\"");
//				}
//				contentSb.append(" style=\"border:3px solid #999999; \">");
//				contentSb.append("</td></tr></table>");
//				if(att.getTitle()!=null && att.getTitle().trim().length()>0){
//					contentSb.append("<p align=\"center\">").append(att.getTitle()).append("</p>");
//				}
//				contentSb.append(content);
//				if(i<piccount-1){
//					contentSb.append("<hr/>");
//				}
//				if(i==piccount-1){
//					content = contentSb.toString();
//				}
//			}
//		}
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPubTime() {
		return pubTime;
	}

	public void setPubTime(long pubTime){
		log.info("pubTime=="+pubTime);
		this.pubTime = DateUtils.formatDate(pubTime*1000L,null);
	}
	
//	public void setPubTime(String pubTime) {
//		String[] parsePatterns = {
//				"yyyy-MM-dd HH:mm:ss",
//				"yyyy-MM-dd HH:mm",
//				"yyyy-MM-dd HH",
//				"yyyy-MM-dd",
//				"MM-dd HH:mm",
//				"MM-dd",
//				"yy-M-dd",
//				"yy-M-ddd",
//				"yy-MM-ddd",
//				"yy-MM-dd",
//				"yyyy-MMM-d",
//				"yyyy-MMM-dd",
//				"yyyy-M-ddd",
//				"yyyy-M-dd",
//				"yyyy-M-d",
//				"yyyyMMdd HH:mm:ss",
//				"yyyyMMdd HH:mm",
//				"yyyyMMdd HH",
//				"yyyyMMdd",
//				"MMdd HH:mm",
//				"MMdd",
//				"yyyy/MM/dd HH:mm:ss",
//				"yyyy/MM/dd HH:mm",
//				"yyyy/MM/dd HH",
//				"yyyy/MM/dd",
//				"MM/dd HH:mm",
//				"MM/dd",
//				"yyyy年MM月dd日 HH时mm分ss秒",
//				"yyyy年MM月dd日 HH:mm:ss",
//				"yyyy年MM月dd日 HH:mm",
//				"yyyy年MM月dd日 HH",
//				"MM月dd日 HH:mm:ss",
//				"MM月dd日 HH:mm",
//				"MM月dd日"};
//		try {
//			if(pubTime != null && pubTime.endsWith(".0")){
//				pubTime = pubTime.substring(0,pubTime.length()-2);
//			}
//			Date date = org.apache.commons.lang.time.DateUtils.parseDate(pubTime, parsePatterns);
//			String newDate = org.apache.commons.lang.time.DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
//			log.debug("pubTime = "+pubTime+"\tnewDate = "+newDate);
//			this.pubTime = newDate;
//		} catch (ParseException e) {
//			log.error("pubTime = "+pubTime+"\t"+e.getMessage());
//			this.pubTime = pubTime;
//		}
//	}

	public int getPublishState() {
		return publishState;
	}

	public void setPublishState(int publishState) {
		this.publishState = publishState;
	}
	
	public String getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public List<Attachement> getAttachementList() {
		return attachementList;
	}

	public void setAttachementList(List<Attachement> attachementList) {
		this.attachementList = attachementList;
	}

	public String getCurrSqlId() {
		return currSqlId;
	}

	public void setCurrSqlId(String currSqlId) {
		this.currSqlId = currSqlId;
	}

	public String getLinkTitle() {
		return linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	public String getMultiattach() {
		return multiattach;
	}

	public void setMultiattach(String multiattach) {
		this.multiattach = multiattach;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getLiability() {
		return liability;
	}

	public void setLiability(String liability) {
		this.liability = liability;
	}

	public String getSmallTitlePic() {
		return smallTitlePic;
	}

	public void setSmallTitlePic(String smallTitlePic) {
		this.smallTitlePic = smallTitlePic;
	}

	public String getMiddleTitlePic() {
		return middleTitlePic;
	}

	public void setMiddleTitlePic(String middleTitlePic) {
		this.middleTitlePic = middleTitlePic;
	}

	public String getBigTitlePic() {
		return bigTitlePic;
	}

	public void setBigTitlePic(String bigTitlePic) {
		this.bigTitlePic = bigTitlePic;
	}

	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}



	private static final String TITLE_STR = "a:3:{s:5:\"title\";a:";
	
	private static final String PIC_STR = "s:3:\"pic\";a:";
	
	private static final String THUMB_STR = "s:5:\"thumb\";a:";
	
	private static String[] parseArrimg(String arrimg){
		if(StringUtils.startsWith(arrimg, TITLE_STR)){
			arrimg = StringUtils.replace(arrimg, TITLE_STR, "");
			arrimg = StringUtils.replace(arrimg, PIC_STR, "");
			arrimg = StringUtils.replace(arrimg, THUMB_STR, "");
			return StringUtils.substringsBetween(arrimg, "\"", "\"");
		}
		return null;
	}
	
	public static void main(String[] args){
		String arrimg = "a:3:{s:5:\"title\";a:13:{i:0;s:0:\"\";i:1;s:0:\"\";i:2;s:0:\"\";i:3;s:0:\"\";i:4;s:0:\"\";i:5;s:0:\"\";i:6;s:0:\"\";i:7;s:0:\"\";i:8;s:0:\"\";i:9;s:0:\"\";i:10;s:0:\"\";i:11;s:0:\"\";i:12;s:0:\"\";}s:3:\"pic\";a:13:{i:0;s:48:\"/Public/Arrimg/201302/13618646141035841358_0.jpg\";i:1;s:48:\"/Public/Arrimg/201302/13618646141035841358_1.jpg\";i:2;s:48:\"/Public/Arrimg/201302/13618646141035841358_2.jpg\";i:3;s:48:\"/Public/Arrimg/201302/13618646151035841358_0.jpg\";i:4;s:48:\"/Public/Arrimg/201302/13618646151035841358_1.jpg\";i:5;s:48:\"/Public/Arrimg/201302/13618646151035841358_2.jpg\";i:6;s:48:\"/Public/Arrimg/201302/13618646161035841358_0.jpg\";i:7;s:48:\"/Public/Arrimg/201302/13618646161035841358_1.jpg\";i:8;s:48:\"/Public/Arrimg/201302/13618646161035841358_2.jpg\";i:9;s:48:\"/Public/Arrimg/201302/13618646171035841358_0.jpg\";i:10;s:48:\"/Public/Arrimg/201302/13618646171035841358_1.jpg\";i:11;s:48:\"/Public/Arrimg/201302/13618646171035841358_2.jpg\";i:12;s:48:\"/Public/Arrimg/201302/13618646181035841358_0.jpg\";}s:5:\"thumb\";a:13:{i:0;s:54:\"/Public/Arrimg/201302/13618646141035841358_0_thumb.jpg\";i:1;s:54:\"/Public/Arrimg/201302/13618646141035841358_1_thumb.jpg\";i:2;s:54:\"/Public/Arrimg/201302/13618646141035841358_2_thumb.jpg\";i:3;s:54:\"/Public/Arrimg/201302/13618646151035841358_0_thumb.jpg\";i:4;s:54:\"/Public/Arrimg/201302/13618646151035841358_1_thumb.jpg\";i:5;s:54:\"/Public/Arrimg/201302/13618646151035841358_2_thumb.jpg\";i:6;s:54:\"/Public/Arrimg/201302/13618646161035841358_0_thumb.jpg\";i:7;s:54:\"/Public/Arrimg/201302/13618646161035841358_1_thumb.jpg\";i:8;s:54:\"/Public/Arrimg/201302/13618646161035841358_2_thumb.jpg\";i:9;s:54:\"/Public/Arrimg/201302/13618646171035841358_0_thumb.jpg\";i:10;s:54:\"/Public/Arrimg/201302/13618646171035841358_1_thumb.jpg\";i:11;s:54:\"/Public/Arrimg/201302/13618646171035841358_2_thumb.jpg\";i:12;s:54:\"/Public/Arrimg/201302/13618646181035841358_0_thumb.jpg\";}}";
		String[] arrimgs = parseArrimg(arrimg);
		System.out.println(arrimgs.length);
		for(String img : arrimgs){
			System.out.println(img);
		}
	}

	public String getArrimg() {
		return arrimg;
	}

	public void setArrimg(String arrimg) {
		this.arrimg = arrimg;
	}

	public String getMorepic() {
		return morepic;
	}

	public void setMorepic(String morepic) {
		this.morepic = morepic;
	}

	public List<Attachement> getMorepicList() {
		Attachement attache = null;
		String[] picdatas = this.getMorepic().split("\n");
		if(picdatas.length>0){
			for (String data : picdatas) {
				String[] attrs = data.split("::::::");
				if(attrs.length>0){
					attache = new Attachement();
					attache.setAttPath(attrs[1]);
					attache.setTitle("");
					if(attrs.length==3){
						attache.setTitle(attrs[2]);
					}
					morepicList.add(attache);
				}		
			}
		}
		return morepicList;
	}

	public void setMorepicList(List<Attachement> morepicList) {
		this.morepicList = morepicList;
	}

	
}
