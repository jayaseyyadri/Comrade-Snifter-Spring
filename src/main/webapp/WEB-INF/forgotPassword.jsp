
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
<h3>Please enter your email address </h3>
    <label for="email"><input type="email" placeholder="abc@xyz.com" id="email"></label>
    <button type="submit">Submit</button>

</div>

<jsp:include page="./partials/bootstrap.jsp"/>
</body>
</html>
