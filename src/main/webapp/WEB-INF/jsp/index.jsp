<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>前台首页</title>

<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
}
#main {
	margin-top: 20px;
}
#head {
	text-align: center;
}
#books {
	/*float: left;*/
	margin-top: 50px;
	width: 830px;
}

#image {
	float: left;
}

#info {
	float: left;
}

#book {
	float: left;
	width: 270px;
}

</style>
</head>

<body>
	<center>
		<%----%>
		<div id="books">
			<c:forEach var="book" items="${pagebean.books}" varStatus="status">
				<div id="book">
					<div id="image">
						<img
							src="${pageContext.request.contextPath }/images/${book.image }"
							width="83" height="118" />
					</div>
					<div id="info">
						<ul>
							<li>${book.name }</li>
							<li>${book.author }</li>
							<li>${book.price }</li>
							<li><a
								href="${pageContext.request.contextPath }/client/BuyServlet?id=${book.id }">购买</a>
							</li>
						</ul>
					</div>
					<div style="clear: both"></div>
				</div>
				<c:if test="${status.count%3==0}">
					<div style="clear: both"></div>
				</c:if>
			</c:forEach>
			<div style="clear: both"></div>
			<br />
			<div id="pagebar" align="center">
				总共${pagebean.totalpage }页 当前${pagebean.currentpage }页
				<c:forEach var="pagenum" items="${pagebean.pagebar}">
					<a
						href="${pageContext.request.contextPath }/client/IndexServlet?currentpage=${pagenum }&category_id=${param.category_id }">${pagenum }</a>
				</c:forEach>

			</div>
		</div>
	</center>
</body>
</html>
