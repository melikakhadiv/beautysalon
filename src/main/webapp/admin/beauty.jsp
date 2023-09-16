<%@ page import="com.example.beautysalon.model.entity.Beauty" %>
<%@ page import="com.example.beautysalon.model.service.BeautyService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="UTF-8">
    <title>BEAUTY SERVICE</title>

        <jsp:include page="../links.jsp"></jsp:include>
    </head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>


<form action="/beauty.do" method="post">
  <input type="text" name="name" placeholder="beauty service name">
  <input type="text" name="price" placeholder="price">
  <input type="text" name="duration" placeholder="duration time (minute)">
  <input type="submit" value="save">
</form>

<table id="beauty-service-table" class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>DURATION</th>
    </tr>
    </thead>
    <tbody>
    <% for (Beauty beauty : BeautyService.getService().findAll()) {%>
    <tr>

        <td><%=beauty.getId()%>
        </td>
        <td><%=beauty.getName()%>
        </td>
        <td><%=beauty.getPrice()%>
        </td>
        <td><%=beauty.getDuration()%>
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
