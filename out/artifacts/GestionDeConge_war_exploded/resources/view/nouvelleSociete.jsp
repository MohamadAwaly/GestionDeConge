<%--
  Created by IntelliJ IDEA.
  User: awaly
  Date: 16/07/2020
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="head.jsp"/>
    <title>Ajout d'une nouvelle societé</title>
</head>

<body>
<c:import url="header.jsp"/>
<c:if test="${ !empty erreur}"><p style="color: red;"><c:out value="${ erreur }"/></p></c:if>
<form method="post" action="nouvellesociete">
    <fieldset>
        <legend> ******* Nouvel Societe *******</legend>
        <p>
            <label for="nom" class="labelAjoutPers">Nom de la societe : </label>
            <input type="text" name="nom" id="nom" class="ChampFormulaireajoutPersonne" required />

            <label for="tel" class="labelAjoutPers">Téléphone : </label>
            <input type="text" name="tel" id="tel" class="ChampFormulaireajoutPersonne" required />


            <label for="ntva" class="labelAjoutPers">numéro de TVA : </label>
            <input type="number" name="ntva" id="ntva" class="ChampFormulaireajoutPersonne" required />
        </p>
        <p>
            <label for="email" class="labelAjoutPers">Email : </label>
            <input type="email" name="email" id="email" class="ChampFormulaireajoutPersonne" required />
        </p>

    </fieldset>
    <input type="submit"/>

</form>
</body>
</html>
