<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.beautysalon.model.entity.User" %>
<%@ page import="com.example.beautysalon.model.service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <title>کاربران-ادمین</title>
    <jsp:include page="/links.jsp"></jsp:include>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta charset="UTF-8">
</head>
<body dir="rtl".>
<div>
    <jsp:include page="/head.jsp"></jsp:include>
</div>
<div class="container-fluid">
    <div class="text-center">
        <button type="button" class="btn btn-outline-dark w-75 mb-2 " data-toggle="modal"
                data-target="#modalSubscriptionForm1"><i class="font-weight-bold">ذخیره کاربر جدید</i>
        </button>
    </div>

    <table id="user-table" class="table table-responsive-sm table-striped m-auto">
        <thead>
        <tr>
            <th>شناسه</th>
            <th>نام</th>
            <th>نام خانوادگی</th>
            <th>نام کاربری</th>
            <th>رمز عبور</th>
            <th>سطح دسترسی</th>
            <th>وضعیت</th>
            <th>عملیات</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.family}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.role.role}</td>
                <td>${user.status}</td>
                <td>

                    <div class="row">
                        <div class="col">
                            <button type="button" class="btn btn-outline-dark btn-sm btn- w-100 mb-1"
                                    onclick="showModal(${user.id})">ویرایش
                            </button>
                        </div>
                        <div class="col">
                            <button type="button" class="btn btn-outline-dark btn-sm w-100 "
                                    onclick="remove(${user.id})">حذف
                            </button>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%---------MODAL Save-------%>
    <div class="modal fade" id="modalSubscriptionForm1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">اطلاعات کاربر جدید</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="/user.do" method="post" class="form-group m-2">
                    <div class="modal-body mx-3">

                        <div class="md-form mb-4">
                            <label class="float-right" data-error="wrong" data-success="right" for="username">نام
                                کاربری</label>
                            <input class="form-control validate" id="username" type="text" name="username"
                                   placeholder="username">
                        </div>

                        <div class="md-form mb-4">
                            <label class="float-right" data-error="wrong" data-success="right" for="password">رمز
                                عبور</label>
                            <input class="form-control validate" id="password" type="text" name="password"
                                   placeholder="password">
                        </div>

                        <div class="md-form mb-4">
                            <label class="float-right" data-error="wrong" data-success="right" for="name">
                                نام</label>
                            <input class="form-control validate" id="name" type="text" name="name"
                                   placeholder="Name">
                        </div>

                        <div class="md-form mb-4">
                            <label class="float-right" data-error="wrong" data-success="right" for="family">نام
                                خانوادگی</label>
                            <input class="form-control validate" id="family" type="text" name="family"
                                   placeholder="Family">
                        </div>

                        <div class="md-form mb-5">
                            <label class="float-right" data-error="wrong" data-success="right" for="phoneNumber">شماره
                                تلفن</label>
                            <input class="form-control validate" id="phoneNumber" type="text" name="phoneNumber"
                                   placeholder="phoneNumber">
                        </div>

                        <div class="md-form mb-4">
                            <select name="role" id="role" class="form-select-lg w-100"
                                    aria-label=".form-select-lg example">
                                <option selected>دسترسی</option>
                                <c:forEach var="role" items="${rolesList}">
                                    <option value="${role.role}">${role.role}</option>
                                </c:forEach>
                            </select>
                        </div>

                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                        <input type="submit" value="ذخیره" class="btn btn-outline-dark ml-3 mt-4">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%---------MODAL Edit-------%>
    <div class="modal fade" id="modalSubscriptionForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">ویرایش اطلاعات</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetData()">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="/user.do" id="userEdit">
                    <div class="modal-body mx-3">
                        <div class="md-form mb-4 ">
                            <label class="float-right" data-error="wrong" data-success="right" for="idTxt">شناسه</label>
                            <input class="form-control validate" id="idTxt" type="number" name="id" placeholder="Id" value="${userEdit.id}"
                                  readonly>
                        </div>

                        <div class="md-form mb-4">
                            <label class="float-right" data-error="wrong" data-success="right" for="usernameTxt">نام
                                کاربری</label>
                            <input class="form-control validate" id="usernameTxt" type="text" name="Username" placeholder="username"
                                   value="${userEdit.userName}" >
                        </div>

                        <div class="md-form mb-4">
                            <label class="float-right" data-error="wrong" data-success="right" for="passwordTxt">رمز
                                عبور</label>
                            <input class="form-control validate" id="passwordTxt" type="text" name="Password" placeholder="password"
                                   value="${userEdit.password}">
                        </div>

                        <div class="md-form mb-4">
                            <label class="float-right" data-error="wrong" data-success="right" for="nameTxt">
                                نام</label>
                            <input class="form-control validate" id="nameTxt" type="text" name="name"
                                   value="${userEdit.name}" placeholder="Name">
                        </div>

                        <div class="md-form mb-4">
                            <label class="float-right" data-error="wrong" data-success="right" for="familyTxt">نام
                                خانوادگی</label>
                            <input class="form-control validate" id="familyTxt" type="text" name="family"
                                   value="${userEdit.family}" placeholder="Family">
                        </div>

                        <div class="md-form mb-5">
                            <label class="float-right" data-error="wrong" data-success="right" for="phoneNumberTxt">شماره
                                تلفن</label>
                            <input class="form-control validate" id="phoneNumberTxt" type="text" name="phoneNumber"
                                   value="${userEdit.phoneNumber}"  placeholder="phoneNumber">
                        </div>
                        <div class="md-form mb-5">
                            <label class="float-right" data-error="wrong" data-success="right" for="statusTxt">دسترسی</label>
                            <select name="role"  class="form-select-lg w-100"
                                    aria-label=".form-select-lg example" id="roleTxt">
                                <option selected>${userEdit.role.role}</option>
                                <c:forEach var="role" items="${rolesList}">
                                    <option value="${role.role}">${role.role}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="md-form mb-4">
                            <label class="float-right" data-error="wrong" data-success="right">وضعیت</label>
                            <select name="role"  class="form-select-lg w-100"
                                    aria-label=".form-select-lg example" id="statusTxt">
                                <option selected>${userEdit.status}</option>
                                <option value="true">فعال</option>
                                <option value="false">غیر فعال</option>
                            </select>
                        </div>

                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                        <button class="btn btn-indigo" onclick="edit()" type="reset">ذخیره اطلاعات <i
                                class="fas fa-paper-plane-o ml-1"></i></button>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <script src="../../asset/js/user.js"></script>
</body>
</html>
