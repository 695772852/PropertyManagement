<%@page import="java.util.Date"%>
<%@page import="com.kgc.pojo.News"%>
<%@page import="java.io.*,java.util.*,org.apache.commons.fileupload.*"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%@include file="../common/common.jsp" %>
<body>
<%
	//接收增加的新闻信息，并调用后台方法，将新闻信息插入数据库
	request.setCharacterEncoding("utf-8");
	boolean bRet = false;
	boolean bUpload = false;
	String uploadFileName = "";
	String fieldName = "";
	News news = new News();
	news.setCreateDate(new Date());
	//解析请求之前先判断请求类型是否为文件上传类型
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	//指定上传位置
	String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
	
	File saveDir = new File(uploadFilePath);  
	//如果目录不存在，就创建目录  
	if(!saveDir.exists()){  
	    saveDir.mkdir();  
	}  
	
	if(isMultipart){
		//创建文件上传核心类 
		FileItemFactory factory = new DiskFileItemFactory(); // 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory); // 用以上工厂实例化上传组件
		try{
			//处理表单请求
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while(iter.hasNext()){
				FileItem item = (FileItem)iter.next();
				if(item.isFormField()){// 如果是普通表单控件 
					fieldName = item.getFieldName();// 获得该字段名称
					if(fieldName.equals("title")){
						news.setTitle(item.getString("UTF-8"));//获得该字段值 
					}else if(fieldName.equals("categoryId")){
						news.setCategoryId(Integer.parseInt(item.getString()));
					}else if(fieldName.equals("summary")){
						news.setSummary(item.getString("UTF-8"));
					}else if(fieldName.equals("newscontent")){
						news.setContent(item.getString("UTF-8"));
					}else if(fieldName.equals("author")){
						news.setAuthor(item.getString("UTF-8"));
					}
				}else{// 如果为文件域
					String fileName = item.getName();// 获得文件名(全路径)
					if(fileName != null && !fileName.equals("")){
						File fullFile = new File(fileName);
						File saveFile = new File(uploadFilePath,fullFile.getName());//将文件保存到指定的路径
						item.write(saveFile);
						uploadFileName = fullFile.getName();
						news.setPicPath(uploadFileName);
						bUpload = true;
					
					}
				
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	System.out.println("上传成功之后的文件名：" + news.getPicPath());
	//调用后台的方法，将新闻信息插入数据库中
	bRet = newsService.add(news);
	if(bRet)
		response.sendRedirect("newsDetailList.jsp");
	else
		response.sendRedirect("newsDetailCreateSimple.jsp");
	
%>

</body>
</html>