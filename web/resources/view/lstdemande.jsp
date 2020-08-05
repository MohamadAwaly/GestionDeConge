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


<form method="post" action="reponseDemande" class="formulairePersonne">


    <table style="width:100%" border="1px solid black">

        <tr>
            <th>Numéro de la demande</th>
            <th>Nom</th>
            <th>Date Demande</th>
            <th>Date Debut</th>
            <th>Date Fin</th>
            <th>selection</th>

        </tr>
        <c:forEach var="demandeEnCours" items="${demandeEnCours}">
            <tr>
                <td><c:out value="${ demandeEnCours[0] } "/></td>
                <td><c:out value="${ demandeEnCours[1] } "/></td>
                <td><c:out value="${ demandeEnCours[2] } "/></td>
                <td><c:out value="${ demandeEnCours[3] } "/></td>
                <td><c:out value="${ demandeEnCours[4] } "/></td>
                <td><input type="radio" id="reponse" name="reponse" value="${ demandeEnCours[0] }"></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" class="button"/>

</form>
</body>
</html>