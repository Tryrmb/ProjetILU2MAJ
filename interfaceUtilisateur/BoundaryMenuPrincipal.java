package interfaceUtilisateur;


import gestion.CompteController;
import gestion.EnfantController;
import gestion.GestionnaireIncompatibilité;

import java.util.Scanner;

public class BoundaryMenuPrincipal {
 private Scanner scanner = new Scanner(System.in);
 private CompteController compteController;
 private EnfantController enfantController;

 public BoundaryMenuPrincipal(CompteController compteController, EnfantController enfantController) {
     this.compteController = compteController;
     this.enfantController = enfantController;
 }

 public void afficherMenuPrincipal() {
     int choix;
     do {
         System.out.println("\n--------- Bienvenue Sur EnfantPro+ ---------");
         System.out.println("1) Espace Parent");
         System.out.println("2) Espace Educateur");
         System.out.println("0) Quitter");
         System.out.print("Votre choix : ");
         choix = scanner.nextInt();
         scanner.nextLine();

         switch (choix) {
             case 1:
                 afficherEspaceParent();
                 break;
             case 2:
                 afficherEspaceEducateur();
                 break;
             case 0:
                 System.out.println("Au revoir !");
                 break;
             default:
                 System.out.println("Choix invalide, veuillez réessayer.");
         }
     } while (choix != 0);
 }

 private void afficherEspaceParent() {
     System.out.println("\n--- Espace Parent ---");
     System.out.print("Email : ");
     String email = scanner.nextLine();
     System.out.print("Mot de passe : ");
     String motDePasse = scanner.nextLine();

     if (compteController.verifierIdentifiants(email, motDePasse)) {
         System.out.println("Authentification réussie. Bienvenue dans l'espace Parent !");
         BoundaryEspaceParent espaceParent = new BoundaryEspaceParent(email, compteController, enfantController);
         espaceParent.afficherMenuParent(); // Appel du menu parent
     } else {
         System.out.println("Erreur d'authentification. Veuillez réessayer.");
     }
 }

 private void afficherEspaceEducateur() {
	    System.out.println("\n--- Espace Educateur ---");
	    System.out.print("Email : ");
	    String email = scanner.nextLine();
	    System.out.print("Mot de passe : ");
	    String motDePasse = scanner.nextLine();

	    if (compteController.verifierIdentifiantsEducateur(email, motDePasse)) {
	        System.out.println("Authentification réussie. Bienvenue dans l'espace Educateur !");
	        
	        // Ajouter les paramètres nécessaires pour instancier BoundaryEspaceEducateur
	        GestionnaireIncompatibilité gestionnaireIncompatibilites = new GestionnaireIncompatibilité();
	        BoundaryEspaceEducateur espaceEducateur = new BoundaryEspaceEducateur(email, compteController, enfantController, gestionnaireIncompatibilites);
	        espaceEducateur.afficherMenuEducateur();
	    } else {
	        System.out.println("Erreur d'authentification. Veuillez réessayer.");
	    }
	}


}