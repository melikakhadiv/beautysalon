<%@ page import="com.example.beautysalon.model.entity.User" %>
<%@ page import="com.example.beautysalon.model.service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>USER LIST</title>
  <jsp:include page="../links.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>


<form action="/user.do" method="post">
  <input type="text" name="username" placeholder="username">
  <input type="password" name="password" placeholder="password">
  <input type="text" name="name" placeholder="name">
  <input type="text" name="family" placeholder="family">
  <input type="text" name="phoneNumber" placeholder="phone number">
  <select name="role" id="">
    <option value="stylist">Stylist</option>
    <option value="customer">Customer</option>
  </select>
  <input type="submit" value="save">
</form>


<table id="user-table" class="table">
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Family</th>
    <th>Username</th>
    <th>Password</th>
    <th>Role</th>
    <th>Status</th>
  </tr>
  </thead>
  <tbody>
  <% for (User user: UserService.getService().findAll()) {%>
  <tr>
    <td><%=user.getId()%>
    </td>
    <td><%=user.getName()%>
    </td>
    <td><%=user.getFamily()%>
    </td>
    <td><%=user.getUserName()%>
    </td>
    <td><%=user.getPassword()%>
    </td>
    <td><%=user.getRole()%>
    </td>
    <td><%=user.isStatus()%>
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
