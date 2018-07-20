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
	<!--<script>
		function addNews(){
			alert("kabdjb")
			$.ajax({
				type:"post",
				url:"../addNewsInfoServlet",
				async:false,
				data{
				},success:function(data){		
					if(data == "ok"){
						alert("信息插入成功！");
				}
				else {
					alert("插入失败！");
				}
				
			});
		}
			
	</script>-->
	
</head>

<body style="background: #0FCCBC;">
	<%=session.getServletContext().getRealPath("/") %>
	<div class="metinfotop">
		<div class="position">
			简体中文：系统设置 > <a href="1.html">基本设置</a>
		</div>

	</div>
	<div class="clear"></div>

	<div class="stat_list">
		<ul>
			<li class="now"><a href="addNewsInfo.jsp" title="新闻发布">新闻发布</a></li>
		</ul>
	</div>
	<div style="margin-left: 100px; width: 850px">
		<form role="form" action="../addNewsInfoServlet">
			<div class="form-group">
				<label for="name">新闻标题</label> <input type="text" id="newstitle" name="newstitle"
					class="form-control" id="name" placeholder="请输入新闻标题">
			</div>
				<div class="form-group">
				<label for="name">新闻类别</label> <div id="type">
					<select id="newstype" name="newstype">
						<option id="null" value="">***请选择新闻类型***</option>
						<option id="type" name="type" value="娱乐新闻">娱乐新闻</option>
						<option id="type" name="type" value="财经新闻">财经新闻</option>
						<option id="type" name="type" value="体育新闻">体育新闻</option>
						<option id="type" name="type" value="科技新闻">科技新闻</option>
						<option id="type" name="type" value="生活新闻">生活新闻</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="name">新闻点击量</label> <input type="text" id="newscount" name="newscount"
					class="form-control" id="name" placeholder="请输入点击数量">
			</div>
			
				<label for="name">新闻内容</label>
				<textarea cols="120" id="editor1" name="editor1" rows="10"></textarea>
				<ckfinder:setupCKEditor basePath="../ckfinder/"
					editor="editor1" />

				<ckeditor:replace replace="editor1" basePath="../ckeditor/" />
			
			<div style="text-align: right;">
				<button type="submit" class="btn btn-default"> 提交</button>
			</div>
		</form>

	</div>

</body>

</html>