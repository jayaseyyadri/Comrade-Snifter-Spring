<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
<%--    admin--%>
    <c:when test="${sessionScope.isAdmin && sessionScope.isLoggedIn}">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-">
          <a class="navbar-brand" href="/home"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="Comrade Snifter" width="120px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="${param.link}"> <h1>${param.linkTitle}</h1><span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <form class="form-inline my-auto my-lg-0" action="/drinks" method="post">
                  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchBy">
                  <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Search</button>
                </form>
              </li>
            </ul>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <h1>Utilities</h1>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="/drinks/create"><h3></h3>Add Drink</a>
                  <a class="dropdown-item" href="#"><h3>View Favorites</h3></a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#"><h3>Edit Profile</h3></a>
                  <a class="dropdown-item" href="/users"><h3>Edit Users</h3></a>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/logout"><h1>Logout</h1></a>
              </li>
            </ul>
          </div>
        </nav>
    </c:when>
<%--    user--%>
    <c:when test="${isLoggedIn}">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <a class="navbar-brand" href="/home"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="Comrade Snifter" width="120px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent1">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="${param.link}"> <h1>${param.linkTitle}<span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <form class="form-inline my-auto my-lg-0" action="/drinks" method="post">
                  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchBy">
                  <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Search</button>
                </form>
              </li>
            </ul>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <h1>Utilities</h1>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                  <a class="dropdown-item" href="/drinks/create"><h3></h3>Add Drink</a>
                  <a class="dropdown-item" href="#"><h3>View Favorites</h3></a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#"><h3>Edit Profile</h3></a>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/logout"><h1>Logout</h1></a>
              </li>
            </ul>
          </div>
        </nav>
    </c:when>
<%--    visitor--%>
    <c:otherwise>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <a class="navbar-brand" href="/home"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="Comrade Snifter" width="120px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent2" aria-controls="navbarSupportedContent2" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent2">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="${param.link}"> <h1>${param.linkTitle}<span class="sr-only">(current)</span></a>
              </li>
            </ul>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a class="nav-link" href="/login"><h1>Login</h1></a>
              </li>
            </ul>
          </div>
        </nav>
    </c:otherwise>
</c:choose>
