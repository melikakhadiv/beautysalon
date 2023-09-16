<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:include page="/links.jsp"></jsp:include>
</head>
<body dir="rtl">

<nav class="navbar navbar-expand-lg navbar-light mb-2" style="background-color: rgb(228,173,167)
">
    <a class="navbar-brand" href="/home.jsp">سالن زیبایی</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link align-items-start" href="/home.jsp">خانه <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link align-items-center" href="#">ساعات کاری</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle align-items-end" href="#items" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    فهرست
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown" id="items">
                    <a class="dropdown-item" href="/user.do">لیست کاربران</a>
<%--                    <div class="dropdown-divider"></div>--%>
                    <a class="dropdown-item" href="/beauty.do">لیست خدمات</a>
                    <a class="dropdown-item" href="/timing.do">لیست زمانبندی</a>
                    <a class="dropdown-item" href="/service.do">لیست خدمات زیبایی</a>
                    <a class="dropdown-item" href="/roles.do">لیست دسترسی</a>
                    <a class="dropdown-item" href="/reserve.do">لیست نوبت دهی</a>
                    <a class="dropdown-item" href="/logout.do">خارج شوید</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="جست و جو در سایت" aria-label="Search">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">جست و جو</button>
        </form>
    </div>
</nav>
</body>
</html>
