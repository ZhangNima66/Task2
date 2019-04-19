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
        function hide() {
            var manager = document.getElementById("manager");
            var li = manager.getElementsByTagName("li");
            alert(li);
        }
    </script>


<div id="categories">
    <div>
        书籍类别：
        <li><a href="">全部</a></li>
        <c:forEach var="c" items="${categories}">
            <li><a href='${pageContext.request.contextPath }/client/IndexServlet?category_id=${c.id }'>${c.name }</a></li>
        </c:forEach>
    </div>
    <div style="padding-top: 100px" id="manager">
        <a href="javascript:void(0)" onclick="hide()" >种类管理</a>
        <li><a href="">添加种类</a></li>
        <li><a href="">种类列表</a></li>
    </div>
</div>

</body>
</html>
