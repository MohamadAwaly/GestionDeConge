<%--
  Created by IntelliJ IDEA.
  User: Gaming
  Date: 05/08/2020
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Liste de demande</title>
    <c:import url="head.jsp"/>
</head>

<body>
<c:import url="header.jsp"/>

<p class="titreListeemploye">Mes demandes</p>
<table border="1px solid black" class="ListSociete">

    <tr>
        <th>Numero de la Demande</th>
        <th>Date de la demande</th>
        <th>Date de la reponse</th>
        <th>Approuve</th>
        <th>Message employeur</th>
        <th>Date debut</th>
        <th>Date fin</th>
    </tr>
    <tr>

        <c:forEach var="mesdemandes" items="${mesdemandes}">

        <td><c:out value="${ mesdemandes[0] } "/></td>
        <td><c:out value="${ mesdemandes[4] } "/></td>
        <td><c:out value="${ mesdemandes[5] } "/></td>
        <td><c:out value="${ mesdemandes[6] } "/></td>
        <td><c:out value="${ mesdemandes[7] } "/></td>
        <td><c:out value="${ mesdemandes[8] } "/></td>
        <td><c:out value="${ mesdemandes[9] } "/></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>