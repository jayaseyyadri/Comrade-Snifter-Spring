<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Comrade Snifter" />
    </jsp:include>
    <script src="https://kit.fontawesome.com/36f035c426.js" crossorigin="anonymous"></script>
    <style>
        .voteSection{
            display: flex;
            justify-content: space-around;
            height: 30px;
        }
        .upVote{
            background-color: #0707c6;
            color: aliceblue;
        }
        .downVote{
            background-color: #dc3444;
        }
        .vote{
            width: 50%;
            height: 100%;
            text-align: center;
        }
        .voteForm{
            margin: 0;
            height: 100%;
        }
        .thumbButton{
            width: 100%;
            height: 100%;
        }
        body {
            background: #cccecf;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp">
    <jsp:param name="profileOne" value="/profile"/>
    <jsp:param name="profileTwo" value="Profile"/>
</jsp:include>

<jsp:include page="/WEB-INF/partials/creator-profile-card.jsp" />

<div class="container">
    <jsp:include page="/WEB-INF/partials/vote-card.jsp"/>
</div>

<jsp:include page="../partials/bootstrap.jsp"/>


</body>
</html>