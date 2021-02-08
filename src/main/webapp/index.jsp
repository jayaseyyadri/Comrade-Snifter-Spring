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
        .pageInfo {
          margin: 15px 0 0 0;
          left: 0;
          bottom: 0;
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
        .frame:nth-child(1) {
            background-color: #ddc;
            border: solid 2vmin goldenrod;
            border-bottom-color: #dfae32;
            border-left-color: goldenrod;
            border-radius: 2px;
            border-right-color: goldenrod;
            border-top-color: #b18107;
            box-shadow: 0 0 5px 0 rgba(0, 0, 0, .25) inset, 0 5px 10px 5px rgba(0, 0, 0, .25);
            box-sizing: border-box;
            display: inline-block;
            padding: 2vmin;
            position: relative;
            text-align: center;
        }
        .frame:nth-child(2) {
            background-color: #ddc;
            border: solid 2vmin silver;
            border-bottom-color: #dfdede;
            border-left-color: silver;
            border-right-color: silver;
            border-top-color: #9c9c9c;
            border-radius: 2px;
            box-shadow: 0 0 5px 0 rgba(0, 0, 0, .25) inset, 0 5px 10px 5px rgba(0, 0, 0, .25);
            box-sizing: border-box;
            display: inline-block;
            padding: 2vmin;
            position: relative;
            text-align: center;
        }
        .frame:nth-child(3) {
            background-color: #ddc;
            border: solid 2vmin #a74e0d;
            border-bottom-color: #bf560a;
            border-left-color: #a74e0d;
            border-right-color: #a74e0d;
            border-top-color: #89400b;
            border-radius: 2px;
            box-shadow: 0 0 5px 0 rgba(0, 0, 0, .25) inset, 0 5px 10px 5px rgba(0, 0, 0, .25);
            box-sizing: border-box;
            display: inline-block;
            padding: 2vmin;
            position: relative;
            text-align: center;
        }
        .topImage {
            border:solid 2px;
            border-bottom-color:#ffe;
            border-left-color:#eed;
            border-right-color:#eed;
            border-top-color:#ccb;
            max-height:100%;
            max-width:100%;
        }

        <%@include file="resources/css/index.css"%>

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

    <div class="pageInfo">

        <div class="container-fluid" style="display: flex; justify-content: space-around; flex-direction: column">
            <div class="homePageAbout" id="howTo" style="margin: 5px auto 5px 0; display: flex">
                <div>
                    <img src="${pageContext.request.contextPath}/resources/img/pro.jpg" alt="Pro Mixer" height="200px">
                </div>
                <div class="descriptions" style="margin: auto">
                    <h3>With all the info you would ever need to make these drinks including links to how to videos, using our site you will soon be mixing drinks like a pro!</h3>
                </div>
            </div>
            <div class="homePageAbout" id="shareDrinksToo" style="margin: 5px 0; display: flex">
                <div class="descriptions" style="margin: auto">
                    <h3>Sharing your favorite drinks has never been easier. Using our site, you will find it to be the number one stop for finding your new favorite drink!</h3>
                </div>
                <div>
                    <img src="${pageContext.request.contextPath}/resources/img/friends.jpg" alt="Share With Friends" height="200px">
                </div>
            </div>
           </div>
    </div>

    <jsp:include page="WEB-INF/partials/bootstrap.jsp"/>
</body>
</html>
