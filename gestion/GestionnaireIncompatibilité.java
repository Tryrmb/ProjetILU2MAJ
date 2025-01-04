package gestion;

import modele.Enfant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestionnaireIncompatibilité {
    private static final int MAX_ACTIVITES = 100; // Limite maximale pour le nombre d'activités
    private static final int MAX_CATEGORIES = 10; // Limite maximale pour le nombre de catégories
    private String[] activites; // Tableau des noms des activités
    private String[][] incompatibilites; // Tableau des incompatibilités par activité
    private String[][] activitesParCategorie; // Tableau des activités par catégorie
    private String[] categories; // Tableau des catégories
    private int activiteCount; // Compteur pour le nombre d'activités

    public GestionnaireIncompatibilité() {
        this.activites = new String[MAX_ACTIVITES];
        this.incompatibilites = new String[MAX_ACTIVITES][];
        this.activitesParCategorie = new String[MAX_CATEGORIES][MAX_ACTIVITES];
        this.categories = new String[MAX_CATEGORIES];
        this.activiteCount = 0;
        initialiserCategoriesActivites();
    }

    private void initialiserCategoriesActivites() {
        ajouterCategorie("Activités Culinaires", new String[]{
                "Gâteau aux pommes", "Cookie aux chocolats", "Cupcakes aux fraises", "Hamburger maison", "Pizza végétarienne"
        });
        ajouterCategorie("Activités Récréatives", new String[]{
                "Peinture avec les doigts", "Jeux d'eau sensoriels", "Parcours motricité", "Conte interactif", "Atelier pâte à modeler"
        });
        ajouterCategorie("Sorties en Forêt", new String[]{
                "Chasse aux trésors nature", "Construction cabane miniature", "Comptine en plein air", "Parcours sensoriels", "Observation animaux et insectes"
        });
        ajouterCategorie("Sorties Aquatiques", new String[]{
                "Bébé nageur", "Bébé nageur", "Bébé nageur", "Bébé nageur", "Bébé nageur"
        });
    }

    private void ajouterCategorie(String categorie, String[] activitesCategorie) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i] == null) {
                categories[i] = categorie;
                System.arraycopy(activitesCategorie, 0, activitesParCategorie[i], 0, activitesCategorie.length);
                break;
            }
        }
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
            String[] incompatibilitesActivite = donnees[1].split(";");
            ajouterIncompatibilites(activite, incompatibilitesActivite);

            System.out.println("Activité : " + activite + " | Incompatibilités : " + String.join(", ", incompatibilitesActivite));
        }
        reader.close();
    }

    private void ajouterIncompatibilites(String activite, String[] incompatibilitesActivite) {
        for (int i = 0; i < activites.length; i++) {
            if (activites[i] == null) {
                activites[i] = activite;
                incompatibilites[i] = incompatibilitesActivite;
                activiteCount++;
                break;
            }
        }
    }

    public boolean estCompatible(String activite, Enfant enfant) {
        for (int i = 0; i < activiteCount; i++) {
            if (activites[i].equals(activite)) {
                for (String incompatibilite : incompatibilites[i]) {
                    if (estDansTableau(incompatibilite, enfant.getAllergies()) || estDansTableau(incompatibilite, enfant.getProblemesDeSante())) {
                        return false; // Une incompatibilité détectée
                    }
                }
            }
        }
        return true; // Aucune incompatibilité trouvée
    }

    private boolean estDansTableau(String valeur, String[] tableau) {
        for (String element : tableau) {
            if (valeur.equals(element)) {
                return true; // Valeur trouvée dans le tableau
            }
        }
        return false; // Valeur absente du tableau
    }


    public String[] getActivitesParCategorie(String categorie) {
        for (int i = 0; i < categories.length; i++) {
            if (categorie.equals(categories[i])) {
                return activitesParCategorie[i];
            }
        }
        return new String[0];
    }

    public String[] getActivitesCompatiblesParCategorie(String categorie, Enfant enfant) {
        String[] toutesActivites = getActivitesParCategorie(categorie);
        String[] activitesCompatiblesTemp = new String[toutesActivites.length];
        int index = 0;

        for (String activite : toutesActivites) {
            if (activite != null && estCompatible(activite, enfant)) {
                activitesCompatiblesTemp[index++] = activite;
            }
        }

        // Créez un tableau final avec uniquement les activités compatibles
        String[] activitesCompatibles = new String[index];
        System.arraycopy(activitesCompatiblesTemp, 0, activitesCompatibles, 0, index);

        return activitesCompatibles;
    }


    public void afficherIncompatibilites() {
        System.out.println("\n--- Incompatibilités des Activités ---");
        for (int i = 0; i < activiteCount; i++) {
            System.out.println("Activité : " + activites[i]);
            System.out.println("Incompatibilités : " + String.join(", ", incompatibilites[i]));
        }
    }
}
