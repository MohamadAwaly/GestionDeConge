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
<p>Bienvenue <c:out value="${sessionScope.sessionUtilisateur.prenom}"/> <c:out value="${sessionScope.sessionUtilisateur.nom}"/> <c:out value="${sessionScope.sessionUtilisateur.idPersonne}"/>
</p>
<table border="1"  cellspacing="1" class="...">

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



<%-- Affichage de la chaîne "message" transmise par la servlet --%>
<%--<c:if test="${ validation }" var="varValidation" scope="session">
  </br>
  <c:out value="validation: ${ validation }"/>
  <%-- Puis affichage des données enregist  rées dans le bean "Utilisateur" transmis par la servlet --%>
<%--    </br>
  <c:out value="Email : ${ user.email }"/>
  </br>
  <c:out value="mot de passe : ${ user.motDePasse }"/>
  </br>
  <c:out value="Calendar: ${ calendar }"/>
</c:if>

<c:out value="${ message }"></c:out>--%>
<table border="1"  cellspacing="1" class="Calendar">
    <thead>
    <td>Lundi</td>
    <td>Mardi</td>
    <td>Mercredi</td>
    <td>Jeudi</td>
    <td>Vendredi</td>
    <td>Samedi</td>
    <td>Dimanche</td>
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
