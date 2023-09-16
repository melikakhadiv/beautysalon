<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/6/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<% if(session.getAttribute("user") == null){
    response.sendRedirect("/login.jsp");
}
%>
<h1>Hi</h1>
<%--LOG TABLE--%>
</body>
</html>
