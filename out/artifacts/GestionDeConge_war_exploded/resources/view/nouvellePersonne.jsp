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


            <label for="nom" class="labelAjoutPers">Nom <span class="etoile">*</span> : </label>
            <input type="text" name="nom" id="nom" class="ChampFormulaireajoutPersonne" required/>

            <label for="prenom" class="labelAjoutPers">Prénom <span class="etoile">*</span> : </label>
            <input type="text" name="prenom" id="prenom" class="ChampFormulaireajoutPersonne" required/>

        </p>
            <label for="dateDeNaissance" class="labelAjoutPers">Date de Naissance <span class="etoile">*</span> :
            </label>
            <input type="date" name="dateDeNaissance" id="dateDeNaissance" class="ChampFormulaireajoutPersonne"
                   required/>

        <p>
            <label for="email" class="labelAjoutPers">Email <span class="etoile">*</span> : </label>
            <input type="email" name="email" id="email" class="ChampFormulaireajoutPersonne" required/>

            <label for="motDePasse" class="labelAjoutPers">Mot de passe <span class="etoile">*</span> : </label>
            <input type="text" name="motDePasse" id="motDePasse" class="ChampFormulaireajoutPersonne" required/>
        </p>
        <p>
            <label for="selectrole" class="labelAjoutPers">Role <span class="etoile">*</span> : </label>
            <SELECT id="selectrole" name="selectrole" size="1" class="ChampFormulaireajoutPersonne">
                <c:forEach var="role" items="${ role }">
                <OPTION value="${ role.idRole }">
                        <c:out value="${ role.typeRole } "/>
                    </c:forEach>
            </SELECT>

            <label for="selectAdresse" class="labelAjoutPers">Adresse <span class="etoile">*</span> : </label>
            <SELECT id="selectAdresse" name="selectAdresse" size="1" class="ChampFormulaireajoutPersonne">
                <c:forEach var="adresses" items="${ adresses }">
                <OPTION value="${ adresses.idAdresse }">
                        <c:out value="${ adresses.nomRue } "/>
                    </c:forEach>
            </SELECT>
        </p>

        <p>

            <label for="holiday" class="holiday">Jour de congé autorisée <span class="etoile">*</span> : </label>
            <SELECT id="holiday" name="holiday" size="1" class="ChampFormulaireajoutPersonne">
                <c:forEach var="holiday" items="${ holiday }">
                <OPTION value="${ holiday.idJourDeCongeAutorise }">
                        <c:out value="${ holiday.nbrJourAutorise } "/>
                    </c:forEach>
            </SELECT>
        </p>
        <p>
            <label for="dateDebut" class="labelAjoutPers">Date de debut de contrat: <span class="etoile">*</span>
            </label>
            <input type="date" name="dateDebut" id="dateDebut" class="ChampFormulaireajoutPersonne" required/>

            <label for="dateFin" class="labelAjoutPers">Date de fin de contrat: <span class="etoile">*</span> </label>
            <input type="date" name="dateFin" id="dateFin" class="ChampFormulaireajoutPersonne" required/>
        </p>

        <input type="submit" class="boutonAjoutPersonne"/>
    </fieldset>
</form>
</body>
</html>
