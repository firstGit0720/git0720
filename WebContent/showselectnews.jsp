<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.mmsg.cms.vo.NewsInfo" %>
<!DOCTYPE HTML>
<html>

	<head>
		<meta charset="utf-8" />
		<title>网站关键词-网站名称</title>
		<meta name="description" content="网站描述，一般显示在搜索引擎搜索结果中的描述文字，用于介绍网站，吸引浏览者点击。" />
		<meta name="keywords" content="网站关键词" />
		<meta name="generator" content="" />
		<link href="favicon.ico" rel="shortcut icon" />
		<link rel="stylesheet" type="text/css" href="css/metinfo.css" />
		<script src="js/jQuery1.7.2.js" type="text/javascript"></script>
		<script src="js/ch.js" type="text/javascript"></script>
		<%
			NewsInfo news = (NewsInfo) request.getAttribute("newsinfo");
		%>
	</style>
	</head>

	<body>
		<header>
			<div class="inner">
				<div class="top-logo">

					<a href="http://demo.metinfo.cn/" title="网站名称" id="web_logo">
						<img src="images/logo.png" alt="网站名称" title="网站名称" style="margin:20px 0px 0px 0px;" />
					</a>

					<ul class="top-nav list-none">
						<li class="t">
							<a href='#' onclick='SetHome(this,window.location,"非IE浏览器不支持此功能，请手动设置！");' style='cursor:pointer;' title='设为首页'>设为首页</a><span>|</span>
							<a href='#' onclick='addFavorite("非IE浏览器不支持此功能，请手动设置！");' style='cursor:pointer;' title='收藏本站'>收藏本站</a><span>|</span>
							<a class="fontswitch" id="StranLink" href="javascript:StranBody()">繁体中文</a><span>|</span>
							<a href='#' title='WAP'>WAP</a><span>|</span>
							<a href='#' title='English'>English</a><span>|</span>
							<a href='admin/userlogin.html' title='后台登录' class='shopweba'>后台登录</a>
							<span>|</span>
							<a href='#' title='我的订单' class='shopweba'>我的订单</a>
						</li>
					</ul>
				</div>
				<nav>
					<ul class="list-none">
						<li id="nav_10001" style='width:121px;'>
							<a href='index.html' x class='nav'><span>网站首页</span></a>
						</li>
						<li class="line"></li>
						<li id='nav_1' style='width:121px;'>
							<a href='about.html' 0 class='hover-none nav'><span>关于我们</span></a>
						</li>
						<li class="line"></li>
						<li id='nav_2' style='width:121px;' >
							<a href='news.html' class='hover-none nav'><span>新闻资讯</span></a>
						</li>
						<li class="line"></li>
						<li id='nav_3' style='width:121px;'>
							<a href='index.html' class='hover-none nav'><span>产品展示</span></a>
						</li>
						<li class="line"></li>
						<li id='nav_32' style='width:121px;'>
							<a href='index.html' class='hover-none nav'><span>下载中心</span></a>
						</li>
						<li class="line"></li>
						<li id='nav_33' style='width:121px;'>
							<a href='index.html' class='hover-none nav'><span>客户案例</span></a>
						</li>
			
						<li class="line"></li>
						<li id='nav_36' style='width:120px;'>
							<a href='#' class='hover-none nav'><span>招贤纳士</span></a>
						</li>
						<li class="line"></li>
						<li id='nav_22' style='width:120px;'>
							<a href='#' class='hover-none nav'><span>联系我们</span></a>
						</li>
					</ul>
				</nav>
			</div>
		</header>
		
		<div class="sidebar inner">
			<div class="sb_nav">

				<h3 class='title myCorner' data-corner='top 5px'>新闻类别</h3>
				<div class="active" id="sidebar" data-csnow="2" data-class3="0" data-jsok="2">
					<dl class="list-none navnow"><dt id='part2_4'><a href="<%=application.getContextPath() %>/SelectNewsInfoByTypeServlet?news_type=娱乐新闻"  title='娱乐新闻' class="zm"><span>娱乐新闻</span></a></dt></dl>
					<dl class="list-none navnow"><dt id='part2_5'><a href='<%=application.getContextPath() %>/SelectNewsInfoByTypeServlet?news_type=体育新闻'  title='体育新闻' class="zm"><span>体育新闻</span></a></dt></dl>
					<dl class="list-none navnow"><dt id='part2_5'><a href='<%=application.getContextPath() %>/SelectNewsInfoByTypeServlet?news_type=财经新闻'  title='财经新闻' class="zm"><span>财经新闻</span></a></dt></dl>
					<dl class="list-none navnow"><dt id='part2_5'><a href='<%=application.getContextPath() %>/SelectNewsInfoByTypeServlet?news_type=科技新闻'  title='科技新闻' class="zm"><span>科技新闻</span></a></dt></dl>
					<dl class="list-none navnow"><dt id='part2_5'><a href='<%=application.getContextPath() %>/SelectNewsInfoByTypeServlet?news_type=生活新闻'  title='生活新闻' class="zm"><span>生活新闻</span></a></dt></dl>
					<div class="clear"></div>
				</div>

				<h3 class='title line myCorner' data-corner='top 5px'>联系方式</h3>
				<div class="active editor">
					<div>
						请在<strong>后台-内容管理-备用字段</strong>中修改此段文字</div>
					<div>
						迷茫-曙光研发工作室</div>
					<div>
						电 &nbsp;话：0000-888888</div>
					<div>
						邮 &nbsp;编：000000</div>
					<div>
						Email：admin@admin.cn</div>
					<div>
						网 &nbsp;址：www.xxxxx.cn</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="sb_box">
				<h3 class="title">
<div class="position">当前位置：<a href="#" title="网站首页">网站首页</a> &gt; <a href=../news/ >新闻内容</a> > <a href=../news/news.php?lang=cn&class2=5 >新闻分类</a></div>
			<span>新闻内容</span>
		</h3>
				<div class="clear"></div>
				<form action="selectNewsLikeTitleServlet" method="post" style="padding-left: 530px;">		
						<b>请输入关键字:</b><input type="text" size="10" value="" name="liketitle" placeholder="新闻标题关键字"/>
						<input type="submit" value="搜索" />
				</form>

				<div class="active" id="shownews"  style="height: 400px;">
					<center>
						<h2>新闻标题：<%=news.getNews_title() %></h2>
						<h4>新闻类别：<%=news.getNews_type() %> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						新闻点击量：<%=news.getNews_count() %></h4>
					
					</center>
					<h5>新闻内容：<br>
					
					<div style="width: 600px; height: 350px;"><%=news.getNews_content() %></div>
						
					</h5>
				</div>
						
					
				<div class="met_hits">
					点击次数：<span>100</span>&nbsp;&nbsp;更新时间：<span id="time"></span>&nbsp;&nbsp;【
					<a href="javascript:window.print()">打印此页</a>】&nbsp;&nbsp;【
					<a href="javascript:self.close()">关闭</a>】
				</div>
				<div class="met_page">上一条：没有了&nbsp;&nbsp;下一条：
					<a href='shownews.php?lang=cn&id=4'>新手使用MetInfo建站步骤</a>
				</div>
			</div>
		<div class="clear"></div>
	</div>
		
		
		
		<footer data-module="2" data-classnow="2">
			<div class="inner">
				<div class="foot-nav">
					<a href='../news/news.php?lang=cn&class2=4' title='公司动态'>公司动态</a><span>|</span>
					<a href='../message/' title='在线留言'>在线留言</a><span>|</span>
					<a href='../feedback/' title='在线反馈'>在线反馈</a><span>|</span>
					<a href='../link/' title='友情链接'>友情链接</a><span>|</span>
					<a href='../member/' title='会员中心'>会员中心</a><span>|</span>
					<a href='../search/' title='站内搜索'>站内搜索</a><span>|</span>
					<a href='../sitemap/' title='网站地图'>网站地图</a><span>|</span>
					<a href='http://gc04430.d215.51kweb.com/admin/' title='网站管理'>网站管理</a>
				</div>
				<div class="foot-text">
					<p>我的网站 版权所有 2008-2012 湘ICP备8888888
						<script src="http://s6.cnzz.com/stat.php?id=1670348&web_id=1670348" language="JavaScript"></script>
					</p>
					<p>电话：0731-12345678 12345678 QQ:88888888 999999 Email:metinfo@metinfo.cn</p>

				</div>
			</div>
		</footer>
		<script src="images/fun.inc.js" type="text/javascript"></script>
	</body>

</html>