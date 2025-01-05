// Package : Gestion
package gestion;

import modele.Parent;
import modele.Educateur;
import modele.Enfant;

public class CompteController {
    private DataStorage dataStorage;

    public CompteController(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public boolean verifierIdentifiants(String email, String motDePasse) {
        Parent parent = dataStorage.trouverParentParEmail(email);
        return parent != null && parent.getMotDePasse().equals(motDePasse);
    }

    public boolean verifierIdentifiantsEducateur(String email, String motDePasse) {
        System.out.println("Tentative d'authentification :");
        System.out.println("Email fourni : " + email);
        System.out.println("Mot de passe fourni : " + motDePasse);

        Educateur educateur = dataStorage.trouverEducateurParEmail(email);

        if (educateur == null) {
            System.out.println("Échec : Aucun éducateur trouvé avec l'email " + email);
            return false;
        }

        System.out.println("Éducateur trouvé : " + educateur.getEmail());
        System.out.println("Mot de passe attendu : " + educateur.getMotDePasse());

        if (educateur.getMotDePasse().equals(motDePasse)) {
            System.out.println("Authentification réussie !");
            return true;
        } else {
            System.out.println("Échec : Mot de passe incorrect.");
            return false;
        }
    }

    public Parent trouverParentParEnfant(String nomEnfant) {
        for (Parent parent : dataStorage.getParents()) {
            if (parent != null) {
                for (Enfant enfant : parent.getEnfants()) {
                    if (enfant.getNom().equalsIgnoreCase(nomEnfant)) {
                        return parent;
                    }
                }
            }
        }
        return null;
    }


    
    
    public Parent trouverParentParEmail(String email) {
        return dataStorage.trouverParentParEmail(email);
    }

    public Educateur trouverEducateurParEmail(String email) {
        return dataStorage.trouverEducateurParEmail(email);
    }
}