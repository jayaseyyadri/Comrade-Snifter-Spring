<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card" style="width: 500px">
    <img src="${sessionScope.user.image}" alt="User Profile Picture" class="card-img-top"/>
    <div class="card-body">
        <h1 class="card-text">${sessionScope.user.username}</h1>
    </div>
</div>