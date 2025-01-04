package gestion;


import interfaceUtilisateur.BoundaryEspaceParent;
import interfaceUtilisateur.BoundaryEspaceEducateur;

public class UtilisateurController {
 private CompteController compteController;
 private EnfantController enfantController;
 

 public UtilisateurController(CompteController compteController, EnfantController enfantController) {
     this.compteController = compteController;
     this.enfantController = enfantController;
 }

 public void gestionParent(String email) {
     BoundaryEspaceParent espaceParent = new BoundaryEspaceParent(email, compteController, enfantController);
     espaceParent.afficherMenuParent(); // Appelle le menu parent
 }

 public void gestionEducateur(String email) {
	    // Ajouter les paramètres nécessaires (par exemple : enfantController, gestionnaireIncompatibilites)
	    GestionnaireIncompatibilité gestionnaireIncompatibilites = new GestionnaireIncompatibilité();
	    BoundaryEspaceEducateur espaceEducateur = new BoundaryEspaceEducateur(email, compteController, enfantController, gestionnaireIncompatibilites);
	    espaceEducateur.afficherMenuEducateur();
	}


}