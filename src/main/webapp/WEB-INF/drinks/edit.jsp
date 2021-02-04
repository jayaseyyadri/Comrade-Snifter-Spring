<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit page</title>
</head>
<body>

<form method="POST" action="/edit">
    <div class="form-group">
        <label for="newName">Drink Name</label>
        <input id="newName" name="newName" class="form-control" type="text">
    </div>
    <div class="form-group">
        <label for="newInstructions">Instructions</label>
        <textarea id="newInstructions" name="newInstructions" class="form-control">Instructions here</textarea>
    </div>
    <div class="form-group">
        <label for="newIngredients">Ingredients</label>
        <textarea id="newIngredients" name="newIngredients" class="form-control">Ingredients here</textarea>
    </div>
    <div class="form-group">
        <label for="newImage">Image URL</label>
        <textarea id="newImage" name="newImage" class="form-control">Image here</textarea>
    </div>
    <input type="submit" class="btn btn-block btn-primary">
</form>

</body>
</html>