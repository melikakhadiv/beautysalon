<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.beautysalon.model.entity.Reservation" %>
<%@ page import="com.example.beautysalon.model.service.ReservationService" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/8/2023
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <title>لیست نوبت دهی-ادمین</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <jsp:include page="/links.jsp"></jsp:include>
</head>
<body dir="rtl">
<div>
    <jsp:include page="/head.jsp"></jsp:include>
</div>
<div class="container-fluid">
<div class="row">
<form action="/reserve.do" method="post" class="form-group">
<label for="bs">خدمات زیبایی</label>
    <select name="beauty" id="bs">
        <c:forEach var="beauty" items="${beautyDistinctList}">
            <option value="${beauty}">${beauty}</option>
        </c:forEach>
    </select>
    <label for="st">آرایشگر</label>
    <select name="userId" id="st">
        <c:forEach var="beauty" items="${beautyNameList}">
            <option value="${beauty.user.id}">
                    ${beauty.user.name} ${beauty.user.family}</option>
        </c:forEach>

    </select>
    <label for="day">تاریخ</label>
    <select name="beautyServiceDay" id="day" >
        <c:forEach var="beautyDay" items="${timingBeautyUserList}">
            <option value="${beautyDay.day}">${beautyDay.day}</option>
        </c:forEach>
    </select>

    <label for="dayTime">ساعت</label>
    <select name="beautyDayTime" id="dayTime">
        <c:forEach var="time" items="${timingBeautyUserDayList}">
            <option value="${time.startTime}">${time.startTime}</option>
        </c:forEach>
    </select>

    <label for="prepay">پیش پرداخت</label>
    <input type="text" id="prepay" name="prePay" placeholder="pre pay">
    <input type="submit" value="ذخیره" class="btn-group">
</form>
</div>

<table id="reserve-table" class="table table-hover">
    <thead>
    <tr>
        <th>شناسه</th>
        <th>کاربر</th>
        <th>خدمات زیبایی</th>
        <th>آرایشگر</th>
        <th>تاریخ</th>
        <th>ساعت رزرو</th>
        <th>پیش پرداخت</th>
        <th>عملیات</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="reserve" items="${reserveList}">
    <tr>
        <td>${reserve.id}
        </td>
        <td>${reserve.customer.name} ${reserve.customer.family}
        </td>
        <td>${reserve.beauty.beautyName.name}
        </td>
        <td>${reserve.beauty.user.name} ${reserve.beauty.user.family}
        </td>
        <td>${reserve.timing.day}
        </td>
        <td>${reserve.reservationTime}
        </td>
        <td>${reserve.prePay}
        <td>
            <button onclick="edit(${reserve.id})">ویرایش</button>
            <button onclick="remove(${reserve.id})">حذف</button>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

    <script>
        async function remove(id) {
            await fetch(
                "http://localhost:80/reserve.do",
                {
                    method: "DELETE",
                    headers: {
                        'Content-type': 'application/json; charset=UTF-8'
                    },
                    body: JSON.stringify({id: id})
                }
            ).then(response => response.json())
                .then(data => console.log(data)) // Manipulate the data retrieved back, if we want to do something with it
                .catch(err => console.log(err))
        }

        function edit(id) {
            alert(id);
        }
    </script>
</div>
</body>
</html>
