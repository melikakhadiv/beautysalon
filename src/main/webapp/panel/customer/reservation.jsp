<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/17/2023
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="reserve-table" class="table table-hover">
    <thead>
    <tr>
        <th>شناسه</th>
        <th>شناسه کاربر</th>
        <th>شناسه خدمات زیبایی</th>
        <th>شناسه زمانی</th>
        <th>تاریخ رزرو</th>
        <th>پیش پرداخت</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="reserve" items="${reserveList}">
        <tr>
            <td>${reserve.id}
            </td>
            <td>${reserve.user.id}
            </td>
            <td>${reserve.beauty.id}
            </td>
            <td>${reserve.timing.id}
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
</body>
</html>
