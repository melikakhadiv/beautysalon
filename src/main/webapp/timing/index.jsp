<%@ page import="com.example.beautysalon.model.entity.Timing" %>
<%@ page import="com.example.beautysalon.model.service.TimingService" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/5/2023
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>time saved</h1>
<table id="timing-table" class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>START TIME</th>
        <th>END TIME</th>
        <th>DAY</th>
        <th>BEAUTY SERVICE</th>
        <th>STYLIST</th>
    </tr>
    </thead>
    <tbody>
    <% for (Timing timing: TimingService.getService().findAll()) {%>
    <tr>
        <td><%=timing.getId()%>
        </td>
        <td><%=timing.getStartTime()%>
        </td>
        <td><%=timing.getEndTime()%>
        </td>
        <td><%=timing.getDay()%>
        </td>
        <td><%=timing.getBeauty()%>
        </td>
        <td><%=timing.getUser()%>
        </td>
        <td><Button><i class="fa fa-edit"></i> Edit</Button>
            <Button><i class="fa fa-remove"></i> Remove</Button>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
