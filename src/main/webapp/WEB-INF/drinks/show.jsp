<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <jsp:include page="/WEB-INF/partials/drink-cards.jsp"></jsp:include>
</div>

<div class="container">
    <form action="/drinks" method="get">
        <button type="submit">Go Back</button>
    </form>

</div>

<jsp:include page="../partials/bootstrap.jsp"/>
</body>
</html>