<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.beautysalon.model.entity.Beauty" %>
<%@ page import="com.example.beautysalon.model.service.BeautyService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <title>خدمات-ادمین</title>
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
    <form action="/beauty.do" method="post" class="form-group">
        <label for="name">نام خدمات زیبایی</label>
        <select name="name" id="name">
            <c:forEach var="beauty" items="${beautyNameList}">
                <option value="${beauty.name}">${beauty.name}</option>
            </c:forEach>
        </select>
        <label for="stylist">آرایشگر</label>
        <select name="stylist" id="stylist">
            <c:forEach var="beauty" items="${beautyUserList}">
                <option value="${beauty.user.name}">${beauty.user.name} ${beauty.user.family}</option>
            </c:forEach>
        </select>
        <label for="price">قیمت</label>
        <input type="text" id="price" name="price" placeholder="price">
        <label for="duration">مدت زمان</label>
        <input type="text" id="duration" name="duration" placeholder="duration time (minute)">
        <input type="submit" value="ذخیره" class="btn-group">
    </form>
</div>


        <table id="beauty-service-table" class="table table-hover">
            <thead>
            <tr>
                <th>شناسه</th>
                <th>نام خدمات زیبایی</th>
                <th>مبلغ</th>
                <th>مدت زمان</th>
                <th>آرایشگر</th>
                <th>عملیات</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="beauty" items="${beautyList}">
            <tr>
                <td>${beauty.id}</td>
                <td>${beauty.beautyName.name}</td>
                <td>${beauty.price}</td>
                <td>${beauty.duration}</td>
                <td>${beauty.user.name} ${beauty.user.family} </td>
                <td>
                    <button onclick="edit(${beauty.id},${beauty.beautyName.name},${beauty.price},${beauty.duration},${beauty.user.name} ${beauty.user.family})">ویرایش</button>
                    <button onclick="remove(${beauty.id},${beauty.beautyName.name},${beauty.price},${beauty.duration},${beauty.user.name} ${beauty.user.family})">حذف</button>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    <button id="myBtn">Open Modal</button>
    <!-- The Modal -->
    <div id="myModal" class="modal">

        <!-- Modal content -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <p>Close</p>
            <h1 id="label"></h1>
            <form id="form" action="/profile.do" method="post">
                <input type="text" id="bid" name="id" placeholder="Id"><br><br>
                <input type="text" id="bname" name="name" placeholder="Name"><br><br>
                <input type="text" id="bprice" name="price" placeholder="Price"><br><br>
                <input type="text" id="bduration" name="duration" placeholder="Duration"><br><br>
                <input type="text" id="bstylist" name="stylist" placeholder="Stylist"><br><br>
                <input type="submit" id="ok" value="Edit"><br>
            </form>
        </div>

    </div>
    <script>
        async function edit(id,name,price,duration,stylist){
            var label = document.getElementById("label")
            var modal = document.getElementById("myModal");
            var idTxt = document.getElementById("bid");
            var nameTxt = document.getElementById("bname");
            var priceTxt = document.getElementById("bprice");
            var durationTxt = document.getElementById("bduration");
            var stylistTxt = document.getElementById("bstylist");

            document.getElementById("ok").value="Edit";
            modal.style.display = "block";

            fetch("/service.do", {
                method: "PUT",
                body: JSON.stringify({
                    id: id,
                    name: name,
                    price: price,
                    duration: duration,
                    stylist: stylist
                }),
                headers:{
                    "Content-Type" : "application/json"
                }
            })
                .then(response => response.json())
                .then(data => console.log(JSON.stringify(data)));
            idTxt.value = id;
            nameTxt.value = name;
            priceTxt.value = price;
            duration.value = durationTxt;
            stylistTxt.value  = stylist;
            idTxt.readOnly = false;
            nameTxt.readOnly = false;
            priceTxt.readOnly = false;
            duration.readOnly = false;
            stylistTxt.readOnly  = false;
            label.innerText = "ویرایش";

        }

        async function remove(id,name,price,duration,stylist){
            var label = document.getElementById("label")
            var modal = document.getElementById("myModal");
            var idTxt = document.getElementById("bid");
            var nameTxt = document.getElementById("bname");
            var priceTxt = document.getElementById("bprice");
            var durationTxt = document.getElementById("bduration");
            var stylistTxt = document.getElementById("bstylist");

            document.getElementById("ok").value="Remove";
            modal.style.display = "block";

            fetch("/service.do", {
                method: "DELETE",
                body: JSON.stringify({
                    id: id
                }),
                headers:{
                    "Content-Type" : "application/json"
                }
            })
                .then(response => response.json())
                .then(data => console.log(JSON.stringify(data)));
            idTxt.value = id;
            nameTxt.value = name;
            priceTxt.value = price;
            duration.value = durationTxt;
            stylistTxt.value  = stylist;
            idTxt.readOnly = true;
            nameTxt.readOnly = true;
            priceTxt.readOnly = true;
            duration.readOnly = true;
            stylistTxt.readOnly  = true;
            label.innerText = "حذف";

        }

        // Get the modal
        var modal = document.getElementById("myModal");

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal
        btn.onclick = function() {
            var idTxt = document.getElementById("bid");
            var nameTxt = document.getElementById("bname");
            var priceTxt = document.getElementById("bprice");
            var durationTxt = document.getElementById("bduration");
            var stylistTxt = document.getElementById("bstylist");

            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
</div>
</body>
</html>
