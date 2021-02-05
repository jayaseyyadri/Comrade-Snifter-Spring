<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit your Profile" />
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<form action="/editProfile" method="POST">
    <div class="container">
        <label for="editUsername">Edit Username
            <input type="text" name="editUsername" id="editUsername"></label>
        </label>
        <c:if test="${sessionScope.UsernameExists}">
         <small class ="errorMessage">Username already exists ! Please select another username</small>
        </c:if>
        <label for="editPassword">Edit Password
            <input type="text" name="editPassword" id="editPassword"></label>
        </label>
        <label for="editEmailAddress">Edit Email Address
            <input type="text" name="editEmailAddress" id="editEmailAddress"></label>
        </label>
    <button type="submit" class="btn-btn-block btn-primary">Update Information </button>
</div>
</form>

<jsp:include page="./partials/bootstrap.jsp"/>
</body>
</html>