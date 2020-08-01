<%--
  Created by IntelliJ IDEA.
  User: Gaming
  Date: 02/05/2020
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/styleheader.css">
    <link rel="stylesheet" type="text/css" href="resources/css/styleSession.css">
</head>
<nav>
    <div class="table">
        <ul>
            <li class="menu-html"><a href="personnes">Afficher Employer</a></li>
            <li class="menu-css"><a href="nouvellepersonne">Nouvel Employé</a></li>
            <li class="menu-javascript"><a href="societes">Afficher Societe</a></li>
            <li class="menu-contact"><a href="nouvellesociete">Nouvelle Societe</a></li>
        </ul>
    </div>
</nav>
<header>
    <h1>Gestion de congé</h1>
    <div class="nomSession">
        <p><c:out value="${sessionScope.sessionUtilisateur.prenom}"/> <c:out value="${sessionScope.sessionUtilisateur.nom}"/>
    </div>

</header>
<body>

</body>