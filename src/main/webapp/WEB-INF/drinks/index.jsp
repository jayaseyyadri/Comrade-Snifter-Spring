<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Drinks" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp">
    <jsp:param name="linkV" value="/login"/>
    <jsp:param name="linkVisitor" value="Login"/>
    <jsp:param name="profileOne" value="/profile"/>
    <jsp:param name="profileTwo" value="Profile"/>
</jsp:include>

<c:if test="${sessionScope.user == null}">

    <div class="container-fluid" style="display: flex; justify-content: center">

        <img src="${pageContext.request.contextPath}/resources/img/comrade.png" alt="Comrade">


                <div class="card text-white bg-secondary border-warning mt-4" style="width: 18rem;">
                    <div class="card-header">
                        <h5 class="card-title text-center">
                            Here are all the drinks listed on the site!
                        </h5>
                    </div>
                    <div class="card-body">
                        <p class="card-text">In order to view ingredients and instructions, simply login or create an account.</p>
                    </div>
                    <div class="card-footer" style="display: flex;justify-content: space-between; align-items: center">
                        <form action="/register" method="get">
                            <button type="submit" class="btn btn-danger">Register</button>
                        </form>
                        <form action="/login" method="get">
                            <button type="submit" class="btn btn-danger">Login</button>
                        </form>
                    </div>
                </div>



        <img src="${pageContext.request.contextPath}/resources/img/Snifter.png" alt="Snifter">

    </div>

</c:if>
<c:if test="${sessionScope.user != null}">
    <jsp:include page="../partials/select-category.jsp"/>
</c:if>


<jsp:include page="/WEB-INF/partials/drink-cards.jsp"/>


<jsp:include page="../partials/bootstrap.jsp"/>
</body>
</html>
