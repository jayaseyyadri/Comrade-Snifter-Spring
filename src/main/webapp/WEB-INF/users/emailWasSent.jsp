<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Email Was Sent" />
    </jsp:include>
    <style>
        <%@include file="/resources/css/footer.css"%>
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="text-center">
    <h1>An email was sent to what we have on file, please follow the link to reset your password</h1>
</div>


<div class="footer"></div>

<jsp:include page="../partials/bootstrap.jsp"/>

</body>
</html>
