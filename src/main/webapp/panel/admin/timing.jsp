<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.beautysalon.model.entity.Timing" %>
<%@ page import="com.example.beautysalon.model.service.TimingService" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/8/2023
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <title>زمانبندی-ادمین</title>
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
<form action="/timing.do" method="post" class="form-group">
    <label for="st">شروع کار</label>
    <input type="time" id="st" name="startTime" class="form-control" placeholder="start time">
    <label for="ed">پایان کار</label>
    <input type="time"  id="ed" name="endTime"class="form-control"  placeholder="end time">
    <label for="day">روز کاری</label>
    <input type="date"  id="day" name="day" class="form-control" placeholder="day">
    <label for="bs">خدمات زیبایی</label>
    <select name="beautyServiceName" id="bs" class="form-control">
        <option value="hair_color_stylist">خدمات رنگ مو</option>
        <option value="hair_cutting_stylist">خدمات کوتاهی مو</option>
        <option value="make_up_stylist">خدمات آرایش صورت</option>
        <option value="nail_stylist">خدمات ناخن</option>
        <option value="face_waxing_stylist">خدمات اصلاح صورت</option>
        <option value="extension_stylist">خدمات اکتنشن</option>
    </select>
    <input type="submit" value="ذخیره" class="btn btn-outline-dark">
</form>
</div>

<table id="timing-table" class="table table-hover">
    <thead>
    <tr>
        <th>شناسه</th>
        <th>شروع کار</th>
        <th>پایان کار</th>
        <th>روز کاری</th>
        <th>خدمات زیبایی</th>
        <th>عملیات</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="time" items="${timingList}">
    <tr>
        <td>${time.id}
        </td>
        <td>${time.startTime}
        </td>
        <td>${time.endTime}
        </td>
        <td>${time.day}
        </td>
        <td>${time.beauty.beautyName.name}
        </td>
        <td>
            <button  type="button" class="btn btn-outline-dark " data-toggle="modal"
                     data-target="#modalSubscriptionForm">ویرایش
            </button>
            <button type="button" class="btn btn-outline-dark "  onclick="remove(${time.id})">حذف</button>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<%--    <div class="modal fade" id="modalSubscriptionForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"--%>
<%--         aria-hidden="true">--%>
<%--        <div class="modal-dialog" role="document">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header text-center">--%>
<%--                    <h4 class="modal-title w-100 font-weight-bold">ویرایش اطلاعات</h4>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <form action="/timing.do" id="timeEdit">--%>
<%--                    <div class="modal-body mx-3">--%>
<%--                        <div class="md-form mb-5 ">--%>
<%--                            <label class="float-right" data-error="wrong" data-success="right" for="idTxt">شناسه</label>--%>
<%--                            <input class="form-control validate" id="idTxt" type="number" name="id" value="${timing.id}"--%>
<%--                                   placeholder="Id" readonly>--%>
<%--                        </div>--%>

<%--                        <div class="md-form mb-5">--%>
<%--                            <label class="float-right" data-error="wrong" data-success="right" for="dayTxt">روز</label>--%>
<%--                            <input class="form-control validate" id="dayTxt" type="date" name="day"--%>
<%--                                   value="${timing.day}" placeholder="day">--%>
<%--                        </div>--%>

<%--                        <div class="md-form mb-5">--%>
<%--                            <label class="float-right" data-error="wrong" data-success="right" for="startTimeTxt">ساعت شروع</label>--%>
<%--                            <input class="form-control validate" id="startTimeTxt" type="time" name="startTime"--%>
<%--                                   value="${timing.startTime}" placeholder="startTime">--%>
<%--                        </div>--%>

<%--                        <div class="md-form mb-5">--%>
<%--                            <label class="float-right" data-error="wrong" data-success="right" for="endTimeTxt"> ساعت پایان</label>--%>
<%--                            <input class="form-control validate" id="endTimeTxt" type="time" name="endTime"--%>
<%--                                   value="${timing.endTime}" placeholder="endTime">--%>
<%--                        </div>--%>

<%--                        <div class="md-form mb-5">--%>
<%--                            <label class="float-right" data-error="wrong" data-success="right" for="beautyTxt">نام سرویس زیبایی</label>--%>
<%--                            <select name="beauty" id="beautyTxt">--%>
<%--                                <c:forEach var="beauty" items="${beautyDictinctNameList}">--%>
<%--                                    <option value="${beauty.name}">${beauty.name}</option>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    --%>
<%--                    <div class="modal-footer d-flex justify-content-center">--%>
<%--                        <button class="btn btn-indigo" onclick="edit()">ذخیره اطلاعات <i--%>
<%--                                class="fas fa-paper-plane-o ml-1"></i></button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

</div>
</body>
</html>
