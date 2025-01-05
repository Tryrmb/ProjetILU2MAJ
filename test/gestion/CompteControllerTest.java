package gestion;

import gestion.CompteController;
import gestion.DataStorage;
import gestion.EnfantController;
import modele.Educateur;
import modele.Parent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour CompteController.
 * Teste les fonctionnalités liées à la vérification des identifiants de parents et éducateurs.
 */
class CompteControllerTest {
    private CompteController compteController; // Instance de CompteController à tester
    private DataStorage dataStorage; // Instance de DataStorage utilisée pour stocker les données

    /**
     * Méthode d'initialisation exécutée avant chaque test.
     * Elle permet de configurer un environnement de test propre.
     */
    @BeforeEach
    void setUp() {
        // Initialisation de DataStorage avec un contrôleur d'enfants
        dataStorage = new DataStorage(new EnfantController());

        // Création de l'instance de CompteController
        compteController = new CompteController(dataStorage);

        // Ajout de données simulées dans DataStorage pour les tests
        Parent parent = new Parent("Jean Martin", "jean.martin@enfantpro.fr", "jmg");
        dataStorage.getParents()[0] = parent; // Ajout d'un parent dans le tableau

        Educateur educateur = new Educateur("Medhi Souaki", "medhi.souaki@enfantpro.fr", "ms1");
        dataStorage.getEducateurs()[0] = educateur; // Ajout d'un éducateur dans le tableau
    }

    /**
     * Teste la méthode verifierIdentifiants pour les parents.
     * Vérifie les cas d'authentification réussie et échouée.
     */
    @Test
    void testVerifierIdentifiantsParent() {
        System.out.println("=== Test : Vérification des identifiants parent ===");
        assertTrue(compteController.verifierIdentifiants("jean.martin@enfantpro.fr", "jmg"),
                "Identifiants corrects pour parent devraient être acceptés.");

        assertFalse(compteController.verifierIdentifiants("jean.martin@enfantpro.fr", "yoyo"),
                "Mot de passe incorrect pour parent devrait être rejeté.");

        assertFalse(compteController.verifierIdentifiants("inconnu@enfantpro.com", "yoyo"),
                "Email inconnu pour parent devrait être rejeté.");
    }

    @Test
    void testVerifierIdentifiantsEducateur() {
        System.out.println("=== Test : Vérification des identifiants éducateur ===");
        assertTrue(compteController.verifierIdentifiantsEducateur("medhi.souaki@enfantpro.fr", "ms1"),
                "Identifiants corrects pour éducateur devraient être acceptés.");

        assertFalse(compteController.verifierIdentifiantsEducateur("medhi.souaki@enfantpro.fr", "yeye"),
                "Mot de passe incorrect pour éducateur devrait être rejeté.");

        assertFalse(compteController.verifierIdentifiantsEducateur("inconnu@enfantpro.com", "yeye"),
                "Email inconnu pour éducateur devrait être rejeté.");
    }

}
