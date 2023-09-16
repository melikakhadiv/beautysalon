<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ثبت نام</title>
    <meta charset="UTF-8">
    <jsp:include page="/links.jsp"></jsp:include>

</head>
<body dir="rtl">
<div>
    <jsp:include page="head.jsp"></jsp:include>
</div>
<div class="container-fluid">


    <div class="content" align="center">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-3 col-sm-4 contents"></div>
                <div class="col-lg-6 col-sm-4 contents">
                    <div class="col-md-8">
                        <div class="mb-4">
                            <h3 align="center">ورود</h3>
                            <p class="mb-4" align="right" style="color: black">خوش آمدید</p>
                        </div>
                        <form action="/user.do" method="post">

                            <div class="form-group first" align="right">
                                <label for="username">نام کاربری</label>
                                <input type="text" class="form-control" id="username" name="username" required>
                            </div>

                            <div class="form-group  " align="right">
                                <label for="password">رمز عبور</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>

                            <div class="form-group  " align="right">
                                <label for="name">نام</label>
                                <input type="text" class="form-control" id="name" name="name" required>
                            </div>

                            <div class="form-group  " align="right">
                                <label for="family">نام خانوادگی</label>
                                <input type="text" class="form-control" id="family" name="family" required>
                            </div>

                            <div class="form-group  " align="right">
                                <label for="phoneNumber">شماره تلفن</label>
                                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>
                            </div>

                            <div class="form-group last mb-4" align="right">
                                <select name="role" id="role" class="custom-select">
                                    <option value="stylist">آرایشگر</option>
                                    <option value="customer">مشتری</option>
                                </select>
                            </div>

                            <div class="d-flex mb-4 align-items-center">
                                <label class="control control--checkbox mb-0"><span
                                        class="caption">مرا به خاطر بسپار</span>
                                    <input type="checkbox" style="color: rgb(228,217,205)"/>
                                    <div class="control__indicator"></div>
                                </label>
                                <!--                <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> -->
                            </div>

                            <input type="submit" value="ثبت نام" class="btn btn-block mb-2"
                                   style="background-color: rgb(228,173,167)">

                            <!--              <span class="d-block text-left my-4 text-muted">&mdash; or login with &mdash;</span>-->
                            <div><a href="/login.jspin.jsp" style="font-size: small">حساب کاربری دارید؟</a></div>

                            <div class="social-login">
                                <a href="https://www.facebook.com" class="facebook"
                                   style="border-bottom-color: rgb(228,217,204); background-color: rgb(228,173,167)">
                                    <span class="icon-facebook mr-3"></span>
                                </a>
                                <a href="https://www.twitter.com" class="twitter"
                                   style="border-bottom-color: rgb(228,217,204); background-color: rgb(228,173,167)">
                                    <span class="icon-twitter mr-3"></span>
                                </a>
                                <a href="https://www.google.com/" class="google"
                                   style="border-bottom-color: rgb(228,217,204); background-color: rgb(228,173,167)">
                                    <span class="icon-google mr-3"></span>
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-4 contents"></div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
