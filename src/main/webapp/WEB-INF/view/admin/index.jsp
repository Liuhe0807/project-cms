<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<%-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/resource/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/jquery-3.2.1.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/resource/bootstrap/js/bootstrap.js"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
<title>CMD管理平台</title>
</head>
<body>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">CMS系统</a>
    </div>
    <div>
        <ul class="nav navbar-nav  navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                   		 用户 <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">用户设置</a></li>
                    <li><a href="#">个人信息</a></li>
                    <li class="divider"></li>
                    <li><a href="/user/logout">退出</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>

<div class="row">
	<div class="col-md-2">
		<div style="margin-left:20px ">
			<ul class="nav nav-pills nav-stacked menu">
			  <li class="active" data="/admin/articles"><a href="javascript:showFuction('/admin/articles')">文章列表</a></li>
			  <li><a href="javascript:showFuction('/user/hello')">测试</a></li>
			  <li><a href="#">发布文章</a></li>
			  <li>投票管理
			  	<ul class="nav nav-pills nav-stacked">
			  		<li><a href="#">投票列表</a></li>
			  		<li><a href="#">新建投票</a></li>
			  	</ul>
			  </li>
			  <li class="divider"></li>
			  <li><a href="javascript:showFunction('/admin/users')">用户管理</a></li>
			</ul>
		</div>
	</div>
	<div class="col-md-10"  style=" min-height:500px; border-left: solid">
		<div id="content">
			
		</div>
	</div>
</div>

<nav class="navbar navbar-inverse navbar-fixed-bottom" 
role="navigation">
	<div align="center"> <font color="blue" size="5"> ----八维大数据学院1707D--- </font> </div>
</nav>

<script type="text/javascript">
	var url = $(".menu li:eq(0)").attr("data");
	$("#content").load(url);
	
	function showFuction(url){
		$("#content").load(url);
	}
</script>



</body>
</html>