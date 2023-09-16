<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/8/2023
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <meta charset="UTF-8">
    <jsp:include page="/links.jsp"></jsp:include>

</head>
<body dir="rtl">
<div>
    <jsp:include page="/head.jsp"></jsp:include>
</div>
<div class="container-fluid">

<div>
    <a href="/user.do">user</a><br>
    <a href="/beauty.do">beauty</a><br>
    <a href="/timing.do">time </a><br>
    <a href="/reserve.do">reserve</a><br>
    <a href="/roles.do">role</a><br>
    <a href="/service.do">service</a><br>
    <a href="/log.do">Logger</a>
</div>
</div>
</body>
</html>
