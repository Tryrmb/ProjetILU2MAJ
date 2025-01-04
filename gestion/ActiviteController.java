package gestion;

import modele.Activite;

// Classe ActiviteController
public class ActiviteController<T extends Activite> {
    private static final int MAX_ENFANTS = 100; // Taille maximale pour le nombre d'enfants
    private static final int MAX_ACTIVITES_PAR_ENFANT = 10; // Taille maximale pour les activités par enfant

    private String[] nomsEnfants = new String[MAX_ENFANTS];
    private T[][] activitesParEnfant = (T[][]) new Activite[MAX_ENFANTS][MAX_ACTIVITES_PAR_ENFANT];
    private int[] nombreActivitesParEnfant = new int[MAX_ENFANTS];
    private int nombreEnfants = 0;

    // Ajouter une activité pour un enfant
    public void ajouterActivite(String nomEnfant, T activite) {
        int indexEnfant = trouverIndexEnfant(nomEnfant);

        if (indexEnfant == -1) {
            // Ajouter un nouvel enfant
            if (nombreEnfants < MAX_ENFANTS) {
                nomsEnfants[nombreEnfants] = nomEnfant;
                indexEnfant = nombreEnfants;
                nombreEnfants++;
            } else {
                System.out.println("Erreur : Limite maximale d'enfants atteinte.");
                return;
            }
        }

        // Ajouter l'activité à l'enfant
        if (nombreActivitesParEnfant[indexEnfant] < MAX_ACTIVITES_PAR_ENFANT) {
            activitesParEnfant[indexEnfant][nombreActivitesParEnfant[indexEnfant]] = activite;
            nombreActivitesParEnfant[indexEnfant]++;
        } else {
            System.out.println("Erreur : Limite maximale d'activités atteinte pour " + nomEnfant);
        }
    }

    // Afficher les activités pour un enfant donné
    public void afficherActivites(String nomEnfant) {
        int indexEnfant = trouverIndexEnfant(nomEnfant);

        if (indexEnfant == -1) {
            System.out.println("Aucune activité trouvée pour " + nomEnfant);
            return;
        }

        System.out.println("Activités pour " + nomEnfant + " :");
        for (int i = 0; i < nombreActivitesParEnfant[indexEnfant]; i++) {
            T activite = activitesParEnfant[indexEnfant][i];
            System.out.println("- " + activite.getNom() + ": " + activite.getDescription());
        }
    }

    // Trouver l'index d'un enfant dans le tableau
    private int trouverIndexEnfant(String nomEnfant) {
        for (int i = 0; i < nombreEnfants; i++) {
            if (nomsEnfants[i].equals(nomEnfant)) {
                return i;
            }
        }
        return -1; // Enfant non trouvé
    }
}
