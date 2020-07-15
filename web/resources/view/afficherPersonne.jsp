<%--
  Created by IntelliJ IDEA.
  User: awaly
  Date: 15/07/2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lister Employe</title>
    <c:import url="head.jsp"/>
</head>
<body>
<c:import url="header.jsp"/>
<c:if test="${ !empty erreur}"><p style="color: red;"><c:out value="${ erreur }"/></p></c:if>
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
    <c:forEach var="personnes" items="${ personnes }">
        <tr>
            <td><c:out value="${ personnes.prenom } "/></td>
            <td><c:out value="${ personnes.nom } "/></td>
            <td><c:out value="${ personnes.dateDeNaissance } "/></td>
            <td><c:out value="${ personnes.email } "/></td>
            <td><c:out value="${ personnes.motDePasse }"/></td>
            <td><c:out value="${ personnes.fkAdresse }"/></td>
            <td><c:out value="${ personnes.fkRole }"/></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
