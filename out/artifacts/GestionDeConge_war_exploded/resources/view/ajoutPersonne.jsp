<%--
  Created by IntelliJ IDEA.
  User: Gaming
  Date: 04/07/2020
  Time: 15:41
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
<form method="post" action="ajoutpersonne" class="formulairePersonne">
    <p>
        <label for="nom" class="labelAjoutPers">Nom : </label>
        <input type="text" name="nom" id="nom" class="ChampFormulaireajoutPersonne"/>

        <label for="prenom" class="labelAjoutPers">Prénom : </label>
        <input type="text" name="prenom" id="prenom" class="ChampFormulaireajoutPersonne"/>
    </p>
    <p>
        <label for="dateDeNaissance" class="labelAjoutPers">Date de Naissance : </label>
        <input type="date" name="dateDeNaissance" id="dateDeNaissance" class="ChampFormulaireajoutPersonne" required/>

        <label for="email" class="labelAjoutPers">Email : </label>
        <input type="email" name="email" id="email" class="ChampFormulaireajoutPersonne" required/>
    <p>
        <label for="motDePasse" class="labelAjoutPers">Mot de passe : </label>
        <input type="text" name="motDePasse" id="motDePasse" class="ChampFormulaireajoutPersonne" required/>

        <label for="role" class="labelAjoutPers">Role : </label>
        <input type="number" name="role" id="role" class="ChampFormulaireajoutPersonne" >
    </p>
    <p>
        <label for="role" class="labelAjoutPers">Adresse : </label>
        <SELECT id="selectAdresse" name="selectAdresse" size="1" class="ChampFormulaireajoutPersonne" required>

            <c:forEach var="adresses" items="${ adresses }">
            <OPTION value="${ adresses.idAdresse }">
                    <c:out value="${ adresses.nomRue } "/>
            </c:forEach>
        </SELECT>
    </p>
    <input type="submit" class="boutonAjoutPersonne"/>
</form>

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

    <c:forEach var="adresse" items="${ adresse }">
        <c:out value="${ adresse.nomRue }"/>
    </c:forEach>
</table>


</body>
</html>