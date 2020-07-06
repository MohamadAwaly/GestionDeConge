<%--
  Created by IntelliJ IDEA.
  User: awaly
  Date: 29/04/2020
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Ajout de la biblioteque core --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion de Conge</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styleConnexion.css">
</head>
<body>
<c:import url="/resources/view/header.jsp"/>
<form method="post" action="login" class="formulaireLogin">
    <legend>BIENVENUE</legend>
    <p>Connexion</p>
    <input type="email" name="email" id="email" class="ChampFormulaire" placeholder="E-mail" for="email"/></br></br>
    <input type="password" name="pass" id="pass" class="ChampFormulaire" for="pass"/></br></br>
    <p>Mot de passe oublié ? </p>
    <input type="submit" id="boutonConnexion" value="Connexion">

</form>
</body>
<footer>
    <p>Copyright © 2020 Awaly Mohamad, Yves Jiwaii</br>
        Tous droits réservés.</p>
</footer>
</html>
