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
            <h2> <c:out value="${drink.name}"/></h2>
            <p><c:out value=" ${drink.instructions}"/></p>
            <p><c:out value="${drink.ingredients}"/></p>
            <img src="<c:out value="${drink.image}"/>" alt="drink">
            <form action="/show" method="post">
                <input type="hidden" name="drinkId" value="${drink.id}">
                <button type="submit" class="btn btn-primary">View Drink Details</button>
            </form>
            
            
            
            <c:if test="${sessionScope.user != null}">
                <c:if test="${drink.userId == sessionScope.user.id}">
                <form action="/delete" method="post">
                <input type="hidden" name="deleteThisDrink" value="${drink.id}">
                <button type="submit" class="btn btn-primary">Delete</button>
            </form>
            <form action="/editForm" method="get">
                <input type="hidden" name="editThisDrink" value="${drink.id}">
                <button type="submit" class="btn btn-primary">Edit Drink Details</button>
            </form>
                </c:if>
            </c:if>
        </div>
    </c:forEach>
</div>

</body>
</html>
