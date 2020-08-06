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
<script>
    function showDetailFor(pId, pNom) {

        var elementSectionDetail = document.getElementById("rowDetail");
            elementSectionDetail.innerHTML = null;

        var elementForm = document.createElement("form");
            elementForm.setAttribute("method", "post");
            elementForm.setAttribute("action","reponseDeDemande")
            elementForm.setAttribute("class", "formulaireReponseDemande");

        var elementLegend = document.createElement("legend");
            elementLegend.innerHTML = "Détail de la demande de "+pNom;

        var elementFieldSetLegend = document.createElement("fieldset");
            elementFieldSetLegend.appendChild(elementLegend);

            // LABEL AND INPUT CONFIG FOR PUSH IN  elementFieldSetLegend
        var elementLabel = document.createElement("label");
            elementLabel.innerHTML = "Demande n° ";
            elementLabel.setAttribute("for","idDemande");
            elementLabel.setAttribute("class","labelFormDemande");

        var elementInput = document.createElement("input");
            elementInput.setAttribute("type","text");
            elementInput.setAttribute("name","idDemande");
            elementInput.setAttribute("value",pId);
            elementInput.setAttribute("readonly",true);
            elementInput.setAttribute("size","5");
            elementInput.setAttribute("class", "champFormReponseDemande");

        var P = document.createElement("p");
        // END FOR PUSH IN  elementFieldSetLegend

        // Label Input commentaire:
        var elementLabelCommentaire = document.createElement("label");
        elementLabelCommentaire.innerHTML = " Vos commentaires : ";
        elementLabelCommentaire.setAttribute("for","Commentaire");
        elementLabelCommentaire.setAttribute("class","labelFormDemande");

        var elementInputCommentaire = document.createElement("input");
        elementInputCommentaire.setAttribute("type","textarea");
        elementInputCommentaire.setAttribute("name","Commentaire ");
        elementInputCommentaire.setAttribute("class", "champFormReponseDemande");
        elementInputCommentaire.setAttribute("rows","50");
        elementInputCommentaire.setAttribute("size","50");

        // radio button

        var elementInputRadioAccepter = document.createElement("input");
        elementInputRadioAccepter.setAttribute("type","radio");
        elementInputRadioAccepter.setAttribute("name","approuve ");
        elementInputRadioAccepter.setAttribute("value","accepte");

        var elementLabelRadioAccepter = document.createElement("label");
        elementLabelRadioAccepter.innerHTML = "Accepter"
        elementLabelRadioAccepter.setAttribute("for","accepte");


        var elementInputRadioRefuser = document.createElement("input");
        elementInputRadioRefuser.setAttribute("type","radio");
        elementInputRadioRefuser.setAttribute("name","approuve ");
        elementInputRadioRefuser.setAttribute("value","refuse");

        var elementLabelRadioRefuser = document.createElement("label");
        elementLabelRadioRefuser.innerHTML = "Refuser";
        elementLabelRadioRefuser.setAttribute("for","refuse");

        // SUBMIT

        var elementInputSubmit = document.createElement("input");
        elementInputSubmit.setAttribute("type","submit");
        elementInputSubmit.setAttribute("class","boutonAjoutPersonne")
        elementInputSubmit.setAttribute("value","Répondre");


        //AppendChild Form
        elementFieldSetLegend.appendChild(elementLabel);
        elementFieldSetLegend.appendChild(elementInput);
        elementFieldSetLegend.appendChild(P);

        elementFieldSetLegend.appendChild(P).appendChild(elementLabelRadioAccepter);
        elementFieldSetLegend.appendChild(P).appendChild(elementInputRadioAccepter);
        elementFieldSetLegend.appendChild(P).appendChild(elementLabelRadioRefuser);
        elementFieldSetLegend.appendChild(P).appendChild(elementInputRadioRefuser);
        elementFieldSetLegend.appendChild(document.createElement("p"))
        elementFieldSetLegend.appendChild(elementLabelCommentaire);
        elementFieldSetLegend.appendChild(elementInputCommentaire);
        elementFieldSetLegend.appendChild(P);
        elementFieldSetLegend.appendChild(elementInputSubmit);



        elementForm.appendChild(elementFieldSetLegend);
        elementSectionDetail.appendChild(elementForm);
    }
</script>

<body>
<c:import url="header.jsp"/>



<table style="width:100%" border="1px solid black">

    <tr>
        <th>Numero de la Demande</th>
        <th>Nom</th>
        <th>Date Demande</th>
        <th>Date Debut</th>
        <th>Date Fin</th>

    </tr>
    <c:forEach var="demandeEnCours" items="${demandeEnCours}">
        <tr onclick="showDetailFor(${demandeEnCours[0]},'${demandeEnCours[5]} '+'${demandeEnCours[1]}')"/>
            <td><c:out value="${ demandeEnCours[0] } "/></td>
            <td><c:out value="${ demandeEnCours[1] } "/></td>
            <td><c:out value="${ demandeEnCours[2] } "/></td>
            <td><c:out value="${ demandeEnCours[3] } "/></td>
            <td><c:out value="${ demandeEnCours[4] } "/></td>
        </tr>
    </c:forEach>
</table>
<section id="rowDetail">

</section>

</body>
</html>