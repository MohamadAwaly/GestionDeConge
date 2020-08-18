<%--
  Created by IntelliJ IDEA.
  User: Gaming
  Date: 02/05/2020
  Time: 15:11
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
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<c:import url="header.jsp"/>
<p id="bienvenu">Bienvenue <c:out value="${sessionScope.sessionUtilisateur.prenom}"/> <c:out
        value="${sessionScope.sessionUtilisateur.nom}"/>
</p>
<table border="1" cellspacing="1" class="tableaudebord">

    <tr>
        <th>Dernier date de conge</th>
        <th>Nombre des jours pris</th>
        <th>Date debut de conge</th>
        <th>Nombre des jours autorise</th>
        <th>Nombre des jours restant</th>
        <th>Date debut du contrat</th>
        <th>Date fin du contrat</th>


    </tr>
    <c:forEach var="jourdecongerestant" items="${jourdecongerestant}">
        <tr>
            <td><c:out value="${ jourdecongerestant[0] }"/></td>
            <td><c:out value="${ jourdecongerestant[1] }"/></td>
            <td><c:out value="${ jourdecongerestant[2] }"/></td>
            <td><c:out value="${ jourdecongerestant[3] }"/></td>
            <td><c:out value="${ jourdecongerestant[4] }"/></td>
            <td><c:out value="${ jourdecongerestant[5] }"/></td>
            <td><c:out value="${ jourdecongerestant[6] }"/></td>

        </tr>
    </c:forEach>
</table>

<table border="1" cellspacing="1" class="Calendar">
    <thead class="" style="background: lightblue;
                    border-color: white;">
    <th>Lundi</th>
    <th>Mardi</th>
    <th>Mercredi</th>
    <th>Jeudi</th>
    <th>Vendredi</th>
    <th>Samedi</th>
    <th>Dimanche</th>
    </thead>
    <c:forEach var="calendar" items="${ calendar }">

        <tr>
            <c:forEach var="item" items="${calendar}">
                <td>
                    <c:out value="${item}"></c:out>
                </td>

            </c:forEach>
        </tr>


    </c:forEach>
</table>


</body>
</html>
