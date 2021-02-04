<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad" />
    </jsp:include>
    <script src="https://kit.fontawesome.com/36f035c426.js" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<jsp:include page="/WEB-INF/partials/creator-profile-card.jsp" />


<div class="container">
    <jsp:include page="/WEB-INF/partials/drink-cards.jsp"></jsp:include>
</div>

<div class="container">
    <form action="/drinks" method="get">
        <button type="submit">Go Back</button>
    </form>

</div>

<form action="/vote" method="POST">
    <input type="hidden" value="1" name="vote">
    <button type="submit"><i class="fas fa-thumbs-up"></i></button>
</form>

<form action="/vote" method="POST">
    <input type="hidden" value="0" name="vote">
    <button type="submit"><i class="fas fa-thumbs-down"></i></button>
</form>


</body>
</html>