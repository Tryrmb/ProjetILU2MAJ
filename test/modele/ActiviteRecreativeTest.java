package modele;

import modele.ActiviteRecreative;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActiviteRecreativeTest {

    @Test
    void testCreerActiviteRecreative() {
        // Création d'une activité récréative avec un type de lieu
        ActiviteRecreative activite = new ActiviteRecreative(
                "Danse", 
                "Apprendre les pas de danse basiques", 
                "Salle de sport"
        );

        // Vérifie que les attributs sont correctement initialisés
        assertEquals("Danse", activite.getNom(), "Le nom de l'activité doit être 'Danse'.");
        assertEquals("Apprendre les pas de danse basiques", activite.getDescription(), "La description doit être correcte.");
        assertEquals("Salle de sport", activite.getTypeLieu(), "Le type de lieu doit être 'Salle de sport'.");
    }
}
