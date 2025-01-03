package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Enfant
 * Représente un enfant avec ses allergies, son régime alimentaire, et ses activités.
 */
public class Enfant {
    private String nom;
    private List<String> allergies; // Liste des allergies
    private String regimeAlimentaire;
    private List<String> activites; // Activités de l'enfant
    private List<String> problemesDeSante; // Liste des problèmes de santé
    private String bilan; // Bilan individuel

    // Constructeur existant
    public Enfant(String nom, String allergiesRaw, String regimeAlimentaire) {
        this.nom = nom;
        this.allergies = new ArrayList<>(List.of(allergiesRaw.split(", ")));
        this.regimeAlimentaire = regimeAlimentaire;
        this.activites = new ArrayList<>();
        this.problemesDeSante = new ArrayList<>();
        this.bilan = "";
    }

    // Nouveau constructeur
    public Enfant(String nom, List<String> allergiesList, String regimeAlimentaire) {
        this.nom = nom;
        this.allergies = new ArrayList<>(allergiesList); // Copie de la liste
        this.regimeAlimentaire = regimeAlimentaire;
        this.activites = new ArrayList<>();
        this.problemesDeSante = new ArrayList<>();
        this.bilan = "";
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void ajouterAllergie(String allergie) {
        if (!allergies.contains(allergie)) {
            allergies.add(allergie);
        }
    }

    public boolean supprimerAllergie(String allergie) {
        return allergies.remove(allergie);
    }

    public String getRegimeAlimentaire() {
        return regimeAlimentaire;
    }

    public List<String> getActivites() {
        return activites;
    }

    public void ajouterActivite(String activite) {
        activites.add(activite);
    }

    public List<String> getProblemesDeSante() {
        return problemesDeSante;
    }

    public void ajouterProblemeDeSante(String probleme) {
        problemesDeSante.add(probleme);
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }
}
