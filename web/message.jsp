<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>消息页面</title>
	<meta http-equiv="refresh" content="3;url=${url}">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<!--[if lte IE 8]>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
	<![endif]-->
	<!--[if gt IE 8]><!-->
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
	<!--<![endif]-->
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
	<!--[if lte IE 8]>
	<link rel="stylesheet" href="css/layouts/marketing-old-ie.css">
	<![endif]-->
	<!--[if gt IE 8]><!-->
	<link rel="stylesheet" href="css/layouts/marketing.css">
	<!--<![endif]-->
	<link rel="stylesheet" href="css/global.css">
</head>

<body>
<div class="header">
	<div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
		<a class="pure-menu-heading" href="">短网址生成</a>
	</div>
</div>
<div class="splash-container">
	<div class="splash">
		<div class="splash">
			<h2 class="splash-subhead">消息提示：${message }</h2>
			<h2 class="splash-subhead"><a href="${url}">本网页将在3秒后自动跳转回主页，若未自动跳转，可点击此链接自行跳转。</a></h2>
		</div>
	</div>
</div>
<div class="copyright">
	<p >
		Copyright &copy; 2016.Coselding All rights reserved. 鲁ICP备15036981号-2
	</p>
</div>
</body>
</html>
