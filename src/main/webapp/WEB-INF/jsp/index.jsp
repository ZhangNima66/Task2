<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>前台首页</title>

    <style type="text/css">
        body {
            margin: 0px;
            padding: 0px;
        }

        #books {
            /*float: left;*/
            align-content: center;
            margin-left: 150px;
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

        #pageSet {
            align-content: center;
            margin-bottom: 30px;
        }

    </style>
</head>

<body>
<%----%>
<script type="text/javascript">

    function gotopage(currentpage) {
        if (currentpage == null || currentpage <= 0 || currentpage > ${bean.totalpage}) {
            alert('请输入正确的页码');
            return;
        }
        var pagesize = document.getElementById("pagesize").value;
        if (${bean.pagesize} !=
        pagesize
    )
        {
            currentpage = 1;
        }
        window.location.href = '${pageContext.request.contextPath}/index?queryvalue=${category}&currentpage=' + currentpage + '&pagesize=' + pagesize;
    }
</script>

<div id="books">
    <div id="pageSet" align="center">
        共[${bean.totalrecord }]条记录， 每页
        <select id="pagesize" onchange="gotopage(${bean.currentpage})">
            <option value="3" ${fn:contains(bean.pagesize,3)?'selected = "selected"':''}>3</option>
            <option value="6" ${fn:contains(bean.pagesize,6)?'selected = "selected"':''}>6</option>
            <option value="9" ${fn:contains(bean.pagesize,9)?'selected = "selected"':''}>9</option>
        </select> 条， 共[${bean.totalpage }]页，当前第[${bean.currentpage }]页
    </div>


    <c:forEach var="book" items="${bean.books}" varStatus="status">
        <div id="book">
            <div id="image">
                <img
                        src="${pageContext.request.contextPath }/images/${book.image }"
                        width="83" height="118"/>
            </div>
            <div id="info">
                <ul>
                    <li>${book.name }</li>
                    <li>${book.author }</li>
                    <li>${book.publicationDate}</li>
                    <li>${book.price }</li>
                    <li><a
                            href="${pageContext.request.contextPath }/BookServlet?method=editUI&id=${book.id }">修改</a>
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
    <br/>
    <div id="pagebar" align="center">
        <c:if test="${bean.previouspage!=bean.currentpage }">
            <a href="javascript:void(0)" onclick="gotopage(${bean.previouspage})">上一页</a>
        </c:if>
        <c:forEach var="pagenum" items="${bean.pagebar }">
            <c:if test="${pagenum==bean.currentpage }">
                ${pagenum}
            </c:if>
            <c:if test="${pagenum!=bean.currentpage }">
                <a href="javascript:void(0)" onclick="gotopage(${pagenum})">${pagenum}</a>
            </c:if>
        </c:forEach>
        <c:if test="${bean.nextpage!=bean.currentpage }">
            <a href="javascript:void(0)" onclick="gotopage(${bean.nextpage})">下一页</a>
        </c:if>

        &nbsp; &nbsp; <input type="text" id="pagenum" style="width: 30px">
        <input type="submit" value="GO"
               onclick="gotopage(document.getElementById('pagenum').value)">

    </div>
</div>
</body>
</html>
