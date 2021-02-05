<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #selectForm{
        display: flex;
        flex-direction: column;
    }
    #selectSubmit{
        width: fit-content;
        align-self: center;
    }
</style>

<div class="container text-center">
    <form action="/drinks" method="Post" id="selectForm">
        <div class="form-group">
            <label class="form-label">
                Search by Category
                <select class="selectCategory form-select" name="selectValue">
                    <option disabled value="" selected>--Please choose an option--</option>
                    <option value="Brandy">Brandy</option>
                    <option value="Bourbon">Bourbon</option>
                    <option value="Whiskey">Whiskey</option>
                    <option value="Fruity">Fruity</option>
                    <option value="Desert">Desert</option>
                </select>
            </label>
        </div>
        <button type="submit" class="btn-danger btn" id="selectSubmit">Submit</button>
    </form>
</div>