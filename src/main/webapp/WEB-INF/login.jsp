<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
    <style>
        <%@include file="../resources/css/footer.css"%>
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
                <c:if test="${sessionScope.userNameDoesNotExist}">
                    <small class="errorMessage">Incorrect Username</small>
                </c:if>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
                <c:if test="${sessionScope.incorrectPassword}">
                    <small class="errorMessage">Incorrect Password</small>
                </c:if>
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
