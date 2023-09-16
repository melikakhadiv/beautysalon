<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/8/2023
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if(session.getAttribute("user") == null){
    response.sendRedirect("/login.jsp");
}
%>
<%--RESERVATION--%>

<h1>RESERVATION LIST</h1>
</body>
</html>
