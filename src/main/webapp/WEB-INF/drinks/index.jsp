<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Drinks" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 class="text-center">Here Are all the Drinks!</h1>

    <jsp:include page="/WEB-INF/partials/drink-cards.jsp"></jsp:include>
</div>

<jsp:include page="../partials/bootstrap.jsp"/>
</body>
</html>
