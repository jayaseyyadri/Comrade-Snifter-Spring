<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin: 15px auto; width: 35%">
    <form action="/drinks" method="Post" id="selectForm">
        <div class="form-group">
            <label class="form-label">Search by Category</label>
                <select class="selectCategory form-select form-control" name="selectValue">
                    <option disabled value="" selected>--Please choose an option--</option>
                    <option value="byVotes">By Rating</option>
                    <option value="Brandy">Brandy</option>
                    <option value="Bourbon">Bourbon</option>
                    <option value="Whiskey">Whiskey</option>
                    <option value="Fruity">Fruity</option>
                    <option value="Desert">Desert</option>
                </select>
        </div>
        <button type="submit" class="btn-danger btn btn-block">Submit</button>
    </form>
</div>