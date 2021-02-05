<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Comrade Snifter!" />
    </jsp:include>
    <style>
        .footer {
            margin: 15px 0;
          left: 0;
          bottom: 0;
          height: 40%;
          width: 100%;
          background-color: #343a40;
          color: white;
          text-align: center;
          display: flex;
          justify-content: center;
          align-items: center;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp">
    <jsp:param name="link" value="/drinks"/>
    <jsp:param name="linkTitle" value="View Drinks"/>
    <jsp:param name="linkV" value="/login"/>
    <jsp:param name="linkVisitor" value="Login"/>
</jsp:include>


    <div class="container" style="margin-top: 15px">
        <h1 class="text-center">Current Top Ranked Drinks!</h1>
    </div>


    <div class="container">
        <jsp:include page="/WEB-INF/partials/top3-drinks.jsp" />
    </div>

    <div class="footer">
        <div class="container-fluid" style="display: flex; justify-content: space-around">
            <div>
                <p>Learn how to mix drinks like a pro!</p>
                <img src="${pageContext.request.contextPath}/resources/img/pro.jpg" alt="Pro Mixer" height="200px">
            </div>
            <div>
                 <p>Share drinks with others too...</p>
                <img src="${pageContext.request.contextPath}/resources/img/friends.jpg" alt="Share With Friends" height="200px">
            </div>
           </div>
    </div>

    <jsp:include page="WEB-INF/partials/bootstrap.jsp"/>
</body>
</html>
