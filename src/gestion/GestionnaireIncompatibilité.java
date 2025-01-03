package gestion;

import modele.Enfant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe GestionnaireIncompatibilité
 * Gère les vérifications d'incompatibilités pour les activités des enfants
 * en fonction de leurs allergies et conditions médicales.
 */
public class GestionnaireIncompatibilité {
    private Map<String, List<String>> incompatibilitesActivites; // Map des incompatibilités

    public GestionnaireIncompatibilité() {
        this.incompatibilitesActivites = new HashMap<>();
    }

    public void ajouterIncompatibilites(String activite, List<String> incompatibilites) {
        incompatibilitesActivites.put(activite, incompatibilites);
    }

    public boolean estCompatible(String activite, Enfant enfant) {
        List<String> incompatibilites = incompatibilitesActivites.get(activite);

        if (incompatibilites == null) {
            return true; // Pas d'incompatibilités définies pour cette activité
        }

        // Vérifie les incompatibilités avec les allergies et les problèmes de santé
        for (String condition : enfant.getAllergies()) {
            if (incompatibilites.contains(condition)) {
                return false; // Une incompatibilité détectée
            }
        }

        for (String probleme : enfant.getProblemesDeSante()) {
            if (incompatibilites.contains(probleme)) {
                return false; // Une incompatibilité détectée
            }
        }

        return true; // Aucune incompatibilité trouvée
    }

    public void afficherIncompatibilites() {
        System.out.println("\n--- Incompatibilités des Activités ---");
        for (Map.Entry<String, List<String>> entry : incompatibilitesActivites.entrySet()) {
            System.out.println("Activité : " + entry.getKey());
            System.out.println("Incompatibilités : " + entry.getValue());
        }
    }
}
