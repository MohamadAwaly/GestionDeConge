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
    <link rel="stylesheet" type="text/css" href="resources/css/styleConnexion.css">
</head>
<body>
<c:import url="header.jsp"/>
<%-- Affichage de la chaîne "message" transmise par la servlet --%>
<%--<c:if test="${ validation }" var="varValidation" scope="session">
  </br>
  <c:out value="validation: ${ validation }"/>
  <%-- Puis affichage des données enregistrées dans le bean "Utilisateur" transmis par la servlet --%>
<%--    </br>
  <c:out value="Email : ${ user.email }"/>
  </br>
  <c:out value="mot de passe : ${ user.motDePasse }"/>
  </br>
  <c:out value="Calendar: ${ calendar }"/>
</c:if>

<c:out value="${ message }"></c:out>--%>
<c:forEach var="calendar" items="${ calendar }">
    <tr>
        <c:out value="${ calendar }" />
    </tr>

</c:forEach>



</body>
</html>
