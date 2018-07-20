<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@ page import="java.util.List"%>
<%@ page import="com.mmsg.cms.vo.UserInfo"%>
<%@ page import="com.mmsg.cms.dbutil.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>会员信息查询</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="<%=application.getContextPath() %>/js/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<!-- jQuery(Bootstrap)的所有JavaScript插件都依赖JQuery，所以必须放在前边-->
<script type="text/javascript"
	src="<%=application.getContextPath() %>/js/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script type="text/javascript"
	src="<%=application.getContextPath() %>/js/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script >
    	$("#delete").on("click",delete);
    	function delete(){
    		alert("asdasd");
    	}
    	
    </script>
    

<%
	List<UserInfo> selectNameList = (List) request.getAttribute("selectNameList");
	
	Page p = (Page) request.getAttribute("page");
	%>
</head>
<body >
	<center>
		<div class="cx">
			<center>
				<form action="SelectByNameServlet" method="post">
					<h2>
						请输入要查询的会员的名字：<input type="text" id="selectname" name="selectname"
							size="16" style="height: 30px" /> <input type="submit" value="查询" />
					</h2>
				</form>
			</center>
		</div>
	</center>
	<div class="container" class="hide">
		<table
			class="table table-bordered table-striped table-hover table-responsive">
			<tr>
				<th><span class="glyphicon glyphicon-th-list"></span>会员编号</th>
				<th>姓名</th>
				<th>密码</th>
				<th>手机号</th>
				<th>性别</th>
				<th>邮箱</th>
				<th>出生日期</th>
				<th>学历</th>
				<th>操作</th>
			</tr>
			<%if(selectNameList.size() == 0){
				%>
					<tr>
					<td>  </td>
					<td>  </td>
					<td>  </td>
					<td>没有此人的信息！</td>
					<td>  </td>
					<td>  </td>
					<td>  </td>
					</tr>
				<%
			}
    		for(UserInfo u: selectNameList)
    		{%>
			<tr>
				<td><%=u.getId() %></td>
				<td><%=u.getUsername() %></td>
				<td><%=u.getPassword() %></td>
				<td><%=u.getTelephone() %></td>
				<td><%=u.getGender() %></td>
				<td><%=u.getEmail() %></td>
				<td><%=u.getBorndate() %></td>
				<td><%=u.getEducation() %></td>
				<td>
					<button class="btn btn-success">编辑</button>
					<button class="btn btn-danger" data-toggle="modal"
						data-target="#myModal">删除</button>
				</td>
			</tr>
			<%} %>
		</table>
		<div class="btn-group" style="float: right;">
			<a class="btn btn-default"
				href="<%=application.getContextPath() %>/SelectByNameServlet?cp=<%=p.getPrevPage() %>
				&selectname=<%=request.getAttribute("selectname") %>">&laquo;</a>
			<% for(int i=1;i<p.getToral()+1; i++) { %>
			<a class="btn btn-default"
				href="<%=application.getContextPath() %>/SelectByNameServlet?cp=<%=i %>
				&selectname=<%=request.getAttribute("selectname") %>"><%=i %></a>
			<%} %>
			<a class="btn btn-default"
				href="<%=application.getContextPath() %>/SelectByNameServlet?cp=<%=p.getNextPage()%>
				&selectname=<%=request.getAttribute("selectname") %>">&raquo;</a>
		</div>
	</div>
	<!--定义模态框-->
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
    				<button class="btn btn-default" data-dismiss="modal">close</button>
    				<button class="btn btn-primary" id="delete" >ok</button>
    			</div>
    		</div>
    	</div>
    </div>

</body>
</html>