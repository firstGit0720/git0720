<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"%>
<%@ taglib uri="http://ckfinder.com" prefix="ckfinder"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<%-- <%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/metinfo-a.css" />
<link href="../js/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
	<script src="../js/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
	<script src="../js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>

<body>
	<%=session.getServletContext().getRealPath("/") %>
	<div class="metinfotop">
		<div class="position">
			简体中文：系统设置 > <a href="1.html">基本设置</a>
		</div>

	</div>
	<div class="clear"></div>

	<div class="stat_list">
		<ul>
			<li class="now"><a href="1.html" title="基本信息">基本信息</a></li>
		</ul>
	</div>
	<div style="margin-left: 100px; width: 850px">
		<form role="form">
			<div class="form-group">
				<label for="name">网站名称</label> <input type="text"
					class="form-control" id="name" placeholder="请输入名称">
			</div>
			<div class="form-group">
				<label for="name">网站LOGO</label> <input type="text"
					class="form-control" id="name" placeholder="请输入名称">
			</div>
			<div class="form-group">
				<label for="name">网站网址</label> <input type="text"
					class="form-control" id="name" placeholder="请输入名称">
			</div>
			<div class="form-group">
				<label for="name">网站关键词</label> <input type="text"
					class="form-control" id="name" placeholder="请输入名称">
			</div>
			
				<label for="name">网站描述</label>
				<textarea cols="120" id="editor1" name="editor1" rows="10"></textarea>
				<ckfinder:setupCKEditor basePath="../ckfinder/"
					editor="editor1" />

				<ckeditor:replace replace="editor1" basePath="../ckeditor/" />
			
			<div style="text-align: right;">
				<button type="submit" class="btn btn-default">提交</button>
			</div>
		</form>

	</div>

</body>

</html>