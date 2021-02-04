<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
<%--    admin--%>
    <c:when test="${sessionScope.isAdmin && sessionScope.isLoggedIn}">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <ul class="nav navbar-nav navbar-left">
                        <li><a class="navbar-brand" href="/drinks">Drink List</a></li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout">Logout</a></li>
                    <li><a href="/users">See Users</a></li>
                </ul>
            </div>
        </nav>
    </c:when>
<%--    user--%>
    <c:when test="${isLoggedIn}">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <ul class="nav navbar-nav navbar-left">
                        <li><a class="navbar-brand" href="/drinks">Drink List</a></li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout">Logout</a></li>
                </ul>
            </div>
        </nav>
    </c:when>
<%--    visitor--%>
    <c:otherwise>
          <nav class="navbar navbar-default">
              <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                      <ul class="nav navbar-nav navbar-left">
                          <li><a class="navbar-brand" href="/drinks">Drink List</a></li>
                      </ul>
                  </div>
                  <ul class="nav navbar-nav navbar-right">
                      <li><a href="/login">Login</a></li>
                  </ul>
              </div>
            </nav>
    </c:otherwise>
</c:choose>
