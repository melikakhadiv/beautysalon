
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <title>صفحه ورود</title>
    <jsp:include page="links.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body dir="rtl">
<div >
    <jsp:include page="head.jsp"></jsp:include>
</div>
<div class="container-fluid">
<div class="content justify-content-center" >
    <div class="container">
        <div class="row justify-content-center" >
            <div class="col-lg-3 col-sm-4 contents" ></div>
            <div class="col-lg-6 col-sm-4 contents align-items-center justify-content-center" >
                <div class="col-md-8 ">
                    <div class="mb-4 justify-content-center">
                        <h3  class="align-items-center">ورود</h3>
                        <p class="mb-4 text-right" style="color: black">خوش آمدید</p>
                    </div>
                    <form action="/login.do" method="post" class=" align-items-center justify-content-center">

                        <div class="form-group first justify-content-center">
                            <label for="username"> نام کاربری</label>
                            <input type="text" class="form-control justify-content-center" id="username" name="username" required >
                        </div>

                        <div class="form-group last mb-4 justify-content-center">
                            <label for="password"> رمز عبور</label>
                            <input type="password" class="form-control justify-content-center" id="password" name="password" required>
                        </div>

                        <div class="d-flex mb-4 justify-content-center ">
                            <label class="control control--checkbox mb-0" ><span class="caption">مرا به خاطر بسپار</span>
                                <input type="checkbox" name="remember"  style="color: rgb(228,217,205)"/>
                                <div class="control__indicator"></div>
                            </label>
                            <!--                <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> -->
                        </div>

                        <input type="submit" value="ورود" class="btn btn-block mb-2 justify-content-center" style="background-color: rgb(228,173,167)">

                        <!--              <span class="d-block text-left my-4 text-muted">&mdash; or login with &mdash;</span>-->
                        <div><a href="/signup.jsp" class="mb-2" style="font-size: small">هنوز ثبت نام نکردید؟</a></div>

                        <div class="social-login justify-content-center">
                            <a href="https://www.facebook.com" class="facebook" style="border-bottom-color: rgb(228,217,204); background-color: rgb(228,173,167)">
                                <span class="icon-facebook mr-3"></span>
                            </a>
                            <a href="https://www.twitter.com" class="twitter" style="border-bottom-color: rgb(228,217,204); background-color: rgb(228,173,167)">
                                <span class="icon-twitter mr-3"></span>
                            </a>
                            <a href="https://www.google.com/" class="google" style="border-bottom-color: rgb(228,217,204); background-color: rgb(228,173,167)">
                                <span class="icon-google mr-3" ></span>
                            </a>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-lg-3 col-sm-4 contents" ></div>

        </div>
    </div>
</div>
</div>
</body>
</html>
