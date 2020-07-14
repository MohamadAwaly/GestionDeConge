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
<table style="width:100%" border="1px solid black">
    <tr>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Date de naissance</th>
        <th>Email</th>
        <th>Mot de Passe</th>
        <th>Adresse</th>
        <th>Role</th>
    </tr>
    <c:forEach var="personnestest" items="${ personnestest }">
        <tr>
            <td><c:out value="${ personnestest.prenom } "/></td>
            <td><c:out value="${ personnestest.nom } "/></td>
            <td><c:out value="${ personnestest.dateDeNaissance } "/></td>
            <td><c:out value="${ personnestest.email } "/></td>
            <td><c:out value="${ personnestest.motDePasse }"/></td>
            <td><c:out value="${ personnestest.fkAdresse }"/></td>
            <td><c:out value="${ personnestest.fkRole }"/></td>
        </tr>
    </c:forEach>
</table>

</html>