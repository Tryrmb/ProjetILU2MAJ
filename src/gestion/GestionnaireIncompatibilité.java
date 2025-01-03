// Package : gestion
package gestion;

import modele.Enfant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Classe GestionnaireIncompatibilité
 * Gère les vérifications d'incompatibilités pour les activités des enfants
 * en fonction de leurs allergies et conditions médicales.
 */
public class GestionnaireIncompatibilité {
    private Map<String, List<String>> incompatibilitesActivites; // Map des incompatibilités
    private Map<String, List<String>> activitesParCategorie; // Map des catégories et leurs activités

    public GestionnaireIncompatibilité() {
        this.incompatibilitesActivites = new HashMap<>();
        this.activitesParCategorie = new HashMap<>();
        initialiserCategoriesActivites();
    }

    // Initialisation des catégories d'activités et des activités associées
    private void initialiserCategoriesActivites() {
        activitesParCategorie.put("Activités Culinaires", List.of(
                "Gâteau aux pommes", "Cookie aux chocolats", "Cupcakes aux fraises", "Hamburger maison", "Pizza végétarienne"));
        activitesParCategorie.put("Activités Récréatives", List.of(
                "Peinture avec les doigts", "Jeux d'eau sensoriels", "Parcours motricité", "Conte interactif", "Atelier pâte à modeler"));
        activitesParCategorie.put("Sorties en Forêt", List.of(
                "Chasse aux trésors nature", "Construction cabane miniature", "Comptine en plein air", 
                "Parcours sensoriels", "Observation animaux et insectes"));
        activitesParCategorie.put("Sorties Aquatiques", List.of(
                "Bébé nageur", "Bébé nageur", "Bébé nageur", "Bébé nageur", "Bébé nageur"));
    }
    
    
    public void chargerIncompatibilitesDepuisCSV(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String ligne;
        boolean isFirstLine = true;

        while ((ligne = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            String[] donnees = ligne.split(",");
            if (donnees.length < 2) {
                System.err.println("Ligne ignorée : nombre insuffisant de colonnes -> " + ligne);
                continue;
            }

            String activite = donnees[0].trim();
            List<String> incompatibilites = List.of(donnees[1].split(";"));
            ajouterIncompatibilites(activite, incompatibilites);

            // Affichez les incompatibilités chargées pour vérifier
            System.out.println("Activité : " + activite + " | Incompatibilités : " + incompatibilites);
        }
        reader.close();
    }


    
    public void ajouterIncompatibilites(String activite, List<String> incompatibilites) {
        incompatibilitesActivites.put(activite, incompatibilites);
    }

    public boolean estCompatible(String activite, Enfant enfant) {
        List<String> incompatibilites = incompatibilitesActivites.get(activite);

        if (incompatibilites == null) {
            return true; // Pas d'incompatibilités définies pour cette activité
        }

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

    public List<String> getActivitesParCategorie(String categorie) {
        return activitesParCategorie.getOrDefault(categorie, Collections.emptyList());
    }
    
    public List<String> getActivitesCompatiblesParCategorie(String categorie, Enfant enfant) {
        List<String> toutesActivites = getActivitesParCategorie(categorie);
        List<String> activitesCompatibles = new ArrayList<>();
        for (String activite : toutesActivites) {
            if (estCompatible(activite, enfant)) {
                activitesCompatibles.add(activite);
            }
        }
        return activitesCompatibles;
    }



    public void afficherIncompatibilites() {
        System.out.println("\n--- Incompatibilités des Activités ---");
        for (Map.Entry<String, List<String>> entry : incompatibilitesActivites.entrySet()) {
            System.out.println("Activité : " + entry.getKey());
            System.out.println("Incompatibilités : " + entry.getValue());
        }
    }
}
