<%--
  Created by IntelliJ IDEA.
  User: Gaming
  Date: 04/07/2020
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Test</title>
</head>
<body>
<c:import url="header.jsp"/>
<form method="post" action="test">
    <p>
        <label for="nom">Nom : </label>
        <input type="text" name="nom" id="nom"/>
    </p>
    <p>
        <label for="prenom">Prénom : </label>
        <input type="text" name="prenom" id="prenom"/>
    </p>
    <p>
        <label for="dateDeNaissance">Date de Naissance : </label>
        <input type="date" name="dateDeNaissance" id="dateDeNaissance">
    </p>
        <label for="email">Email : </label>
        <input type="email" name="email" id="email">
    <p>
        <label for="motDePasse">Mot de passe : </label>
        <input type="text" name="motDePasse" id="motDePasse">
    </p>
    <p>
        <label for="role">Role : </label>
        <input type="number" name="role" id="role">
    </p>
    <p>
        <label for="adresse">Adresse : </label>
        <input type="number" name="adresse" id="adresse">
    </p>

    <input type="submit"/>
</form>

<ul>
    <c:forEach var="personnes" items="${ personnes }">
        <li>
            <c:out value="${ personnes.prenom } "/>
            <c:out value="${ personnes.nom } "/>
            <c:out value="${ personnes.dateDeNaissance } "/>
            <c:out value="${ personnes.email } "/>
            <c:out value="${ personnes.motDePasse }"/>
        </li>
    </c:forEach>
</ul>
</body>
</html>