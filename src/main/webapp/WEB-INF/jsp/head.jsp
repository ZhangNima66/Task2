<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<body>


<div align="center">
	<h1>网上书店</h1>
	<br/>
	<div>
		<a href="${pageContext.request.contextPath }/index" target="main">首页</a>
		<a href="${pageContext.request.contextPath }/BookServlet?method=addUI" target="main">添加书籍</a>
	</div>
</div>


</body>
</html>