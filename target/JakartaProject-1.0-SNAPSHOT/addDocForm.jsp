<%--
  Created by IntelliJ IDEA.
  User: Pocky
  Date: 3/1/2021
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajoutez un Document</title>
</head>
<body>
<form method="post">
    <div class="container">
        <label for="titre">Titre</label>
        <input type="text" placeholder="Entrez le titre du document" name="titre" required>
    </div>

    <div class="container">
        <label for="auteur">Auteur</label>
        <input type="text" placeholder="Entrez l'auteur du document" name="auteur" required>
    </div>

</form>
</body>
</html>
