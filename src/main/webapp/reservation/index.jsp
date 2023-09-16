<%@ page import="com.example.beautysalon.model.entity.Reservation" %>
<%@ page import="com.example.beautysalon.model.service.ReservationService" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/7/2023
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>RESERVED</h1>
<table id="reserve-table" class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>USER_ID</th>
        <th>BEAUTY_SERVICE_ID</th>
        <th>TIMING_ID</th>
        <th>RESERVE_TIME</th>
        <th>PRE_PAY</th>
    </tr>
    </thead>
    <tbody>
    <% for (Reservation reservation: ReservationService.getService().findAll()) {%>
    <tr>
        <td><%=reservation.getId()%>
        </td>
        <td><%=reservation.getCustomer()%>
        </td>
        <td><%=reservation.getBeauty()%>
        </td>
        <td><%=reservation.getTiming()%>
        </td>
        <td><%=reservation.getReservationTime()%>
        </td>
        <td><%=reservation.getPrePay()%>
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
