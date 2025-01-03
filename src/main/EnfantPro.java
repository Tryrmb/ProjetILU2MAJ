package main;

import gestion.CompteController;
import gestion.DataStorage;
import gestion.EnfantController;
import interfaceUtilisateur.BoundaryMenuPrincipal;

import java.io.IOException;

public class EnfantPro {
    public static void main(String[] args) {
        // Initialisation des contrôleurs et du stockage
        DataStorage dataStorage = new DataStorage();
        CompteController compteController = new CompteController(dataStorage);
        EnfantController enfantController = new EnfantController();

        // Chargement des données depuis les fichiers CSV
        try {
            dataStorage.chargerDonneesParentsDepuisCSV("src/ressources/parents_enfants.csv");
            dataStorage.chargerDonneesEducateursDepuisCSV("src/ressources/educateurs_donnees.csv");
            
            // Afficher les éducateurs chargés
            dataStorage.afficherEducateurs();
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des données : " + e.getMessage());
            return;
        }

        // Initialisation du menu principal
        BoundaryMenuPrincipal menu = new BoundaryMenuPrincipal(compteController, enfantController);
        menu.afficherMenuPrincipal();
    }
}
