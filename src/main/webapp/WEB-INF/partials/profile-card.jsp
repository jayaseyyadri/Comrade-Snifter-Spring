<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="card text-white bg-secondary border-warning mt-4 mb-4" style="width: 18rem;">
        <img class="card-img-top" src="<c:out value="${sessionScope.user.image}"/>" alt="drink">
        <div class="card-body">
            <h5 class="card-text">
                ${sessionScope.user.username}
            </h5>
        </div>
    </div>
