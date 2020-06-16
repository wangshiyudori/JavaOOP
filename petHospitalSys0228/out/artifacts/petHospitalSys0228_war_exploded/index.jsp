<%--
  Created by IntelliJ IDEA.
  User: dori
  Date: 2020/2/28
  Time: 4:24 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--  <head>--%>
<%--    <title>$Title$</title>--%>
<%--  </head>--%>
<%--  <body>--%>
<%--  $END$--%>
<%--  </body>--%>


<head>
  <title>宠物医院</title>
  <!-- Meta-Tags -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="utf-8">
  <meta name="keywords" content="Key Login Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
  <script>
    addEventListener("load", function () {
      setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
      window.scrollTo(0, 1);
    }
  </script>
  <!-- //Meta-Tags -->
  <!-- Index-Page-CSS -->
  <link rel="stylesheet" href="./loginStatic/css/style.css" type="text/css" media="all">
  <link rel="stylesheet" href="./loginStatic/css/style.css" type="text/css" media="all">
  <!-- //Custom-Stylesheet-Links -->
  <!--fonts -->
  <!-- //fonts -->
  <link rel="stylesheet" href="./loginStatic/css/font-awesome.min.css" type="text/css" media="all">
  <!-- //Font-Awesome-File-Links -->

  <!-- Google fonts -->
  <link href="//fonts.googleapis.com/css?family=Quattrocento+Sans:400,400i,700,700i" rel="stylesheet">
  <link href="//fonts.googleapis.com/css?family=Mukta:200,300,400,500,600,700,800" rel="stylesheet">
  <!-- Google fonts -->

</head>
<!-- //Head -->
<!-- Body -->

<body>

<section class="main">
  <div class="layer">

    <div class="bottom-grid">

      <div class="links">
        <ul class="links-unordered-list">
          <li class="active">
            <a href="#" class="">Login</a>
          </li>

          <li class="">
            <a href="#" class="">Register</a>
          </li>
        </ul>
      </div>
    </div>

    <div class="content-w3ls">
      <div class="text-center icon">
        <span class="fa fa-html5"></span>
      </div>

      <div class="content-bottom">
        <form action="#" method="post">

          <div class="field-group">
            <span class="fa fa-user" aria-hidden="true"></span>
            <div class="wthree-field">
              <input name="text1" id="text1" type="text" value="" placeholder="用户名" required>
            </div>
          </div>

          <div class="field-group">
            <span class="fa fa-lock" aria-hidden="true"></span>
            <div class="wthree-field">
              <input name="password" id="myInput" type="Password" placeholder="密码">
            </div>
          </div>

          <div class="field-group">
            <div class="wthree-field">
              <input name="checkcode" id="checkcode" type="text" placeholder="验证码">
            </div>
          </div>

          <div class="field-group">
            <div class="wthree-field">
              <input name="Newimg-code" id="Newimg-code" type="image" alt="看不清，点击换图" src="CheckCode"
                     onclick="javascript:this.src='/CheckCode?+rand=Math.random()'" placeholder="点击刷新">
            </div>
          </div>



<%--          <tr class="cols2">--%>
<%--            <td colspan="2"><input type="submit" value="登录" /><input--%>
<%--                    type="reset" value="重置" /></td>--%>
<%--          </tr>--%>
<%--          <tr class="cols2">--%>
<%--            <td colspan="2" class="info"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %></td>--%>
<%--          </tr>--%>



          <div class="wthree-field">
            <button type="submit" class="btn">登录</button>
          </div>
          <div class="wthree-field">
            <%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
          </div>

        </form>
      </div>
    </div>


  </div>
</section>

</body>
<!-- //Body -->
</html>



