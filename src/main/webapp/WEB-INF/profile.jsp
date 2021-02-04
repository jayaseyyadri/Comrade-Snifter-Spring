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

    <jsp:include page="/WEB-INF/partials/profile-card.jsp" />

    <div class="container">

      <form action="/drinks/create" method="get">
          <input type="submit" class="btn" value="Create Drink Here!">
      </form>

    </div>

    <jsp:include page="/WEB-INF/partials/profile-card.jsp" />

    <div class="container">

        <h3 class="text-center">Here Are Your Drinks!</h3>
        <jsp:include page="partials/drink-cards.jsp"></jsp:include>
    </div>


        <jsp:include page="partials/drink-cards.jsp"></jsp:include>

<jsp:include page="./partials/bootstrap.jsp"/>
</body>
</html>
