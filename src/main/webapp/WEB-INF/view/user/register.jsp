<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"src=""src/main/webapp/resource/js/jquery.validate.js""></script>
</head>
<body>
<form class="" >
<div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="username" name="username" minlenth="2" maxlength="8"  placeholder="请输入用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
    </div>
  </div>
 <!--  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox">请记住我
        </label>
      </div>
    </div>
  </div> -->
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="button" class="btn btn-default" value="注册" onclick="register()"/>
    </div>
  </div>
  </form>
  
<script type="text/javascript">

//regForm需要校验 校验规则可以在这个函数内部 也可以直接卸载标签的属性上
$("#regForm").validate();
function register(){
	$.post(
		$("#regForm").submit();	
	
	)
}

</script>
</body>
</html>