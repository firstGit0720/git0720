
<%@ page import="java.util.List" %>
<%@ page import="com.mmsg.cms.vo.UserInfo" %>
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
    <title>Bootstrap 101 Template</title>

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
    	$(function(){
    		$("#selectAll").on("click",selectAll);
    		$("#noSelect").on("click",noSelect);
    		$("#deleteSelect").on("click",deleteSelect);
    	})
    	function selectAll(){
           $("input[name='box']").attr("checked",true);
    	}
    	
    	//全不选功能
		function noSelect(){	
			 $("input[name='box']").attr("checked",false);
        }
		
		//删除功能
/*		function deleteSelect(){
			var	obj = document.getElementsByName("box");
    		var check_val = new Array();
   			 for(k in obj){
       		 if(obj[k].checked)
            	check_val.push(obj[k].value);	
    		}
   			 $.ajax({
   			 	type:"post",
        		url:"UpdateUserInfoServlet",
        		async:false,
        		data:{
        			"updateid":$("#updataid").val(),  			 	
   			 })
        }  */      	
        
        //修改
        function update(obj){
        	//获取节点信息并查找到td对象
        	var tds= $(obj).parent().parent().find("td")[0];
        	var tds1= $(obj).parent().parent().find("td")[1];
        	var tds2= $(obj).parent().parent().find("td")[2];
        	var tds3= $(obj).parent().parent().find("td")[3];
        	var tds4= $(obj).parent().parent().find("td")[4];
        	var tds5= $(obj).parent().parent().find("td")[5];
        	var tds6= $(obj).parent().parent().find("td")[6];
        	var tds7= $(obj).parent().parent().find("td")[7];
        	//通过对象获取值
	       	var id =$(tds).text();
       		var nameText=$(tds1).text();
        	var passText=$(tds2).text();
        	var telText=$(tds3).text();
        	var sexText=$(tds4).text();
        	var emailText=$(tds5).text();
        	var csrqText=$(tds6).text();
        	var eduText=$(tds7).text();
        	//在相应的位置显示
        	$("#updataid").attr("value",id);
        	$("#updataname").attr("value",nameText);
        	$("#updataPass").attr("value",passText);
        	$("#updataTel").attr("value",telText);
        	$("#updataSex").attr("value",sexText);
        	$("#updataEmail").attr("value",emailText);
        	$("#updataDate").attr("value",csrqText);
        	$("#updataXl").attr("value",eduText);      
        }
        $(function(){
        	$("#okupdata").on("click",okupdata);
        })
        function okupdata(){
        	$.ajax({
        		type:"post",
        		url:"UpdateUserInfoServlet",
        		async:false,
        		data:{
        			"updateid":$("#updataid").val(),
        			"updatename":$("#updataname").val(),
        			"updatepass":$("#updataPass").val(),
        			"updatetel":$("#updataTel").val(),
        			"updatesex":$("#updataSex").val(),
        			"updatemian":$("#updataEmail").val(),
        			"updatedata":$("#updataDate").val(),
        			"updateedu":$("#updataXl").val(),
        		},
        		success:function(data){
        			if(data == "ok"){
        				alert("信息修改成功！");
        				window.location.reload();
        			}else{
						alert("信息修改失败！");
						window.location.reload();
					}	
        		}
        	}); 	
        }
        //删除
        function delete_id(id){
        	alert(id)
        	$("#btok").attr("href",$("#btok").attr("href")+id);
        }
        
       /*$(function(){
        	$("#delete").on("click",deleteinfo);
        })
        //删除按钮
        function deleteinfo(){
        	//删除页面的功能
        	 $.ajax({
        		type:"post",
				url:"deleteUserInfoServlet",
				async:false,
				data:{
					"user_id":$("#deleteid"+).val(),
				},
				success:function(data){
					if(data == "ok"){
						alert("会员信息删除成功！")
						window.location.reload();
					}
					else{
						alert("会员信息删除失败！")
						window.location.reload();
					}
				}
        	}); 
        }*/
            
	
    </script>
    <%
  	  request.setCharacterEncoding("utf-8");
    	List<UserInfo> showuser =(List) request.getAttribute("userlist");
    	Page p = (Page) request.getAttribute("page");
    %>
	
  </head>
  <body style="background: #0FCCBC;">  
    <div class="container" >
    <br>
   	 <form action="SelectByNameServlet" method="post" style="padding-left: 480px;">
		  <h4>
		    请输入要查询的会员的名字：<input type="text"  id="selectname" name="selectname" size="16" style="height: 30px"/>
		  <input  type="submit" value="查询"/></h4>
		  	</form>  		
    	<table class="table table-bordered table-striped table-hover table-responsive">
    		<caption align="top" style="font-size: 20px; text-align: center; color: #FF0000;"><b>会员信息显示</b></caption> 
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
    		<% 
    		for(UserInfo u: showuser)
    		{%>
    		<tr>
    			<td ><input type="checkbox" name="box" value="<%=u.getId() %>"/><%=u.getId() %></td>
    			<td><%=u.getUsername() %></td>
    			<td><%=u.getPassword() %></td>
    			<td><%=u.getTelephone() %></td>
    			<td><%=u.getGender() %></td>
    			<td><%=u.getEmail() %></td>
    			<td><%=u.getBorndate() %></td>
    			<td><%=u.getEducation() %></td>
    			<!-- btn-default/btn-danger -->
    			<td>
    				<button class="btn btn-success" data-toggle="modal" data-target="#upData" onclick="update(this)">编辑</button>
    				<button class="btn btn-danger"data-toggle="modal" data-target="#myModal" onclick="delete_id(this.id)"
    					id="<%=u.getId() %>" >删除</button>
    			</td>
    		</tr>
    		<%} %>
    	</table>
    	<div class="btn-group">
    		<button class="btn btn-default" id="selectAll">全选</button>
    		<button class="btn btn-default" id="noSelect">不选</button>
    		<button class="btn btn-default" id="deleteSelect">删除</button>
    	</div>
    	
    	<div class="btn-group" style="float: right;">
    		<a class="btn btn-default" href="<%=application.getContextPath() %>/ShowUserInfoServlet?cp=<%=p.getPrevPage() %>">&laquo;</a>
    		<% for(int i=1;i<p.getToral()+1; i++) { %>
    		<a class="btn btn-default" href="<%=application.getContextPath() %>/ShowUserInfoServlet?cp=<%=i %>"><%=i %></a>
    		<%} %>
    		<a class="btn btn-default" href="<%=application.getContextPath() %>/ShowUserInfoServlet?cp=<%=p.getNextPage()%>">&raquo;</a>
    	</div>
    		
    </div>
    
     <!--定义修改模态框-->
    <div class="modal fade" id="upData">
    	<!--定义会话层-->
    	<div class="modal-dialog">
    		<!--定义显示内容的容器-->
    		<div class="modal-content">
    			<div class="modal-header" id="biaoti">
    				<button class="close" data-dismiss="modal">&times;</button>
    				<h4>修改内容</h4>
				</div>
				<div class="modal-body">
					<div id="showuserinfo">
						<b>*id:</b>
						<input type="text" name="updataName" id="updataid"  size="20"/>
						<br>
						<b>*姓名:</b>
						<input type="text" name="updataName" id="updataname"  size="20"/>
						<br/>
						<b>*密码:</b>					
						<input type="text" name="updataPass" id="updataPass"  size="20"/>
						<br/>
						<b>*手机号:</b>					
						<input type="text" name="updataTel" id="updataTel"  size="11"/>
						<br/>
						<b>*性别:</b>				
						<input type="text" name="updataSex" id="updataSex"/>
						<br/>
						<b>*邮箱：</b>				
						<input type="text" name="updataEmail" id="updataEmail" />
						<br/>
						<b>*出生日期：</b>	
						<input type="text" name="updataDate" id="updataDate" />
						<br/>
						<b>*学历	</b>				
						<input type="text" name="updataXl" id="updataXl" />
						<br/>

					</div>
					<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal">close</button>
					<button class="btn btn-primary" id="okupdata">ok</button>
				</div>

				</div>
			</div>
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
    				<h4>删除</h4>
    			</div>
    			
    			<div class="modal-body">
    				确定删除？
    			</div>
    			<div class="modal-footer">
    				<button class="btn btn-default" data-dismiss="modal">否</button>
    				
    				<a style="text-decoration: none;" class="btn btn-default" id="btok" 
    					href="<%=application.getContextPath() %>/deleteUserInfoServlet?id=">是</a>
    			</div>
    		</div>
    	</div>
    </div>
    
  </body>
  
</html>