package gestion;

import modele.Parent;
import modele.Enfant;
import modele.Educateur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataStorage {
    private static final int MAX_PARENTS = 100;
    private static final int MAX_EDUCATEURS = 50;

    private Parent[] parents = new Parent[MAX_PARENTS];
    private Educateur[] educateurs = new Educateur[MAX_EDUCATEURS];
    private int parentCount = 0;
    private int educateurCount = 0;
    private EnfantController enfantController;

    public DataStorage(EnfantController enfantController) {
        this.enfantController = enfantController;
    }

    // Charger les données des parents depuis un fichier CSV
    public void chargerDonneesParentsDepuisCSV(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String ligne;
        boolean isFirstLine = true;

        while ((ligne = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            try {
                String[] donnees = ligne.split(",");
                if (donnees.length < 13) {
                    System.err.println("Ligne ignorée : nombre insuffisant de colonnes -> " + ligne);
                    continue;
                }

                String nomParent = donnees[1].trim();
                String emailParent = donnees[2].trim();
                String motDePasse = donnees[12].trim();
                String nomEnfant = donnees[3].trim();

                String[] allergiesArray = {
                        donnees[4].trim(), donnees[5].trim(), donnees[6].trim(), donnees[7].trim()
                };
                String regimeAlimentaire = donnees[8].trim();
                String problemeDeSante = donnees[9].trim();

                Parent parent = trouverParentParEmail(emailParent);
                if (parent == null) {
                    if (parentCount < MAX_PARENTS) {
                        parent = new Parent(nomParent, emailParent, motDePasse);
                        parents[parentCount++] = parent;
                    } else {
                        System.err.println("Erreur : Limite de parents atteinte.");
                        continue;
                    }
                }

                Enfant enfant = new Enfant(nomEnfant, allergiesArray, regimeAlimentaire);
                enfant.ajouterProblemeDeSante(problemeDeSante);
                parent.ajouterEnfant(enfant);

                if (enfantController != null) {
                    enfantController.ajouterEnfant(enfant);
                }
            } catch (Exception e) {
                System.err.println("Erreur lors du traitement de la ligne : " + ligne);
                System.err.println("Cause : " + e.getMessage());
            }
        }
        reader.close();
    }

    public void chargerDonneesEducateursDepuisCSV(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String ligne;
        boolean isFirstLine = true;

        while ((ligne = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            try {
                String[] donnees = ligne.split(",");
                if (donnees.length < 4) {
                    System.err.println("Ligne ignorée : nombre insuffisant de colonnes -> " + ligne);
                    continue;
                }

                String nomEducateur = donnees[1].trim();
                String emailEducateur = donnees[2].trim();
                String motDePasse = donnees[3].trim();

                if (educateurCount < MAX_EDUCATEURS) {
                    Educateur educateur = new Educateur(nomEducateur, emailEducateur, motDePasse);
                    educateurs[educateurCount++] = educateur;
                } else {
                    System.err.println("Erreur : Limite d'éducateurs atteinte.");
                }
            } catch (Exception e) {
                System.err.println("Erreur lors du traitement de la ligne : " + ligne);
                System.err.println("Cause : " + e.getMessage());
            }
        }
        reader.close();
    }

    public Parent trouverParentParEmail(String email) {
        for (int i = 0; i < parentCount; i++) {
            if (parents[i].getEmail().equals(email)) {
                return parents[i];
            }
        }
        return null;
    }

    public Educateur trouverEducateurParEmail(String email) {
        for (int i = 0; i < educateurCount; i++) {
            if (educateurs[i].getEmail().equals(email)) {
                return educateurs[i];
            }
        }
        return null;
    }

    public Parent[] getParents() {
        return parents;
    }

    public Educateur[] getEducateurs() {
        return educateurs;
    }

    public void afficherParents() {
        System.out.println("\nListe des parents :");
        for (int i = 0; i < parentCount; i++) {
            System.out.println("- Nom : " + parents[i].getNom() + ", Email : " + parents[i].getEmail() + ", Mot de passe : " + parents[i].getMotDePasse());
        }
    }

    public void afficherEducateurs() {
        System.out.println("\nListe des éducateurs :");
        for (int i = 0; i < educateurCount; i++) {
            System.out.println("- Nom : " + educateurs[i].getNom() + ", Email : " + educateurs[i].getEmail() + ", Mot de passe : " + educateurs[i].getMotDePasse());
        }
    }
}

