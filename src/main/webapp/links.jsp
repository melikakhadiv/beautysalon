
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="asset/fonts/icomoon/style.css">
<link rel="stylesheet" href="asset/css/bootstrap.min.css">
<link rel="stylesheet" href="asset/css/my.css">
<link rel="stylesheet" href="asset/css/style.css">
<link rel="stylesheet" type="text/css" href="asset/css/style.css">
<link rel="stylesheet" href="asset/css/responsive.css">
<link rel="stylesheet" href="asset/css/jquery.mCustomScrollbar.min.css">
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet" href="asset/css/owl.carousel.min.css">
<link rel="stylesheet" href="asset/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/asset/css/jquery.fancybox.css" media="screen">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/asset/fonts/icomoon/style.css">
<link rel="stylesheet" href="/asset/css/owl.carousel.min.css">
<link rel="stylesheet" href="/asset/css/bootstrap.min.css">
<link rel="stylesheet" href="/asset/css/style.css">
<script src="/asset/js/jquery-3.3.1.min.js"></script>
<script src="/asset/js/bootstrap.min.js"></script>
<script src="/asset/js/main.js"></script>
<script src="/asset/js/bootstrap.min.js"></script>
<script src="/asset/js/jquery.min.js"></script>
<script src="/asset/js/bootstrap.bundle.min.js"></script>
<script src="/asset/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="/asset/js/custom.js"></script>
<script src="/asset/js/owl.carousel.js"></script>
<script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
<script>
    $(document).ready(function(){
        $(".fancybox").fancybox({
            openEffect: "none",
            closeEffect: "none"
        });

        $(".zoom").hover(function(){

            $(this).addClass('transition');
        }, function(){

            $(this).removeClass('transition');
        });
    });

</script>
<script>
    function openNav() {
        document.getElementById("myNav").style.width = "100%";
    }

    function closeNav() {
        document.getElementById("myNav").style.width = "0%";
    }
</script>