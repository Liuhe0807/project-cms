<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="table-responsive">
  <table class="table">
    <caption>友情链接</caption>
    <thead>
      <tr >
        <th>id</th>
        <th>名称</th>
        <th>地址</th>
        <th>创建时间</th>
        <th>操作 <input type="button" value="添加" onclick="add()">
        </th>
       </tr>
    </thead>
    <tbody>
    	<c:forEach items="${info.list}"  var="link">
    	  <tr>
	        <td>${link.id }</td>
	        <td>${link.name }</td>
	        <td>${link.url }</td>
	        <td><fmt:formatDate value="${link.created }" pattern="YYY年M月dd号 HH:mm:ss"/></td>
	        <td>
	        <input type="button" value="删除" onclick="delete(${link.id})">
	             &nbsp;
	        <input type="button" value="修改" onclick="update(${link.id})">
	        </td>
	      </tr>
      </c:forEach>
      </tbody>
  </table>
</div>

<ul class="pagination">
    <li><a href="javascript:goPage(${info.prePage})">&laquo;</a></li>
    <c:forEach begin="${info.pageNum-2 > 1 ? info.pageNum-2:1}" end="${info.pageNum+2 > info.pages ? info.pages:info.pageNum+2}" varStatus="index">    		
    	<c:if test="${info.pageNum!=index.index}">
    		<li><a href="javascript:goPage(${index.index})">${index.index}</a></li>
    	</c:if>
    	<c:if test="${info.pageNum==index.index}">
    		<li><a href="javascript:void"><strong> ${index.index} </strong> </a></li>
    	</c:if>
    	
    </c:forEach>
    <li><a href="javascript:goPage(${info.nextPage})">&raquo;</a></li>
</ul>

<script type="text/javascript">
function goPage(page){
	var url="/link/list?page="+page;
	$("#content").load(url);
}

function add(){
	$("#content").load("/link/add")
}

</script>

</body>
</html>