function showDetailFor() {
    if (document.contains(document.getElementsByName("form")[0]))
    {
        var element = document.getElementsByName("form")[0];
        document.removeChild(element);
    }
    else {

        var elementForm = document.createElement("form");
        elementForm.setAttribute("action", "post");
        elementForm.setAttribute("class", "formulaireReponseDemande");
        var fielSet = document.createElement("fieldset").appendChild(document.createElement("legend"));
        fielSet.innerHTML = "Detail de la demande N° ";
        elementForm.appendChild(fielSet);

    }
}