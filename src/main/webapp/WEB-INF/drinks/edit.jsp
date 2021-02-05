<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Drink" />
    </jsp:include>
    <style>
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
<jsp:include page="/WEB-INF/partials/navbar.jsp">
    <jsp:param name="profileOne" value="/profile"/>
    <jsp:param name="profileTwo" value="Profile"/>
</jsp:include>
<div class="container">
    <h1>Edit Drink Info</h1>
    <form action="/edit" method="post">
        <div class="form-group">
            <label for="newName">Drink Name</label>
            <input id="newName" name="newName" class="form-control" type="text">
            <c:if test="${sessionScope.blankNewName}">
                <small class="errorMessage">Name Can Not Be Empty</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="newInstructions">Instructions</label>
            <input id="newInstructions" name="newInstructions" class="form-control"/>
            <c:if test="${sessionScope.blankNewInstructions}">
                <small class="errorMessage">Instructions Can Not Be Empty</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="newIngredients">Ingredients</label>
            <input id="newIngredients" name="newIngredients" class="form-control"/>
            <c:if test="${sessionScope.blankNewIngredients}">
                <small class="errorMessage">Ingredients Can Not Be Empty</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="newImage">Image URL</label>
            <input id="newImage" name="newImage" class="form-control" placeholder="Optional"/>
        </div>
        <input type="submit" class="btn btn-block btn-danger">
    </form>
</div>

<div class="footer"></div>

<jsp:include page="../partials/bootstrap.jsp"/>
</body>
</html>