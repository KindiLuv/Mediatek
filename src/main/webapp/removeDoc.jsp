<%--
  Created by IntelliJ IDEA.
  User: Pocky
  Date: 3/1/2021
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Retirez des documents</title>
</head>
<body>
<a href="AddForm.jsp">Retour au Menu</a>
<div class="container">
    <label>Categorie</label>
    <form method="get" action="remove-file-servlet">
        <div class="container">
            <label>Categories:</label>
            <select name="docCat">
                <option value="1">Livre</option>
                <option value="2">DVD</option>
                <option value="3">CD</option>
            </select>
        </div>
        <button type="submit">Choisir categorie</button>
    </form>

        <form method="post" action="remove-file-servlet">
        <div class="container">
            <label for="idToDel">Id a supprimer:</label>
            <input type="text" placeholder="Entrez l'id a supprimer'" name="idToDel">
        </div>
            <button type="submit">Supprimer le fichier</button>
        </form>
    </form>




</div>
</body>
</html>
