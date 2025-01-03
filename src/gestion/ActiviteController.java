package gestion;

import modele.Activite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe ActiviteController
public class ActiviteController<T extends Activite> {
    private Map<String, List<T>> activitesParEnfant = new HashMap<>();

    public void ajouterActivite(String nomEnfant, T activite) {
        activitesParEnfant.computeIfAbsent(nomEnfant, k -> new ArrayList<>()).add(activite);
    }

    public void afficherActivites(String nomEnfant) {
        List<T> activites = activitesParEnfant.getOrDefault(nomEnfant, new ArrayList<>());
        if (activites.isEmpty()) {
            System.out.println("Aucune activité trouvée pour " + nomEnfant);
        } else {
            System.out.println("Activités pour " + nomEnfant + " :");
            for (T activite : activites) {
                System.out.println("- " + activite.getNom() + ": " + activite.getDescription());
            }
        }
    }
}