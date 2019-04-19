<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>首页</title>
</head>

<frameset rows="150px,*">
    <frame name="head" src="${pageContext.request.contextPath}/UIServlet?jsp=head">
    <frameset cols="300px,*">
        <frame name="left" src="${pageContext.request.contextPath}/UIServlet?jsp=left">
        <frame name="main" src="${pageContext.request.contextPath}/index">
    </frameset>
</frameset>


</html>
