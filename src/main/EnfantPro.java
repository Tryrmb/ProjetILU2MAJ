package main;

import gestion.DataStorage;
import gestion.EnfantController;
import interfaceUtilisateur.BoundaryMenuPrincipal;

import java.io.IOException;

import gestion.CompteController;

public class EnfantPro {
    public static void main(String[] args) {
        // Initialisation du contrôleur d'enfants
        EnfantController enfantController = new EnfantController();

        // Initialisation de DataStorage avec EnfantController
        DataStorage dataStorage = new DataStorage(enfantController);

        // Initialisation du CompteController avec DataStorage
        CompteController compteController = new CompteController(dataStorage);

        // Chargement des données CSV
        try {
            dataStorage.chargerDonneesParentsDepuisCSV("src/ressources/parents_enfants.csv");
            dataStorage.chargerDonneesEducateursDepuisCSV("src/ressources/educateurs_donnees.csv");
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des données : " + e.getMessage());
        }

        // Démarrer le menu principal
        BoundaryMenuPrincipal menu = new BoundaryMenuPrincipal(compteController, enfantController);
        menu.afficherMenuPrincipal();
    }
}