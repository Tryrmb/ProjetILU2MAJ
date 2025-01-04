package interfaceUtilisateur;


import gestion.ActiviteController;
import modele.Activite;
import modele.ActiviteCulinaire;
import java.util.Scanner;

public class BoundaryGestionActivitesIU {
	
	private Scanner scanner = new Scanner(System.in);
	 private ActiviteController<Activite> activiteController = new ActiviteController<>();

	 public void gererActivites() {
	     int choix;
	     do {
	         System.out.println("\n--- Gestion des Activités ---");
	         System.out.println("1) Ajouter une activité");
	         System.out.println("2) Afficher les activités d'un enfant");
	         System.out.println("0) Retour");
	         System.out.print("Votre choix : ");
	         choix = scanner.nextInt();
	         scanner.nextLine();

	         switch (choix) {
	             case 1:
	                 ajouterActivite();
	                 break;
	             case 2:
	                 afficherActivites();
	                 break;
	             case 0:
	                 System.out.println("Retour au menu principal.");
	                 break;
	             default:
	                 System.out.println("Choix invalide, veuillez réessayer.");
	         }
	     } while (choix != 0);
	 }

	 private void ajouterActivite() {
	     System.out.print("Nom de l'enfant : ");
	     String nomEnfant = scanner.nextLine();
	     System.out.print("Nom de l'activité : ");
	     String nomActivite = scanner.nextLine();
	     System.out.print("Description de l'activité : ");
	     String description = scanner.nextLine();

	     Activite activite = new ActiviteCulinaire(nomActivite, description, "Cuisine générale");
	     activiteController.ajouterActivite(nomEnfant, activite);
	     System.out.println("Activité ajoutée avec succès pour " + nomEnfant);
	 }

	 private void afficherActivites() {
	     System.out.print("Nom de l'enfant : ");
	     String nomEnfant = scanner.nextLine();
	     activiteController.afficherActivites(nomEnfant);
	 }

}