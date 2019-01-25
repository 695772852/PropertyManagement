<%@page import="com.kgc.pojo.News"%>
<%@page import="java.util.List"%>
<%@page import="com.kgc.service.impl.NewsServiceImpl"%>
<%@page import="com.kgc.service.NewsService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%--动态包含无法使用，页面报错，newsService无法使用 <jsp:include page="../common/common.jsp" /> --%>
<%@include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<style type="text/css">
<!--

-->
</style>
<script>
	function addNews(){
		window.location="newsDetailCreateSimple.jsp";
	}
</script>
</head>

<body>

<!--主体-->
    <div class="main-content-right">
        <!--即时新闻-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <form name ="searchForm" id="searchForm" action="/news/jsp/admin/newsDetailList.jsp" method="post">
		 	          <div>
		 				新闻分类：
		 					<select name="categoryId">
		 						<option value="0">全部</option>
			        			
			        				<option value='1' >国内</option>
			        			
			        				<option value='2' >国际</option>
			        			
			        				<option value='3' >娱乐</option>
			        			
			        				<option value='4' >军事</option>
			        			
			        				<option value='5' >财经</option>
			        			
			        				<option value='6' >天气</option>
			        			
	        				</select>
		 				新闻标题<input type="text" name="title" id="title" value=''/>
		 					<button type="submit" class="page-btn">GO</button>
		 					<button type="button" onclick="addNews();" class="page-btn">增加</button>
		 					<input type="hidden" name="currentPageNo" value="1"/>
		 					<input type="hidden" name="pageSize" value="10"/>
		 					<input type="hidden" name="totalPageCount" value="2"/>
		 	</div>
		 	</form>
			<table cellpadding="1" cellspacing="1" class="admin-list">
				<thead >
					<tr class="admin-list-head">
						<th>新闻标题</th>
                        <th>作者</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                	<%
                		List<News> newsList = newsService.getNewsList();
                		int i= 0;
                		for(News news:newsList){
                			i++;
                	 %>
                	<tr <%if(i%2==0){ %>class="admin-list-td-h2"<%} %>>
                		<td><a href='newsDetailView.jsp?id=<%=news.getId()%>'><%=news.getTitle() %></a></td>
                		<td><%=news.getAuthor() %></td>
                		<td><%=news.getCreateDate() %></td>
                		<td><a href='adminNewsCreate.jsp?id=2'>修改</a>
                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=2'">删除</a>
                		</td>
                	</tr> 
                	<%} %>
                </tbody>
            </table>
           <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共7条记录&nbsp;&nbsp; 1/2页</li>
				<a href="javascript:page_nav(document.forms[0],2);">下一页</a>
				<a href="javascript:page_nav(document.forms[0],2);">最后一页</a>&nbsp;&nbsp;
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div> 
        </div>
       </div>
   </div>
   </div>
</body></html>