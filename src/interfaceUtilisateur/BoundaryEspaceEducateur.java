package interfaceUtilisateur;

import gestion.CompteController;
import gestion.AllergieEtRestriction;
import gestion.RestrictionIncompatibleException;
import modele.Educateur;
import java.util.Scanner;

public class BoundaryEspaceEducateur {
    private Scanner scanner = new Scanner(System.in);
    private CompteController compteController;
    private Educateur educateur;
    private AllergieEtRestriction<String> allergiesEtRestrictions = new AllergieEtRestriction<>();

    public BoundaryEspaceEducateur(String email, CompteController compteController) {
        this.compteController = compteController;
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
            scanner.nextLine(); // Consommer la ligne restante

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

    private void ajouterModifierAllergie() {
        System.out.println("\n--- Ajouter ou Modifier une Allergie ---");
        System.out.print("Nom de l'enfant : ");
        String nomEnfant = scanner.nextLine();

        System.out.print("Nouvelle allergie : ");
        String allergie = scanner.nextLine();

        System.out.println("L'allergie \"" + allergie + "\" a été ajoutée/modifiée pour l'enfant \"" + nomEnfant + "\".");
    }

    private void ajouterModifierProblemeDeSante() {
        System.out.println("\n--- Ajouter ou Modifier un Problème de Santé ---");
        System.out.print("Nom de l'enfant : ");
        String nomEnfant = scanner.nextLine();

        System.out.print("Nouveau problème de santé : ");
        String probleme = scanner.nextLine();

        System.out.println("Le problème de santé \"" + probleme + "\" a été ajouté/modifié pour l'enfant \"" + nomEnfant + "\".");
    }

    private void gererActivites() {
        System.out.println("\n--- Gérer les Activités ---");
        System.out.println("Fonctionnalité en cours de développement.");
    }

    private void gererBilans() {
        System.out.println("\n--- Gérer les Bilans ---");
        System.out.println("Fonctionnalité en cours de développement.");
    }

    private void gererAllergies() {
        System.out.println("\n--- Gérer les Allergies ---");
        try {
            System.out.print("Type de restriction/allergie : ");
            String restriction = scanner.nextLine();
            System.out.print("Description : ");
            String description = scanner.nextLine();
            System.out.print("Niveau de gravité (0-10) : ");
            int niveau = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante
            System.out.print("Action préventive : ");
            String action = scanner.nextLine();

            allergiesEtRestrictions.ajouterRestriction(restriction, description, niveau, action);
            System.out.println("Restriction ajoutée avec succès.");
        } catch (RestrictionIncompatibleException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}