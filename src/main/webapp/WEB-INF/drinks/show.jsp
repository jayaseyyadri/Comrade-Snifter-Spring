<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<jsp:include page="/WEB-INF/partials/creator-profile-card.jsp" />


<div class="container">
    <h2>${sessionScope.drink.name}</h2>
    <p>${sessionScope.drink.instructions}</p>
    <p>${sessionScope.drink.ingredients}</p>
    <img src="${sessionScope.drink.image}" alt="drink">
</div>

<div class="container">
    <form action="/drinks" method="get">
        <button type="submit">Go Back</button>
    </form>

</div>

</body>
</html>