<%@ page import="com.example.beautysalon.model.entity.Reservation" %>
<%@ page import="com.example.beautysalon.model.service.ReservationService" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/8/2023
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESERVE LIST</title>
    <jsp:include page="../links.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>

<% if(session.getAttribute("user") == null){
    response.sendRedirect("/login.jsp");
}
%>
<form action="/reserve.do" method="post">
<%--    <input type="text">--%>
<%--    <input type="text">--%>
<%--    <input type="text">--%>
    <input type="datetime-local" name="reservationTime">
    <input type="text" name="prePay" placeholder="pre pay">
    <input type="submit" value="save"></input>
</form>

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
