<%--
  Created by IntelliJ IDEA.
  User: maxuezhi
  Date: 2019/4/25
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新种类</title>
</head>
<body>
<br/><br/>
<form action="${pageContext.request.contextPath}/CategoryServlet?method=update" method="post">
    <table width="500px;">
        <tr>
            <td>分类名称：</td>
            <td><input type="hidden" name="id" value="${category.id}">
                <input type="text" name="name" value="${category.name}" style="width: 200px"></td>
        <tr>
        <tr>
            <td>分类描述：</td>
            <td><textarea rows="4" cols="40" name="description">${category.description}</textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="添加分类"></td>
        </tr>
    </table>
</form>
</body>
</html>
