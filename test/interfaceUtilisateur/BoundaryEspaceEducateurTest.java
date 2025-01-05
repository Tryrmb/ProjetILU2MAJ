package interfaceUtilisateur;


import gestion.ActiviteController;
import modele.Activite;

import gestion.CompteController;
import gestion.DataStorage;
import gestion.EnfantController;
import modele.Educateur;
import modele.Parent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour BoundaryEspaceEducateur.
 * Teste les fonctionnalités du menu éducateur.
 */
class BoundaryEspaceEducateurTest {
    private DataStorage dataStorage;
    private CompteController compteController;
    private EnfantController enfantController;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        // Initialisation des contrôleurs et du stockage de données
        enfantController = new EnfantController();
        dataStorage = new DataStorage(enfantController);
        compteController = new CompteController(dataStorage);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Ajouter des données de test
        Parent parent = new Parent("Jean Dupont", "jean.dupont@mail.com", "password123");
        Educateur educateur = new Educateur("Marie Curie", "marie.curie@mail.com", "educ123");
        dataStorage.getParents()[0] = parent;
        dataStorage.getEducateurs()[0] = educateur;
    }

    @Test
    void testAfficherMenuEducateur() {
        // Simulation des entrées utilisateur
        String simulatedInput = "1\n0\n"; // Par exemple, choisir Gérer les activités, puis Retour
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Initialisation
        Educateur educateur = dataStorage.trouverEducateurParEmail("marie.curie@mail.com");
        assertNotNull(educateur, "L'éducateur doit exister dans le système.");

        BoundaryEspaceEducateur boundaryEspaceEducateur = new BoundaryEspaceEducateur(
                "marie.curie@mail.com", compteController, enfantController, null
        );

        // Appel de la méthode
        boundaryEspaceEducateur.afficherMenuEducateur();

        // Vérification des sorties
        String output = outputStream.toString();
        System.out.println("Output actuel : " + output);
        assertTrue(output.contains("--- Menu Éducateur ---"), "Le menu éducateur doit s'afficher.");
        assertTrue(output.contains("Gérer les activités"), "L'option pour gérer les activités doit être présente.");
    }


    
    @Test
    void testAfficherGestionActivites() {
        // Initialisation
        Scanner scanner = new Scanner("1\nJean\nNatation\nPiscine pour enfants\n2\nJean\n0\n"); // Simule les choix utilisateur
        ActiviteController<Activite> activiteController = new ActiviteController<>();
        BoundaryGestionActivitesIU gestionActivitesIU = new BoundaryGestionActivitesIU(scanner, activiteController);

        // Appel de la méthode
        gestionActivitesIU.gererActivites();

        // Vérification des sorties
        String output = outputStream.toString();
        System.out.println("Output actuel : " + output);
        assertTrue(output.contains("--- Gestion des Activités ---"), "Le menu de gestion des activités doit s'afficher.");
        assertTrue(output.contains("Ajouter une activité"), "L'option pour ajouter une activité doit être présente.");
        assertTrue(output.contains("Afficher les activités d'un enfant"), "L'option pour afficher les activités doit être présente.");
        assertTrue(output.contains("Retour au menu principal"), "L'option pour retourner doit être présente.");
    }



    @Test
    void testAfficherMenuParent() {
        // Vérifie qu'un parent peut accéder à son menu
        Parent parent = dataStorage.trouverParentParEmail("jean.dupont@mail.com");
        assertNotNull(parent, "Le parent doit exister dans le système.");

        // Simuler une entrée utilisateur : choix de menu
        String simulatedInput = "1\n0\n"; // Voir les activités des enfants, puis Retour
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        BoundaryEspaceParent boundaryEspaceParent = new BoundaryEspaceParent(
                "jean.dupont@mail.com", compteController, enfantController
        );
        boundaryEspaceParent.afficherMenuParent();

        String output = outputStream.toString();
        assertTrue(output.contains("--- Menu Parent ---"), "Le menu parent doit s'afficher.");
        assertTrue(output.contains("Voir les activités des enfants"), "L'option pour voir les activités doit être présente.");
        assertTrue(output.contains("Retour au menu principal"), "L'option pour retourner au menu principal doit être présente.");
    }
}

