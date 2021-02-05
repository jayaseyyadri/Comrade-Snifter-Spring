<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
    <style>
        .footer {
          position: fixed;
          left: 0;
          bottom: 0;
          height: 40%;
          width: 100%;
          background-color: #343a40;
          color: white;
          text-align: center;
        }
    </style>
</head>
<body>
   <jsp:include page="/WEB-INF/partials/navbar.jsp"/>

    <div class="container" style="margin: 15px auto">
        <h1>Please Log In</h1>
        <form action="/login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <a href="/forgot">Forgot Password?</a>
            </div>
            <input type="submit" class="btn btn-danger btn-block" value="Log In">
        </form>
        <form action="/register" method="GET">
            <small>New to Comrade Snifter? Create an Account...</small>
            <input type="submit" class="btn btn-danger btn-block" value="Register">
        </form>
    </div>



    <div class="footer"></div>

<jsp:include page="./partials/bootstrap.jsp"/>
</body>
</html>
