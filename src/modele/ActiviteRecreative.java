package modele;

import enumeration.TypeActivite;

/**
 * Classe ActiviteRecreative
 * Représente une activité récréative et vérifie les restrictions associées.
 */
public class ActiviteRecreative extends Activite {
    private String typeLieu;

    /**
     * Constructeur de l'activité récréative.
     *
     * @param nom          Nom de l'activité.
     * @param description  Description de l'activité.
     * @param typeLieu     Type de lieu associé à l'activité.
     */
    public ActiviteRecreative(String nom, String description, String typeLieu) {
        super(nom, description, TypeActivite.RECREATIVE); // Associe l'énumération TypeActivite
        this.typeLieu = typeLieu;
    }

    /**
     * Obtient le type de lieu associé à l'activité.
     *
     * @return Type de lieu.
     */
    public String getTypeLieu() {
        return typeLieu;
    }

    /**
     * Vérifie les restrictions liées aux participants et au lieu.
     */
    @Override
    public void verifierCompatibiliteParticipants() {
        System.out.println("Vérification des restrictions pour l'activité récréative : " + getNom());
    }

    /**
     * Gère les incompatibilités détectées pour les activités récréatives.
     */
    @Override
    public void gererIncompatibilites() {
        System.out.println("Gestion des incompatibilités pour l'activité récréative : " + getNom());
        // Ajouter une logique spécifique pour gérer les incompatibilités liées au lieu
    }
}