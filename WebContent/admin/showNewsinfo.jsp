<%@ page import="java.util.List" %>
<%@ page import="com.mmsg.cms.vo.NewsInfo" %>
<%@ page import="com.mmsg.cms.dbutil.Page" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>新闻显示修改</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="<%=application.getContextPath() %>/js/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
	<!-- jQuery(Bootstrap)的所有JavaScript插件都依赖JQuery，所以必须放在前边-->
	<script type="text/javascript" src="<%=application.getContextPath() %>/js/bootstrap-3.3.5-dist/js/jquery.min.js" ></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script type="text/javascript" src="<%=application.getContextPath() %>/js/bootstrap-3.3.5-dist/js/bootstrap.js" ></script>
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
    	function deletenews(){
    		$.ajax({
    			type:"post",
    			url:"deleteNewsServlet",
    			async:false,
    			data:{
    				"newsid":$("#newsID").val(),
    			},
    			success:function(data){
					if(data == "ok"){
						alert("新闻删除成功！")
						window.location.reload();
					}else{
						alert("新闻删除失败！")
						window.location.reload();
					}	
				}
    			
    		});
    	}
    	
    </script>
       <%
    	List<NewsInfo> newsList =(List) request.getAttribute("newslist");
  
    	Page p = (Page) request.getAttribute("page");
    	
    %>
</head>
<body style="background: #0FCCBC;">
 <div class="container" >
    <br>
    	<table class="table table-bordered table-striped table-hover table-responsive">
    		<caption align="top" style="font-size: 20px; text-align: center; color: #FF0000;"><b>新闻信息显示</b></caption> 
    		<tr>
    			<th><span class="glyphicon glyphicon-th-list"></span>新闻编号</th>
    			<th>新闻标题</th>
    			<th>新闻类型</th>
    			<th>新闻点击量</th>
    			<th>新闻内容</th>
    			<th>新闻修改时间</th>
    			<th>操作</th>
    		</tr>
    		 <% 

    		for(NewsInfo news: newsList){

    		%>
    			<tr>
    				<td><%=news.getNews_id() %></td>
    				<td><%=news.getNews_title() %></td>
    				<td><%=news.getNews_type() %></td>
    				<td><%=news.getNews_count() %></td>
    				<td style="width: 200px;"><%=news.getNews_content() %></td>
    				<td><%=news.getNews_upDate() %></td>
					<td>
						<a href="admin/updateNews.jsp?news_title=<%=news.getNews_title() %>"><button class="btn btn-success" data-toggle="modal"
						data-target="#myUpdate" >修改</button></a>
					<button class="btn btn-danger" data-toggle="modal"
						data-target="#myModal" id="newsID" value="<%=news.getNews_id() %>">删除</button>
					</td>
    			</tr>
    		<%} %>
    	</table>
    	<div class="btn-group" style="float: right;">
    		<a class="btn btn-default" href="<%=application.getContextPath() %>/showNewsinfoServlet?cp=<%=p.getPrevPage() %>">&laquo;</a>
    		<% for(int i=1;i<p.getToral()+1; i++) { %>
    		<a class="btn btn-default" href="<%=application.getContextPath() %>/showNewsinfoServlet?cp=<%=i %>"><%=i %></a>
    		<%} %>
    		<a class="btn btn-default" href="<%=application.getContextPath() %>/showNewsinfoServlet?cp=<%=p.getNextPage()%>">&raquo;</a>
    	</div>
    		
    </div>
	<!--定义删除模态框-->
    <div class="modal fade" id="myModal">
    	<!--定义会话层-->
    	<div class="modal-dialog">
    		<!--定义显示内容的容器-->
    		<div class="modal-content">
    			<div class="modal-header">
    				<button class="close" data-dismiss="modal">&times;</button>
    				<h4>我是标题</h4>
    			</div>
    			
    			<div class="modal-body">
    				是否删除？
    			</div>
    			<div class="modal-footer">
    				<button class="btn btn-default" data-dismiss="modal">否</button>
    				<button class="btn "  id="delete" onclick="deletenews()">是</button>
    			</div>
    		</div>
    	</div>
    </div>
    
  </body>
  
</html>