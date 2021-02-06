
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="seeUsers" value="Viewing Users"/>
    </jsp:include>

</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp">
    <jsp:param name="profileOne" value="/profile"/>
    <jsp:param name="profileTwo" value="Profile"/>
</jsp:include>
</body>
    <div>

        <c:forEach var="admin" items="${sessionScope.allAdmins}">

            <div class="card">
                <div class="card-body d-flex justify-content-around">
                    <h5 class="card-title">Id # <c:out value="${admin.id}"/></h5>
                    <p class="card-text"><c:out value="${admin.username}"/></p>
                    <p>Admin</p>
                </div>
            </div>

        </c:forEach>

        <c:forEach var="user" items="${sessionScope.allUsers}">

            <div class="card">
                <div class="card-body d-flex justify-content-around">
                    <h5 class="card-title">Id # <c:out value="${user.id}"/></h5>
                    <p class="card-text"><c:out value="${user.username}"/></p>
                    <form action="/users" method="POST">
                        <input type="hidden" name="idToDelete" value="${user.id}"/>
                        <button type="submit" class="btn btn-danger">Delete User</button>
                    </form>
                </div>
            </div>

        </c:forEach>

    </div>

    <jsp:include page="./partials/bootstrap.jsp"/>
</html>
