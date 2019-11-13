<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">输入姓名</a>
    </div>
    <div>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <input type="button" class="btn btn-default" value="查询">
        </form>
    </div>
    </div>
</nav>

<div class="table-responsive">
  <table class="table">
    <caption>用户列表</caption>
    <thead>
      <tr>
        <th>用户id</th>
        <th>姓名</th>
        <th>注册日期</th>
        <th>生日</th>
        <th>角色</th>
        <th>状态</th></tr>
    </thead>
    <tbody>
      <c:forEach items="${info.list }" var="l">
      	<c:if test="${user.locked==1 }">
      		<tr class="active">
      	</c:if>
      	<c:if test="${user.locked!=1 }">
      		<tr >
      	</c:if>
      	
      <td>${l.id }</td>
      <td>${l.username }</td>
      <td><fmt:formatDate pattern="YYYY年MM月dd号" value="${l.createTime }"/></td>
      <td><fmt:formatDate pattern="YYYY年MM月dd号" value="${l.birthday }"/></td>
      <td>
      <c:choose>
      	<c:when test="${user.role==1 }">
      		管理员
      	</c:when>
      	<c:when test="${user.role==0 }">
      		普通用户
      	</c:when>
      	<c:otherwise>
      		未知
      	</c:otherwise>
      </c:choose>
      </td>
      <td>${user.locked==1?"禁用":"正常" }</td>
      <td></td>
      
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
<ul class="pagination">
    <li><a href="javascript:goPage(${info.prePage})">&laquo;</a></li>
    <c:forEach begin="${info.pageNum-2>1?info.pageNum-2:1 }" end="${info.pageNum+2>info.page?info.pages:info.pageNum+2 }">
    <li><a href="#">1</a></li>
    </c:forEach>
    <li><a href="javascript:goPage(${info.nextPage})">&raquo;</a></li>
</ul>
    
    