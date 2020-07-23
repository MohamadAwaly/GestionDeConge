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
    <c:import url="/resources/view/head.jsp"/>
</head>
<body>

<form method="POST" action="seconnecter" class="formulaireLogin">
    <legend>BIENVENUE</legend>
    <p>Connexion</p>


    <input type="email" name="email" id="email" class="ChampFormulaire" placeholder="E-mail" for="email"
           value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60"/></br></br>
    <span class="erreur">${form.erreurs['email']}</span>

    <input type="password" name="motdepasse" id="pass" class="ChampFormulaire" for="motdepasse"/></br></br>
    <span class="erreur">${form.erreurs['motdepasse']}</span>


    <input type="submit" id="boutonConnexion" value="Connexion">
    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

    <%-- Vérification de la présence d'un objet utilisateur en session --%>
    <c:if test="${!empty sessionScope.sessionUtilisateur}">
        <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
        <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
    </c:if>

</form>
</body>
<footer>
    <p>Copyright © 2020 Awaly Mohamad, Yves Jiwaii</br>
        Tous droits réservés.</p>
</footer>
</html>
