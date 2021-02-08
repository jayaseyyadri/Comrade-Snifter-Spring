<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="You forgot your Password!?" />
    </jsp:include>
    <style>
        <%@include file="../resources/css/footer.css"%>>
    </style>
</head>
<body>

<div class="container" style="margin-top: 15px">
    <form action="/passwordReset" method="post">
        <div class="form-group">
            <label for="verifyUsername">Verify Username</label>
            <input id="verifyUsername" name="verifyUsername" class="form-control" type="text">
            <c:if test="${sessionScope.userNameDoesNotMatch}">
                <small class="errorMessage"> * Incorrect username, Please Try Again</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="verifyEmailAddress">Verify Email Address</label>
            <input id="verifyEmailAddress" name="verifyEmailAddress" class="form-control" type="email">
                <c:if test="${sessionScope.emailDoesNotMatch}">
                    <small class="errorMessage"> * Incorrect Email Address, Please Try Again</small>
                </c:if>
            </div>
            <div class="form-group">
                <label for="shouldBeTheJupiterOne">Enter The Password</label>
                <input id="shouldBeTheJupiterOne" name="shouldBeTheJupiterOne" class="form-control" type="password">
                <c:if test="${sessionScope.notOurPassword}">
                    <small class="errorMessage"> * Password does not match what was sent to you</small>
                </c:if>
            </div>

            <input type="submit" class="btn btn-danger btn-block">
        </form>
    </div>


    <div class="footer"></div>

    <jsp:include page="../partials/bootstrap.jsp"/>
    </body>
    </html>
