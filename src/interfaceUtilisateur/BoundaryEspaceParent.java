package interfaceUtilisateur;



import gestion.CompteController;
import gestion.EnfantController;
import modele.Enfant;
import modele.Parent;

import java.util.List;
import java.util.Scanner;

public class BoundaryEspaceParent {
 private Scanner scanner = new Scanner(System.in);
 private CompteController compteController;
 private EnfantController enfantController;
 private Parent parent;

 public BoundaryEspaceParent(String email, CompteController compteController, EnfantController enfantController) {
     this.compteController = compteController;
     this.enfantController = enfantController;
     this.parent = compteController.trouverParentParEmail(email); // Récupérer les infos du parent
 }

 public void afficherMenuParent() {
     if (parent == null) {
         System.out.println("Erreur : Impossible de charger les données du parent.");
         return;
     }

     int choix;
     do {
         System.out.println("\n--- Menu Parent ---");
         System.out.println("1) Voir les activités des enfants");
         System.out.println("2) Voir les informations santé des enfants");
         System.out.println("3) Voir les bilans");
         System.out.println("0) Retour au menu principal");
         System.out.print("Votre choix : ");
         choix = scanner.nextInt();
         scanner.nextLine(); // Consommer la ligne restante

         switch (choix) {
             case 1:
                 afficherActivitesEnfants();
                 break;
             case 2:
                 afficherSanteEnfants();
                 break;
             case 3:
                 afficherBilans();
                 break;
             case 0:
                 System.out.println("Retour au menu principal.");
                 break;
             default:
                 System.out.println("Choix invalide, veuillez réessayer.");
         }
     } while (choix != 0);
 }

 private void afficherActivitesEnfants() {
     System.out.println("\n--- Activités des enfants ---");
     parent.getEnfants().forEach(enfant -> {
         System.out.println("Enfant : " + enfant.getNom());
         enfant.getActivites().forEach(activite -> System.out.println(" - Activité : " + activite));
     });
 }

 private void afficherSanteEnfants() {
     System.out.println("\n--- Informations santé des enfants ---");
     parent.getEnfants().forEach(enfant -> {
         System.out.println("Enfant : " + enfant.getNom());
         System.out.println(" - Allergies : " + enfant.getAllergies());
         System.out.println(" - Régime alimentaire : " + enfant.getRegimeAlimentaire());
     });
 }

 private void afficherBilans() {
	    System.out.println("\n--- Bilans des enfants ---");

	    List<Enfant> enfants = parent.getEnfants();
	    if (enfants.isEmpty()) {
	        System.out.println("Aucun enfant enregistré.");
	        return;
	    }

	    for (Enfant enfant : enfants) {
	        System.out.println("Enfant : " + enfant.getNom());
	        String bilan = enfant.getBilan();
	        if (bilan.isEmpty()) {
	            System.out.println(" - Bilan : Non disponible.");
	        } else {
	            System.out.println(" - Bilan : " + bilan);
	        }
	    }
	}

}
