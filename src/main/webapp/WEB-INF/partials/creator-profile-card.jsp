<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="col col-md-6 col-lg-4 d-flex" style="display: flex; justify-content: center">
    <div class="card text-white bg-secondary border-warning mt-4" style="width: 18rem; height: fit-content">
        <div class="card-header">
            <h5 class="card-title text-center">
                Creator: ${creatorName}
            </h5>
        </div>
        <img class="card-img-top" src="<c:out value="${creatorImage}"/>" alt="drink">
    </div>
</div>
