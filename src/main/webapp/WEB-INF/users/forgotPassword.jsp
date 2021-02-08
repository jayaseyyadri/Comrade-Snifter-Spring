
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
    <style>
        <%@include file="/resources/css/footer.css"%>
    </style>
</head>
<body>
   <jsp:include page="/WEB-INF/partials/navbar.jsp"/>

   <div class="container" style="margin: 15px auto">
       <h3>Please enter your username </h3>
       <form action="/forgot" method="post">
        <div class="form-group">
            <label for="forgotPassword">Enter username</label>
            <input class="form-control" type="text"  id="forgotPassword" name="forgotPassword">
            <c:if test="${sessionScope.userNameNotInRecord}">
                <small class="errorMessage">* Username does not match any we have on record, Please try again</small>
            </c:if>
        </div>

    <input type="submit" class="btn btn-danger btn-block" value="Submit">
    </form>
    </div>


    <div class="footer"></div>

<jsp:include page="../partials/bootstrap.jsp"/>
</body>
</html>

