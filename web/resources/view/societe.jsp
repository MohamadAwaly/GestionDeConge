<%--
  Created by IntelliJ IDEA.
  User: awaly
  Date: 27/07/2020
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lister Societe</title>
    <c:import url="head.jsp"/>
</head>
<body>
<c:import url="header.jsp"/>


<c:if test="${ !empty erreur}"><p style="color: red;"><c:out value="${ erreur }"/></p></c:if>

<table style="width:100%" border="1px solid black">

    <tr>
        <th>Societe</th>
        <th>Téléphone</th>
        <th>Numéro TVA</th>
        <th>Email</th>
        <th>Adresse</th>
    </tr>
    <c:forEach var="societe" items="${ societe }">
        <tr>
            <td><c:out value="${ societe.nom } "/></td>
            <td><c:out value="${ societe.tel } "/></td>
            <td><c:out value="${ societe.ntva } "/></td>
            <td><c:out value="${ societe.email } "/></td>
            <td><c:out value="${ societe.fkAdresse }"/></td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
