<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

    <div class="container">
    <form action="/drinks/create" method="get">
        <input type="submit" class="btn" value="Create Drink Here!">
    </form>
    <h3>Here Are Your Drinks!</h3>

    <div class="container-fluid">
        <jsp:include page="partials/drink-cards.jsp"></jsp:include>
    </div>
    </div>



</body>
</html>
