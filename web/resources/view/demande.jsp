<%--
  Created by IntelliJ IDEA.
  User: Gaming
  Date: 03/08/2020
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="head.jsp"/>
    <title>Nouvelle Demande</title>
</head>
<body>
<c:import url="header.jsp"/>

<p style="text-align: center; color: red; font-weight: bold"><c:out value="${message}"/></p>

<form method="post" action="demande" class="formulairePersonne">
    <fieldset>
        <legend> ******* Nouvel Demande *******</legend>

        <label for="dateDebut" class="labelAjoutPers">Date de debut : </label>
        <input type="date" name="dateDebut" id="dateDebut" class="ChampFormulaireajoutPersonne" required>

        <label for="dateFin" class="labelAjoutPers" required>Date de fin : </label>
        <input type="date" name="dateFin" id="dateFin" class="ChampFormulaireajoutPersonne" required>


        <input type="submit" class="boutonAjoutPersonne"/>
    </fieldset>
</form>

</body>
</html>
