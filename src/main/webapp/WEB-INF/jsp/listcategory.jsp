<%--
  Created by IntelliJ IDEA.
  User: maxuezhi
  Date: 2019/4/22
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>分类列表</title>
</head>

<body>
<center>
    <h2>书籍分类信息</h2>
    <table border="1" cellpadding="0" cellspacing="0" width="90%">
        <tr align="center">
            <td>分类名称</td>
            <td>分类描述</td>
            <td>操作</td>
        </tr>

        <c:forEach var="category" items="${categories}">
            <tr align="center">
                <td>${category.name }</td>
                <td>${category.description }</td>
                <td>
                    <a href="${pageContext.request.contextPath}/CategoryServlet?method=updateUI&id=${category.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/CategoryServlet?method=delete&id=${category.id}"
                       onclick="return confirm('请确认删除');">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>