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


    <div class="container-fluid d-flex" style="margin: 0 !important; justify-content: space-around">
        <div class="row">
            <div class="col col-md-4 d-flex">
                <jsp:include page="/WEB-INF/partials/profile-card.jsp" />
            </div>

            <div class="col col-md-8 justify-content-center align-items-center d-flex">
                <form action="/drinks/create" method="get">
                    <input type="submit" class="btn" value="Create Drink Here!">
                        <a class="dropdown-item" href="#"><h3>View Favorites</h3></a>
                        <a class="dropdown-item" href="/editProfile"><h3>Edit Profile</h3></a>
                        <a class="dropdown-item" href="/users"><h3>Edit Users</h3></a>
                </form>
            </div>
        </div>

    </div>

    <jsp:include page="partials/drink-cards.jsp"/>

<jsp:include page="./partials/bootstrap.jsp"/>
</body>
</html>
