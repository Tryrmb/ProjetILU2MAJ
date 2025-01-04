package gestion;

import modele.Enfant;

public class EnfantController {
    private static final int MAX_ENFANTS = 100; // Limite maximale pour le nombre d'enfants
    private Enfant[] enfants; // Tableau pour stocker les enfants
    private int enfantCount; // Compteur pour suivre le nombre d'enfants ajoutés

    public EnfantController() {
        this.enfants = new Enfant[MAX_ENFANTS];
        this.enfantCount = 0;
    }

    public void ajouterEnfant(Enfant enfant) {
        if (enfantCount < MAX_ENFANTS) {
            enfants[enfantCount++] = enfant;
        } else {
            System.err.println("Erreur : Limite maximale d'enfants atteinte.");
        }
    }

    public Enfant trouverEnfantParNom(String nom) {
        for (int i = 0; i < enfantCount; i++) {
            if (enfants[i].getNom().equalsIgnoreCase(nom)) {
                return enfants[i];
            }
        }
        return null;
    }

    public Enfant[] getEnfants() {
        Enfant[] result = new Enfant[enfantCount];
        System.arraycopy(enfants, 0, result, 0, enfantCount);
        return result;
    }
}
