package modele;

import enumeration.TypeActivite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour ActiviteCulinaire.
 * Teste les fonctionnalités spécifiques aux activités culinaires.
 */
class ActiviteCulinaireTest {

    @Test
    void testCreerActiviteCulinaire() {
        // Création d'une activité culinaire avec les données appropriées
        ActiviteCulinaire activite = new ActiviteCulinaire(
                "Cuisine", 
                "Apprendre à cuisiner un gâteau", 
                "Pâtisserie"
        );

        // Vérifie les valeurs des attributs
        assertEquals("Cuisine", activite.getNom(), "Le nom de l'activité doit être 'Cuisine'.");
        assertEquals("Apprendre à cuisiner un gâteau", activite.getDescription(), "La description doit être correcte.");
        assertEquals("Pâtisserie", activite.getTypeCuisine(), "Le type de cuisine doit être 'Pâtisserie'.");
        assertEquals(TypeActivite.CULINAIRE, activite.getTypeActivite(), "Le type d'activité doit être 'CULINAIRE'.");
    }

    @Test
    void testVerifierCompatibiliteParticipants() {
        // Création d'une activité culinaire
        ActiviteCulinaire activite = new ActiviteCulinaire(
                "Cuisine", 
                "Apprendre à cuisiner un gâteau", 
                "Pâtisserie"
        );

        // Vérifie que la méthode ne lève pas d'exception
        assertDoesNotThrow(activite::verifierCompatibiliteParticipants, 
                "La méthode verifierCompatibiliteParticipants ne doit pas lever d'exception.");
    }

    @Test
    void testGererIncompatibilites() {
        // Création d'une activité culinaire
        ActiviteCulinaire activite = new ActiviteCulinaire(
                "Cuisine", 
                "Apprendre à cuisiner un gâteau", 
                "Pâtisserie"
        );

        // Vérifie que la méthode ne lève pas d'exception
        assertDoesNotThrow(activite::gererIncompatibilites, 
                "La méthode gererIncompatibilites ne doit pas lever d'exception.");
    }
}
