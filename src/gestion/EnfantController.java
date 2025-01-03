package gestion;


import java.util.ArrayList;
import java.util.List;

import modele.Enfant;
import modele.Parent;

// Classe EnfantController
//Classe EnfantController
public class EnfantController {
 private List<Enfant> enfants = new ArrayList<>();

 public void ajouterEnfant(Enfant enfant) {
     enfants.add(enfant);
 }

 public List<Enfant> getEnfants() {
     return enfants;
 }

public Parent trouverParentParEmail(String email) {
	// TODO Auto-generated method stub
	return null;
}


}