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
    <title>Ajout d'une nouvelle personne</title>
</head>

<body>
<c:import url="header.jsp"/>
<c:if test="${ !empty erreur}"><p style="color: red;"><c:out value="${ erreur }"/></p></c:if>
<form method="post" action="nouvellepersonne" class="formulairePersonne">
    <fieldset>
        <legend> ******* Nouvel employé *******</legend>
        <p>
            <label for="nom" class="labelAjoutPers">Nom : </label>
            <input type="text" name="nom" id="nom" class="ChampFormulaireajoutPersonne"/>

            <label for="prenom" class="labelAjoutPers">Prénom : </label>
            <input type="text" name="prenom" id="prenom" class="ChampFormulaireajoutPersonne"/>


            <label for="dateDeNaissance" class="labelAjoutPers">Date de Naissance : </label>
            <input type="date" name="dateDeNaissance" id="dateDeNaissance" class="ChampFormulaireajoutPersonne">
        </p>
        <p>
            <label for="email" class="labelAjoutPers">Email : </label>
            <input type="email" name="email" id="email" class="ChampFormulaireajoutPersonne">

            <label for="motDePasse" class="labelAjoutPers">Mot de passe : </label>
            <input type="text" name="motDePasse" id="motDePasse" class="ChampFormulaireajoutPersonne">
        </p>
        <p>
            <!-- <input type="number" name="role" id="role" class="ChampFormulaireajoutPersonne"> -->
            <label for="selectrole" class="labelAjoutPers">Role : </label>
            <SELECT id="selectrole" name="selectrole" size="1" class="ChampFormulaireajoutPersonne">
                <c:forEach var="role" items="${ role }">
                <OPTION value="${ role.idRole }">
                        <c:out value="${ role.typeRole } "/>
                    </c:forEach>
            </SELECT>

            <label for="selectAdresse" class="labelAjoutPers">Adresse : </label>
            <SELECT id="selectAdresse" name="selectAdresse" size="1" class="ChampFormulaireajoutPersonne">
                <c:forEach var="adresses" items="${ adresses }">
                <OPTION value="${ adresses.idAdresse }">
                        <c:out value="${ adresses.nomRue } "/>
                    </c:forEach>
            </SELECT>
        </p>


    </fieldset>
    <input type="submit" class="boutonAjoutPersonne"/>


</form>
</body>
</html>
