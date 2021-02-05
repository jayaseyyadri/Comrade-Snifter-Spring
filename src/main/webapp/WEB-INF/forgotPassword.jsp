
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/forgotPassword" method="post">
    <h3>Please enter your username </h3>
    <label for="forgotPassword">Enter username<input type="text"  id="forgotPassword" name="forgotPassword"></label>
    <button type="submit">Submit</button>
    </form>
</div>
<h2>Error :${pageContext.exception}</h2>
Exception stack:
<c:forEach var="trace" items="${pageContext.}"
<jsp:include page="./partials/bootstrap.jsp"/>
</body>
</html>
