
<%@ page import="java.util.List"%>
<%@ page import="com.mmsg.cms.vo.User"%>
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
<title>Bootstrap 101 Template</title>

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
		<script>
		
			$(function(){
				$("#okadd").on("click",okAdd);
				$("#okupdate").on("click",okUpdate);				
			})
				//删除功能
			 function delete_id(id){
        		alert(id);
        		$("#btok").attr("href",$("#btok").attr("href")+id);
      		  }
        
			
			function okAdd(){
				$.ajax({
					type:"post",
					url:"addUserServlet",
					async:false,
					data:{
					"user":$("#adduser").val(),
					"pass":$("#addpass").val(),
						},
					success:function(data){
						if(data == "ok"){
							alert("管理员添加成功！")
							window.location.reload();
						}else{
							alert("管理员添加失败！")
							window.location.reload();
						}	
					}
					
				})
			}
			
			//修改功能
			//获取信息
			function update(obj){
				//获取节点信息并查找到td对象
	        	var tds= $(obj).parent().parent().find("td")[0];
	        	var tds1= $(obj).parent().parent().find("td")[1];
	        	var tds2= $(obj).parent().parent().find("td")[2];
	        	//通过对象获取值
		       	var id =$(tds).text();
	       		var name=$(tds1).text();
	        	var pass=$(tds2).text();
	        	console.log(id+name+pass)
	        	//在相应的位置显示
	        	$("#updateid").attr("value",id);
	        	$("#updatename").attr("value",name);
	        	$("#updatepass").attr("value",pass);
			}
				

			function okUpdate(){
				alert("asdasa")
				$.ajax({
					type:"post",
					url:"updateUserServlet",
					async:false,
					data:{
						"id":$("#updateid").val(),
						"user":$("#updatename").val(),
						"pass":$("#updatepass").val(),
					},
					success:function(data){
						if(data == "ok"){
							alert("管理员修改成功！")
							window.location.reload();
						}else{
							alert("管理员修改失败！")
							window.location.reload();
						}	
					}
				});
				
			}
      	
	
 		 </script>
	<%
    	List<User> showuser =(List) request.getAttribute("userlist");
    %>

</head>
<body style="background: #0FCCBC;">
	<div class="container">
		<br>
		<center> <button class="btn btn-success" data-toggle="modal"
						data-target="#myAdd">注册</button>
		</center>
		<br>
		<table
			class="table table-bordered table-striped table-hover table-responsive">
			<caption align="top" style="font-size: 20px; text-align: center; color: #FF0000;"><b>管理员信息显示</b></caption> 
			<tr>
				<th><span class="glyphicon glyphicon-th-list"></span>管理员编号</th>
				<th>姓名</th>
				<th>密码</th>
				<th>操作</th>
			</tr>
			<% 
    		for(User u: showuser)
    		{%>
			<tr>
				<td><%=u.getId() %></td>
				<td><%=u.getName() %></td>
				<td><%=u.getPassword() %></td>
				<!-- btn-default/btn-danger -->
				<td>
					<button class="btn btn-success" data-toggle="modal"
						data-target="#myUpdate" onclick="update(this)" >修改</button>
					<button class="btn btn-danger"data-toggle="modal" data-target="#myModal" onclick="delete_id(this.id)"
    					id="<%=u.getId() %>" >删除</button>
				</td>
			</tr>
			<%} %>
		</table>

	</div>



	<!--定义删除模态框-->
	<div class="modal fade" id="myModal">
		<!--定义会话层-->
		<div class="modal-dialog">
			<!--定义显示内容的容器-->
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4>删除提示</h4>
				</div>

				<div class="modal-body">是否删除？</div>
				<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal">close</button>
					<a style="text-decoration: none;" class="btn btn-default" id="btok" 
    					href="<%=application.getContextPath() %>/deleteUserServlet?id=">ok</a>
				</div>
			</div>
		</div>
	</div>
	
	<!--     定义注册模态框 -->
	<div class="modal fade" id="myAdd">
		<!--定义会话层-->
		<div class="modal-dialog">
			<!--定义显示内容的容器-->
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4>注册信息</h4>
				</div>
				<div class="modal-body">
					<div class="row" style="padding-left: 50px">
						<div class="lable">
							<b>*</b>管理员姓名:
						</div>						
						<input type="text" name="updataName" id="adduser" 
						placeholder="姓名"
						style="width: 400px; height: 37px; float: left;" />
					</div>
					<div class="row" style="padding-left: 50px">
					<div class="lable">
							<b>*</b>管理员密码:
						</div>						
						<input type="text" name="updataPass" id="addpass" 
						placeholder="密码"
						style="width: 400px; height: 37px; float: left;" />
					</div>
					<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal">close</button>
					<button class="btn btn-primary" id="okadd">ok</button>
				</div>

				</div>
			</div>
		</div>
	</div>
	<!--     定义修改模态框 -->
	<div class="modal fade" id="myUpdate">
		<!--定义会话层-->
		<div class="modal-dialog">
			<!--定义显示内容的容器-->
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4>修改内容</h4>
				</div>
				<div class="modal-body">
					<div class="row" style="padding-left: 50px">
						<div class="lable">
							<b>*</b>ID：
						</div>						
						<input type="text" name="updataName" id="updateid" 
						style="width: 400px; height: 37px; float: left;" />
					</div>
					
					<div class="row" style="padding-left: 50px">
						<div class="lable">
							<b>*</b>姓名：
						</div>						
						<input type="text" name="updataName" id="updatename" 
						style="width: 400px; height: 37px; float: left;" />
					</div>
					<div class="row" style="padding-left: 50px">
						<div class="lable">
							<b>*</b>密码：
						</div>						
						<input type="text" name="updataPass" id="updatepass" 
						style="width: 400px; height: 37px; float: left;" />
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal">close</button>
						<button class="btn btn-primary" id="okupdate">ok</button>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>

</html>