
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/forgotPassword" method="post">
<h3>Please enter your email address </h3>
    <label for="forgotPassword"><input type="email" placeholder="abc@xyz.com" id="forgotPassword" name="forgotPassword"></label>
    <button type="submit">Submit</button>
    </form>
</div>

<jsp:include page="./partials/bootstrap.jsp"/>
</body>
</html>
