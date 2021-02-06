<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <style>
        .errorMessage{
            color: #dc3444;
        }
        body {
            background: #cccecf;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp">
    <jsp:param name="profileOne" value=""/>
    <jsp:param name="profileTwo" value=""/>
</jsp:include>


    <div class="container-fluid d-flex" style="margin: 0 !important; justify-content: space-around">
        <div class="row">
            <div class="col col-md-4 d-flex">
                <jsp:include page="/WEB-INF/partials/profile-card.jsp" />
            </div>

            <div class="col col-md-8 flex-column justify-content-center align-items-center d-flex bg-danger border-warning">
                <a class="btn btn-warning btn-block" href="/drinks/create"><h3 class="text-center">Add Drink</h3></a>
                <a class="btn btn-warning btn-block" href="/editProfile"><h3 class="text-center">Edit Profile</h3></a>
                <c:if test="${sessionScope.isAdmin}">
                    <a class="btn btn-warning btn-block" href="/users"><h3 class="text-center">Edit Users</h3></a>
                </c:if>
            </div>
        </div>

    </div>

    <jsp:include page="partials/drink-cards.jsp"/>

<jsp:include page="./partials/bootstrap.jsp"/>
</body>
</html>
