<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Comrade Snifter!" />
    </jsp:include>
    <style>
        .errorMessage{
            color: #dc3444;
        }
        .footer {
          margin: 15px 0 0 0;
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
        .jumbotron {
            background: linear-gradient(to top, rgba(0,0,0,0.5) 100%,rgba(0,0,0,0.5) 100%), url("${pageContext.request.contextPath}/resources/img/fizzy2.jpg");
            background-repeat: no-repeat;
            background-size: 100%;
            height: 30vh;
            color: white;
        }
        body {
            background: #cccecf;
        }
        body::-webkit-scrollbar-thumb{
            background: #141719;
        }
        body::-webkit-scrollbar-track{
            background: #343a40;
        }
        body::-webkit-scrollbar{
            width: .15rem;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp">
    <jsp:param name="link" value="/drinks"/>
    <jsp:param name="linkTitle" value="View Drinks"/>
    <jsp:param name="profileOne" value="/profile"/>
    <jsp:param name="profileTwo" value="Profile"/>
    <jsp:param name="linkV" value="/login"/>
    <jsp:param name="linkVisitor" value="Login"/>
</jsp:include>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">Comrade Snifter</h1>
    <p class="lead text-center"><strong>com•rade</strong> - a companion who shares one's activities</p>
    <p class="lead text-right"><strong>snif•ter</strong> - <small>(INFORMAL)</small> a small quantity of an alcoholic drink</p>
  </div>
</div>


    <div class="container center" style="margin-top: 15px">
        <h1 class="text-center">Current Top Rated Drinks!</h1>
        <jsp:include page="/WEB-INF/partials/top3.jsp" />
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
