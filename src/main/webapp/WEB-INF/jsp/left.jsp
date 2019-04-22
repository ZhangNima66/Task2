<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxuezhi
  Date: 2019/4/19
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>左侧导航</title>
    <style type="text/css">

        #categories {
            padding-top: 30px;
            padding-left: 100px;
        }
    </style>
</head>
<body>
    <script type="text/javascript">
        function hide(node) {
            var li = node.parentNode;
            var e = li.getElementsByTagName('div')[0];
            e.style.display = e.style.display == 'block' ? 'none' : 'block' ;
        }
    </script>


<div id="categories">
    <div>
        书籍类别：
        <li><a href="${pageContext.request.contextPath }/index" target="main">全部</a></li>
        <c:forEach var="c" items="${categories}">
            <li><a href='${pageContext.request.contextPath }/index?queryvalue=${c.id }' target="main">${c.name }</a></li>
        </c:forEach>
    </div>
    <div style="padding-top: 100px" id="manager">
        <a href="javascript:void(0)" onclick="hide(this)" >种类管理</a>
        <div style="display: none">
            <li><a href="${pageContext.request.contextPath}/CategoryServlet?method=addUI" target="main">添加种类</a></li>
            <li><a href="${pageContext.request.contextPath}/CategoryServlet?method=listUI" target="main">种类列表</a></li>
        </div>
    </div>
</div>

</body>
</html>
