package gestion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Enfant;

class GestionCompatibilitéTest {

	private GestionnaireIncompatibilité gestionnaireIncompatibilite;

    /**
     * Configuration initiale exécutée avant chaque test.
     */
    @BeforeEach
    void setUp() {
        gestionnaireIncompatibilite = new GestionnaireIncompatibilité();
        // Ajoutez des activités et leurs incompatibilités pour les tests
        gestionnaireIncompatibilite.ajouterIncompatibilites("Natation", new String[]{"Chlore"});
        gestionnaireIncompatibilite.ajouterIncompatibilites("Cuisine", new String[]{"Gluten"});
    }

    /**
     * Teste l'ajout et la vérification des incompatibilités.
     */
    @Test
    void testAjouterEtVerifierIncompatibilites() {
        Enfant enfantCompatible = new Enfant("Gaston", new String[]{"Lactose"}, "Traditionnel");
        Enfant enfantIncompatible = new Enfant("Sophie", new String[]{"Chlore"}, "Végétarien");

        assertTrue(gestionnaireIncompatibilite.estCompatible("Natation", enfantCompatible),
                "L'enfant Gaston devrait être compatible avec l'activité Natation.");
        assertFalse(gestionnaireIncompatibilite.estCompatible("Natation", enfantIncompatible),
                "L'enfant Sophie ne devrait pas être compatible avec l'activité Natation.");
    }

    /**
     * Teste la récupération des activités compatibles par catégorie.
     */
    @Test
    void testGetActivitesCompatibles() {
        Enfant enfant = new Enfant("Gaston", new String[]{"Chlore"}, "Traditionnel");
        String[] compatibles = gestionnaireIncompatibilite.getActivitesCompatiblesParCategorie("Sorties Aquatiques", enfant);

        assertNotNull(compatibles, "La liste des activités compatibles ne doit pas être nulle.");
        assertTrue(compatibles.length > 0, "Il devrait y avoir des activités compatibles pour l'enfant.");
    }
}
