<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
<%--    admin--%>
    <c:when test="${sessionScope.isAdmin && sessionScope.isLoggedIn}">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-">
          <a class="navbar-brand" href="/drinks"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="Comrade Snifter" width="120px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <form class="form-inline my-auto my-lg-0" action="/drinks" method="post">
                  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchBy">
                  <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Search Drinks</button>
                </form>
              </li>
            </ul>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a class="nav-link" href="/profile"><h3>Profile</h3></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/logout"><h3>Logout</h3></a>
              </li>
            </ul>
          </div>
        </nav>
    </c:when>
<%--    user--%>
    <c:when test="${isLoggedIn}">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <a class="navbar-brand" href="/drinks"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="Comrade Snifter" width="120px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent1">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <form class="form-inline my-auto my-lg-0" action="/drinks" method="post">
                  <input class="form-control mr-sm-2" type="search" placeholder="Search Drinks" aria-label="Search" name="searchBy">
                  <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Search</button>
                </form>
              </li>
            </ul>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a class="nav-link" href="/profile"><h3>Profile</h3></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/logout"><h3>Logout</h3></a>
              </li>
            </ul>
          </div>
        </nav>
    </c:when>
<%--    visitor--%>
    <c:otherwise>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <a class="navbar-brand" href="/"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="Comrade Snifter" width="120px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent2" aria-controls="navbarSupportedContent2" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent2">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
        <a class="nav-link" href="${param.link}"> <h3>${param.linkTitle}</h3><span class="sr-only">(current)</span></a>
              </li>
            </ul>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a class="nav-link" href="${param.linkV}"><h3>${param.linkVisitor}</h3></a>
              </li>
            </ul>
          </div>
        </nav>
    </c:otherwise>
</c:choose>
