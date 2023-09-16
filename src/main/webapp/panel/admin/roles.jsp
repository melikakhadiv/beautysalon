<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <title>دسترسی-ادمین</title>
    <jsp:include page="/links.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body dir="rtl">
<div>
    <jsp:include page="/head.jsp"></jsp:include>
</div>
<div class="container-fluid">
    <div class="row">
        <form action="/roles.do" method="post" class="form-group">
            <label for="role">نام دسترسی</label>
            <input type="text" name="role" id="role">
            <input type="submit" value="ذخیره" class="btn-group">
        </form>
    </div>

    <table id="beauty-service-table" class="table table-hover">
        <thead>
        <tr>
            <th>شناسه</th>
            <th>دسترسی</th>
            <th>عملیات</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="role" items="${rolesList}">
            <tr>
                <td>${role.id}</td>
                <td>${role.role}</td>
                <td>
                    <button onclick="edit(${role.id})">ویرایش</button>
                    <button onclick="remove(${role.id})">حذف</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
