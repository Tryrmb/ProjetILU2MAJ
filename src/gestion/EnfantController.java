package gestion;

import modele.Enfant;
import java.util.ArrayList;
import java.util.List;

public class EnfantController {
    private List<Enfant> enfants;

    public EnfantController() {
        this.enfants = new ArrayList<>();
    }

    public void ajouterEnfant(Enfant enfant) {
        enfants.add(enfant);
    }

    public Enfant trouverEnfantParNom(String nom) {
        for (Enfant enfant : enfants) {
            if (enfant.getNom().equalsIgnoreCase(nom)) {
                return enfant;
            }
        }
        return null;
    }

    public List<Enfant> getEnfants() {
        return enfants;
    }
    
  

}
