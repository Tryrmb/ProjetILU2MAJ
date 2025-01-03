// Package : InterfaceUtilisateur
package interfaceUtilisateur;

import gestion.CompteController;
import gestion.EnfantController;
import gestion.GestionnaireIncompatibilité;
import gestion.DataStorage;
import modele.Enfant;
import modele.Parent;
import modele.Educateur;
import java.util.Scanner;

public class BoundaryEspaceEducateur {
	private Scanner scanner = new Scanner(System.in);
    private CompteController compteController;
    private EnfantController enfantController;
    private GestionnaireIncompatibilité gestionnaireIncompatibilite;
    private Educateur educateur;

    public BoundaryEspaceEducateur(String email, CompteController compteController, EnfantController enfantController, GestionnaireIncompatibilité gestionnaireIncompatibilite) {
        this.compteController = compteController;
        this.enfantController = enfantController;
        this.gestionnaireIncompatibilite = gestionnaireIncompatibilite;
        this.educateur = compteController.trouverEducateurParEmail(email);
    }

    public void afficherMenuEducateur() {
        if (educateur == null) {
            System.out.println("Erreur : Impossible de charger les données de l'éducateur.");
            return;
        }

        int choix;
        do {
            System.out.println("\n--- Menu Éducateur ---");
            System.out.println("1) Ajouter ou modifier une allergie");
            System.out.println("2) Ajouter ou modifier un problème de santé");
            System.out.println("3) Gérer les activités");
            System.out.println("4) Gérer les bilans");
            System.out.println("5) Gérer les allergies");
            System.out.println("0) Retour au menu principal");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterModifierAllergie();
                    break;
                case 2:
                    ajouterModifierProblemeDeSante();
                    break;
                case 3:
                    gererActivites();
                    break;
                case 4:
                    gererBilans();
                    break;
                case 5:
                    gererAllergies();
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 0);
    }

    private void gererActivites() {
    	System.out.println("\n--- Gérer les Activités ---");
        System.out.print("Nom de l'enfant : ");
        String nomEnfant = scanner.nextLine();

        Enfant enfant = enfantController.trouverEnfantParNom(nomEnfant);
        if (enfant == null) {
            System.out.println("Erreur : Enfant introuvable.");
            return;
        }

        System.out.println("Allergies : " + enfant.getAllergies());
        System.out.println("Problèmes de santé : " + enfant.getProblemesDeSante());

        String[] activitesDisponibles = {"Natation", "Cuisine", "Danse"};
        for (String activite : activitesDisponibles) {
            if (gestionnaireIncompatibilite.estCompatible(activite, enfant)) {
                System.out.println("Activité disponible : " + activite);
            } else {
                System.out.println("Activité non disponible : " + activite);
            }
        }

        System.out.print("Choisissez une activité (ou 0 pour retour) : ");
        String choix = scanner.nextLine();
        if (!choix.equals("0")) {
            if (gestionnaireIncompatibilite.estCompatible(choix, enfant)) {
                enfant.ajouterActivite(choix);
                System.out.println("Activité \"" + choix + "\" ajoutée pour l'enfant \"" + nomEnfant + "\".");
            } else {
                System.out.println("Impossible d'ajouter l'activité à cause d'une incompatibilité.");
            }
        }
    }

    private void gererBilans() {
        System.out.println("\n--- Gérer les Bilans ---");
        System.out.print("Nom de l'enfant : ");
        String nomEnfant = scanner.nextLine();

        Enfant enfant = enfantController.trouverEnfantParNom(nomEnfant);
        if (enfant == null) {
            System.out.println("Erreur : Enfant introuvable.");
            return;
        }

        System.out.print("Entrez le bilan : ");
        String bilan = scanner.nextLine();

        enfant.setBilan(bilan);
        System.out.println("Bilan enregistré avec succès pour " + enfant.getNom());
    }



    private void gererAllergies() {
        System.out.println("\n--- Gérer les Allergies ---");
        System.out.print("Nom de l'enfant : ");
        String nomEnfant = scanner.nextLine();
        Enfant enfant = enfantController.trouverEnfantParNom(nomEnfant);

        if (enfant == null) {
            System.out.println("Erreur : Enfant introuvable.");
            return;
        }

        System.out.println("Allergies actuelles : " + enfant.getAllergies());
        System.out.print("Entrez l'allergie à supprimer : ");
        String allergie = scanner.nextLine();

        if (enfant.supprimerAllergie(allergie)) {
            System.out.println("Allergie supprimée avec succès.");
        } else {
            System.out.println("Allergie non trouvée pour cet enfant.");
        }
    }

    private void ajouterModifierAllergie() {
        System.out.println("\n--- Ajouter ou Modifier une Allergie ---");
        System.out.print("Nom de l'enfant : ");
        String nomEnfant = scanner.nextLine();
        Enfant enfant = enfantController.trouverEnfantParNom(nomEnfant);

        if (enfant == null) {
            System.out.println("Erreur : Enfant introuvable.");
            return;
        }

        System.out.print("Nouvelle allergie : ");
        String allergie = scanner.nextLine();

        try {
            enfant.ajouterAllergie(allergie);
            System.out.println("L'allergie \"" + allergie + "\" a été ajoutée/modifiée pour l'enfant \"" + nomEnfant + "\".");
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    private void ajouterModifierProblemeDeSante() {
        System.out.println("\n--- Ajouter ou Modifier un Problème de Santé ---");
        System.out.print("Nom de l'enfant : ");
        String nomEnfant = scanner.nextLine();
        Enfant enfant = enfantController.trouverEnfantParNom(nomEnfant);

        if (enfant == null) {
            System.out.println("Erreur : Enfant introuvable.");
            return;
        }

        System.out.print("Nouveau problème de santé : ");
        String probleme = scanner.nextLine();

        enfant.ajouterProblemeDeSante(probleme);
        System.out.println("Le problème de santé \"" + probleme + "\" a été ajouté/modifié pour l'enfant \"" + nomEnfant + "\".");
    }
}
