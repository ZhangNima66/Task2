<%--
  Created by IntelliJ IDEA.
  User: maxuezhi
  Date: 2019/4/22
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改图书</title>
</head>

<body>

<form
        action="${pageContext.request.contextPath }/BookServlet?method=edit"
        method="post" enctype="multipart/form-data">
    <table width="500px">
        <tr>
            <td>书名</td>
            <td>
                <input type="hidden" name="id" value="${book.id}">
                <input type="text" name="name" value="${book.name}" style="width: 200px">
            </td>
        <tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author" value="${book.author}" style="width: 200px"></td>
        </tr>
        <tr>
            <td>出版日期</td>
            <td>
                <input type="date" name="publicationDate" value="<fmt:formatDate value="${book.publicationDate}" pattern="yyyy-MM-dd"/>" style="width: 200px">
            </td>
        </tr>
        <tr>
            <td>售价</td>
            <td><input type="text" name="price" value="${book.price}" style="width: 200px"></td>
        </tr>
        <tr>
            <td>图片</td>

            <td>
                <img src="${pageContext.request.contextPath }/images/${book.image }"
                     width="83" height="118" /><br/>
                <input TYPE="hidden" name="image" value="${book.image}">
                <input type="file" name="imageFile" style="width: 200px">
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td><textarea rows="4" cols="40" name="description">${book.description}</textarea></td>
        </tr>
        <tr>
            <td>所属分类</td>
            <td><select name="category_id">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id }" ${book.category_id==category.id?'selected':''}>${category.name }</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="修改书籍"></td>
        </tr>
    </table>
</form>

</body>
</html>

