package com.atc.momo.Jiwaii.beans;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class LabConnectionForm {
    private String resultat;
    private Map<String,String> erreurs = new HashMap<String,String>();

    public String getResultat(){
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    public PersonnesEntity ConnecterUtilisateur(HttpServletRequest request){
        String emailRecup = request.getParameter("email");
        String passwordRecup = request.getParameter("password");

        PersonnesEntity utilisateur = new PersonnesEntity();
        utilisateur.setEmail(emailRecup);
        utilisateur.setMotDePasse(passwordRecup);
        return utilisateur;
    }
}
