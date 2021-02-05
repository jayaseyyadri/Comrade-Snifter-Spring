<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #selectForm{
        display: flex;
        flex-direction: column;
    }
</style>

<div class="container-fluid text-center">
    <form action="/drinks" method="Post" id="selectForm">
        <label>
            Search by Category
            <select class="selectCategory" name="selectValue">
                <option disabled value="" selected>--Please choose an option--</option>
                <option value="Brandy">Brandy</option>
                <option value="Bourbon">Bourbon</option>
                <option value="Whiskey">Whiskey</option>
                <option value="Fruity">Fruity</option>
                <option value="Desert">Desert</option>
            </select>
        </label>
        <button type="submit">Submit</button>
    </form>
</div>