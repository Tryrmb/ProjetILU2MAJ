// Package : Modele
package modele;

import java.util.ArrayList;
import java.util.List;

import enumeration.TypeActivite;

/**
 * Classe abstraite Activite
 * Modélise une activité en crèche en prenant en compte les allergies et les
 * restrictions alimentaires des participants.
 */
public abstract class Activite {
    private String nom;
    private String description;
    private TypeActivite typeActivite; // Enum pour le type d'activité

    // Attributs pour gérer les participants et leurs informations
    private List<String> participants = new ArrayList<>();
    private List<String> restrictionsAlimentaires = new ArrayList<>();
    private List<String> contactsParents = new ArrayList<>();

    // Constructeur
    public Activite(String nom, String description, TypeActivite typeActivite) {
        this.nom = nom;
        this.description = description;
        this.typeActivite = typeActivite;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public TypeActivite getTypeActivite() {
        return typeActivite;
    }

    // Méthodes abstraites
    /**
     * Vérifie la compatibilité des participants avec les restrictions alimentaires.
     */
    public abstract void verifierCompatibiliteParticipants();

    /**
     * Gère les incompatibilités pour une activité spécifique (par exemple, exclusion ou
     * modification).
     */
    public abstract void gererIncompatibilites();

    // Méthodes concrètes

    /**
     * Ajoute un participant avec sa restriction alimentaire et son contact parent.
     *
     * @param enfant         Nom de l'enfant participant
     * @param restriction    Restriction alimentaire de l'enfant
     * @param contactParent  Coordonnées du parent (email ou téléphone)
     */
    public void ajouterParticipant(String enfant, String restriction, String contactParent) {
        participants.add(enfant);
        restrictionsAlimentaires.add(restriction);
        contactsParents.add(contactParent);
    }

    /**
     * Affiche les participants, leurs restrictions alimentaires et les contacts des parents.
     */
    public void afficherParticipants() {
        System.out.println("Participants de l'activité : " + nom);
        for (int i = 0; i < participants.size(); i++) {
            System.out.println(" - Enfant : " + participants.get(i));
            System.out.println("   Restriction : " + restrictionsAlimentaires.get(i));
            System.out.println("   Contact parent : " + contactsParents.get(i));
        }
    }

    /**
     * Envoie une notification générique aux parents.
     *
     * @param message Message à envoyer aux parents
     */
    public void notifierParents(String message) {
        System.out.println("Envoi de notifications aux parents...");
        for (String contact : contactsParents) {
            System.out.println("Notification envoyée à " + contact + " : " + message);
        }
    }
}

