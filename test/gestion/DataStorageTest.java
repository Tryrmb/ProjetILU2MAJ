package gestion;

import gestion.DataStorage;
import gestion.EnfantController;
import modele.Enfant;
import modele.Educateur;
import modele.Parent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataStorageTest {
    private DataStorage dataStorage;
    private EnfantController enfantController;

    @BeforeEach
    void setUp() {
        enfantController = new EnfantController();
        dataStorage = new DataStorage(enfantController);
    }

    @Test
    void testAjouterEtTrouverParent() {
        Parent parent = new Parent("Jean Dupont", "jean.dupont@mail.com", "password123");
        dataStorage.getParents()[0] = parent;

        assertEquals(parent, dataStorage.trouverParentParEmail("jean.dupont@mail.com"));
        assertNull(dataStorage.trouverParentParEmail("inconnu@mail.com"));
    }

    @Test
    void testAjouterEtTrouverEducateur() {
        Educateur educateur = new Educateur("Marie", "marie@mail.com", "educ123");
        dataStorage.getEducateurs()[0] = educateur;

        assertEquals(educateur, dataStorage.trouverEducateurParEmail("marie@mail.com"));
        assertNull(dataStorage.trouverEducateurParEmail("inconnu@mail.com"));
    }

    @Test
    void testAjouterEnfantEtTrouver() {
        Parent parent = new Parent("Jean Dupont", "jean.dupont@mail.com", "password123");
        Enfant enfant = new Enfant("Gaston", new String[]{"Lactose"}, "Traditionnel");
        parent.ajouterEnfant(enfant);

        dataStorage.getParents()[0] = parent;
        assertEquals(enfant, dataStorage.trouverEnfantParNom("Gaston"));
        assertNull(dataStorage.trouverEnfantParNom("Inconnu"));
    }

    @Test
    void testAfficherParents() {
        Parent parent1 = new Parent("Jean Dupont", "jean.dupont@mail.com", "password123");
        Parent parent2 = new Parent("Marie Curie", "marie.curie@mail.com", "securepassword");

        dataStorage.getParents()[0] = parent1;
        dataStorage.getParents()[1] = parent2;

        assertNotNull(dataStorage.getParents());
    }
}
