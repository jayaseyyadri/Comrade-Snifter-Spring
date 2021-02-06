<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .errorMessage{
        color: #dc3444;
    }
    .profileInfo{
        height: 50%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    #mainCard{
        width: 55vw;
        max-width: 450px;
        display: flex;
        justify-content: center;
        flex-direction: column;
        height: 30vh;
        margin: auto;
    }
    #profileImage{
        height: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
        width: 50%;
        margin: auto;
    }
    #image{
        width: 100%;
        height: 100%;
    }
</style>


<div id="mainCard" class="border-warning">
    <div id="profileImage">
        <img src="${creatorImage}" alt="Creator's Profile Picture" id="image" />
    </div>
    <div class="profileInfo">
        <h1>Creator: ${creatorName}</h1>
    </div>
</div>