<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <style>
       <%@include file="../resources/css/footer.css"%>
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp">
    <jsp:param name="profileOne" value=""/>
    <jsp:param name="profileTwo" value=""/>
</jsp:include>


    <div class="container-fluid" style="margin: 0 !important; justify-content: space-around">
        <div class="row">
            <div class="col-6 bg-danger d-flex border-warning my-auto">
                <jsp:include page="/WEB-INF/partials/profile-card.jsp" />
            </div>

            <div class="col-6 flex-column justify-content-center align-items-center d-flex bg-danger border-warning">
                <a class="btn btn-warning btn-block" href="/drinks/create"><h3 class="text-center">Add Drink</h3></a>
                <a class="btn btn-warning btn-block" href="/editProfile"><h3 class="text-center">Edit Profile</h3></a>
                <c:if test="${sessionScope.isAdmin}">
                    <a class="btn btn-warning btn-block" href="/users"><h3 class="text-center">Edit Users</h3></a>
                </c:if>
            </div>
        </div>

    </div>

    <jsp:include page="../partials/drink-cards.jsp"/>

<<<<<<< HEAD:src/main/webapp/WEB-INF/profile.jsp
<div class="footer"></div>

    <jsp:include page="./partials/bootstrap.jsp"/>
=======
<jsp:include page="../partials/bootstrap.jsp"/>
>>>>>>> e61ed495f5429456460eda07759783568021442a:src/main/webapp/WEB-INF/users/profile.jsp
</body>
</html>
