package modele;


import java.util.ArrayList;
import java.util.List;

import gestion.AllergieEtRestriction;

public class Enfant {
    private String nom;
    private String allergies;
    private String regimeAlimentaire;
    private List<String> activites = new ArrayList<>();
    private AllergieEtRestriction<String> allergiesEtRestrictions = new AllergieEtRestriction<>();


    public Enfant(String nom, String allergies, String regimeAlimentaire) {
        this.nom = nom;
        this.allergies = allergies;
        this.regimeAlimentaire = regimeAlimentaire;
    }

    public String getNom() {
        return nom;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getRegimeAlimentaire() {
        return regimeAlimentaire;
    }

    public void ajouterActivite(String activite) {
        activites.add(activite);
    }

    public List<String> getActivites() {
        return activites;
    }
    
    
}