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

<form method="post" action="personnes" class="pdfPersonne">
    <button type="submit">Enregistre PDF</button>
</form>


<c:if test="${ !empty erreur}"><p style="color: red;"><c:out value="${ erreur }"/></p></c:if>

<table style="width:100%" border="1px solid black">

    <tr>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Email</th>
        <th>Adresse rue</th>
        <th>Numéro</th>
        <th>Ville</th>
        <th>Role</th>
    </tr>
    <c:forEach var="adresse" items="${adresse}">
        <tr>
            <td><c:out value="${ adresse[0] } "/></td>
            <td><c:out value="${ adresse[1] } "/></td>
            <td><c:out value="${ adresse[2] } "/></td>
            <td><c:out value="${ adresse[3] } "/></td>
            <td><c:out value="${ adresse[4] }"/></td>
            <td><c:out value="${ adresse[5] }"/></td>
            <td><c:out value="${ adresse[6] }"/></td>

        </tr>
    </c:forEach>
</table>


</body>
</html>
