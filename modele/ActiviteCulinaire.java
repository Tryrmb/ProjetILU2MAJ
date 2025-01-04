package modele;

import enumeration.TypeActivite;

/**
 * Classe ActiviteCulinaire
 * Représente une activité culinaire et vérifie les restrictions alimentaires.
 */
public class ActiviteCulinaire extends Activite {
    private String typeCuisine;

    /**
     * Constructeur de l'activité culinaire.
     *
     * @param nom          Nom de l'activité.
     * @param description  Description de l'activité.
     * @param typeCuisine  Type de cuisine associée à l'activité.
     */
    public ActiviteCulinaire(String nom, String description, String typeCuisine) {
        super(nom, description, TypeActivite.CULINAIRE); // Associe l'énumération TypeActivite
        this.typeCuisine = typeCuisine;
    }

    /**
     * Obtient le type de cuisine associé à l'activité.
     *
     * @return Type de cuisine.
     */
    public String getTypeCuisine() {
        return typeCuisine;
    }

    /**
     * Vérifie les restrictions alimentaires des participants.
     */
    @Override
    public void verifierCompatibiliteParticipants() {
        System.out.println("Vérification des allergies et restrictions pour l'activité culinaire : " + getNom());
        
    }

    /**
     * Gère les incompatibilités détectées.
     */
    @Override
    public void gererIncompatibilites() {
        System.out.println("Gestion des incompatibilités pour l'activité culinaire : " + getNom());
        // Ajouter une logique pour gérer les incompatibilités si nécessaire
        
    }
}