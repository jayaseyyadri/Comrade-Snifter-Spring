<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .profileInfo{
        height: 50%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        background-color: #b6babe;
    }
    #mainCard{
        border: 2px solid black;
        border-radius: 5px;
        width: 35vw;
        max-width: 450px;
        display: flex;
        justify-content: center;
        flex-direction: column;
        height: 45vh;
        float: right;
        margin-right: 15px;
    }
    #profileImage{
        height: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
        border: 2px solid black;
        border-radius: 110px;
        width: 50%;
        margin: auto;
    }
    #image{
        width: 100%;
        height: 100%;
    }
</style>


<div id="mainCard">
    <div id="profileImage">
        <img src="${sessionScope.user.image}" alt="User Profile Picture" id="image" />
    </div>
    <div class="profileInfo">
        <h1>${sessionScope.user.username}</h1>
        <p>Your Liked Drinks Here</p>
    </div>
</div>