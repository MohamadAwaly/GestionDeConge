<%--
  Created by IntelliJ IDEA.
  User: awaly
  Date: 29/04/2020
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion de Conge</title>
    <link rel="stylesheet" type="text/css" href="../style/styleConnexion.css">
</head>
<body>

<header>
    <h1>Gestion de congé</h1>
</header>

<form method="post" action="accueil" class="formulaireLogin">


    <legend>BIENVENUE</legend>
    <p>Connexion</p>
    <input type="email" name="email" id="email" class="ChampFormulaire" placeholder="E-mail"/></br></br>
    <input type="password" name="pass" id="pass" class="ChampFormulaire"/></br></br>
    <p>Mot de passe oublié ? </p>
    <input type="submit" id="boutonConnexion" value="Connexion">

</form>
</body>
<footer>
    <p>Copyright © 2020 Awaly Mohamad, Yves Jiwaii</br>
        Tous droits réservés.</p>
</footer>
</html>
