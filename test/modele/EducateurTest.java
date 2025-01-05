package modele;

import modele.Educateur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EducateurTest {

    @Test
    void testEducateurCreation() {
        Educateur educateur = new Educateur("Paul", "paul@gmail.com", "password");
        assertEquals("Paul", educateur.getNom());
        assertEquals("paul@gmail.com", educateur.getEmail());
        assertEquals("password", educateur.getMotDePasse());
    }
}
