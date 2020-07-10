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
    <c:import url="head.jsp"/>
    <title>Ajout d'une nouvelle personne</title>
</head>

<body>
<c:import url="header.jsp"/>
<c:if test="${ !empty erreur}"><p style="color: red;"><c:out value="${ erreur }"/></p></c:if>
<form method="post" action="ajoutpersonne">
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

<table style="width:100%" border="1px solid black">

    <tr>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Date de naissance</th>
        <th>Email</th>
        <th>Mot de Passe</th>
    </tr>
    <c:forEach var="personnes" items="${ personnes }">
        <tr>
            <td><c:out value="${ personnes.prenom } "/></td>
            <td><c:out value="${ personnes.nom } "/></td>
            <td><c:out value="${ personnes.dateDeNaissance } "/></td>
            <td><c:out value="${ personnes.email } "/></td>
            <td><c:out value="${ personnes.motDePasse }"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>