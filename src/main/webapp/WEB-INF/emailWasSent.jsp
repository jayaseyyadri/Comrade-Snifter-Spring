<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Email Was Sent" />
    </jsp:include>
    <style>
        .errorMessage{
            color: #dc3444;
        }
        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            height: 20%;
            width: 100%;
            background-color: #343a40;
            color: white;
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div id="resetPage">
    <h1>An email was sent to what we have on file, please follow the link to reset your password</h1>
</div>


<div class="footer"></div>

<jsp:include page="./partials/bootstrap.jsp"/>

</body>
</html>
