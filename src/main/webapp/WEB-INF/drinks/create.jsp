<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Drink" />
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
                Pick A Drink Category
                <label>
                    Brandy
                    <input type="checkbox" value="Brandy" name="Brandy"/>
                </label>
                <label>
                    Bourbon
                    <input type="checkbox" value="Bourbon" name="Bourbon"/>
                </label>
                <label>
                    Whiskey
                    <input type="checkbox" value="Whiskey" name="Whiskey"/>
                </label>
                <label>
                    Fruity
                    <input type="checkbox" value="Fruity" name="Fruity"/>
                </label>
                <label>
                    Desert
                    <input type="checkbox" value="Desert" name="Desert"/>
                </label>

            <div class="form-group">
                <label for="image">Image Url</label>
                <input id="image" name="image" class="form-control" type="text" placeholder="Optional">
            </div>
            <input type="submit" class="btn btn-block btn-danger">
        </form>
    </div>

    <div class="footer"></div>

    <jsp:include page="../partials/bootstrap.jsp"/>
</body>
</html>
