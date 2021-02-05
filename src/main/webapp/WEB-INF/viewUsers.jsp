
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
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Id</th>
            <th>User Name</th>

        </tr>
        <c:forEach var="user" items="${sessionScope.allUsers}">
        <tr>
            <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.username}"/></td>
        </tr>
        </c:forEach>

        <jsp:include page="./partials/bootstrap.jsp"/>
</div>
</html>
