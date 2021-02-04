<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Drinks" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the Drinks!</h1>

    <c:forEach var="drink" items="${drinks}">
        <div class="col-md-6">
            <h2>${drink.name}</h2>
            <p>${drink.instructions}</p>
            <p>${drink.ingredients}</p>
            <img src="${drink.image}" alt="drink">
        </div>
    </c:forEach>
</div>

</body>
</html>
