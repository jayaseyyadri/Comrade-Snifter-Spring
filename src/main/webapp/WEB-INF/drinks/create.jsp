<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Drink" />
    </jsp:include>
    <style>
        <%@include file="/resources/css/footer.css"%>
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp">
    <jsp:param name="profileOne" value="/profile"/>
    <jsp:param name="profileTwo" value="Profile"/>
</jsp:include>
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
            <c:if test="${sessionScope.blankCat}">
                <small class="errorMessage">Category Can Not Be Missing</small>
            </c:if>
                Drink Category<br>
                <label>
                    <input type="checkbox" value="Brandy" name="drinkCat"/>
                    Brandy
                </label>
                <label>
                    <input type="checkbox" value="Bourbon" name="drinkCat"/>
                    Bourbon
                </label>
                <label>
                    <input type="checkbox" value="Whiskey" name="drinkCat"/>
                    Whiskey
                </label>
                <label>
                    <input type="checkbox" value="Fruity" name="drinkCat"/>
                    Fruity
                </label>
                <label>
                    <input type="checkbox" value="Desert" name="drinkCat"/>
                    Desert
                </label>

            <div class="form-group">
                <label for="image">Image Url</label>
                <input id="image" name="image" class="form-control" type="text" placeholder="Optional">
            </div>
            <input type="submit" class="btn btn-block btn-danger">
        </form>
    </div>

    <div class="footer"></div>
<script>
<%@include file="/resources/js/styling.js"%>
</script>
    <jsp:include page="../partials/bootstrap.jsp"/>
</body>
</html>
