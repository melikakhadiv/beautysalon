<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="fa">
    <title>لیست خدمات-ادمین</title>
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
        <form action="/service.do" method="post" class="form-group">
            <label for="name">نام خدمات زیبایی</label>
           <input type="text" name="name" id="name">
            <input type="submit" value="ذخیره" class="btn-group">
        </form>
    </div>
    <table id="beauty-service-table" class="table table-hover">
        <thead>
        <tr>
            <th>شناسه</th>
            <th>نام خدمات زیبایی</th>
            <th>عملیات</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="beauty" items="${beautyNameList}">
            <tr>
                <td>${beauty.id}</td>
                <td>${beauty.name}</td>
                <td>
                    <button onclick="edit(${beauty.id})">ویرایش</button>
                    <button onclick="remove(${beauty.id})">حذف</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
