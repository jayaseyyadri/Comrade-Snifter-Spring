<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Drink" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
    <div class="container">
        <h1>Create a new Drink</h1>
        <form action="/drinks/create" method="post">
            <div class="form-group">
                <label for="name">Drink Name</label>
                <input id="name" name="name" class="form-control" type="text">
                <c:if test="${sessionScope.blankName}">
                    <small class="errorMessage">Name Can Not Be Empty</small>
                </c:if>
            </div>
            <div class="form-group">
                <label for="instructions">Drink Instructions</label>
                <textarea id="instructions" name="instructions" class="form-control" type="text"></textarea>
                <c:if test="${sessionScope.blankInstructions}">
                    <small class="errorMessage">Instructions Can Not Be Empty</small>
                </c:if>
            </div>
            <div class="form-group">
                <label for="ingredients">Drink Ingredients</label>
                <textarea id="ingredients" name="ingredients" class="form-control" type="text"></textarea>
                <c:if test="${sessionScope.blankIngredients}">
                    <small class="errorMessage">Ingredients Can Not Be Empty</small>
                </c:if>
            </div>
            <div class="form-group">
                <label for="image">Image Url</label>
                <input id="image" name="image" class="form-control" type="text" placeholder="Optional">
            </div>
            <input type="submit" class="btn btn-block btn-danger">
        </form>
    </div>

    <jsp:include page="../partials/bootstrap.jsp"/>
</body>
</html>
