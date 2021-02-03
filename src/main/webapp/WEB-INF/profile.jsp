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

    <c:forEach var="drink" items="${drinks}">
        <div class="col-md-6">
            <div class="card">
                <div class="card-title">
                    <h2>${drink.name}</h2>
                </div>
                <div class="card-body">
                    <img src="${drink.image}" alt="drink">
                    <p>${drink.ingredients}</p>
                    <p>${drink.instructions}</p>
                </div>
                <div class="card-footer">
                    <form action="/show" method="post">
                        <input type="hidden" value="${drink.id}" name="adId">
                        <button type="submit">View Ad</button>
                    </form>
                </div>
            </div>



        </div>
    </c:forEach>
    </div>



</body>
</html>
