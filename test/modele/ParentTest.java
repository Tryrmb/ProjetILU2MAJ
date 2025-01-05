package modele;

import modele.Parent;
import modele.Enfant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParentTest {

    @Test
    void testAjouterEnfant() {
        Parent parent = new Parent("Marie", "marie@gmail.com", "password");
        Enfant enfant = new Enfant("Alice", new String[]{}, "Vegetarien");
        parent.ajouterEnfant(enfant);
        assertEquals(enfant, parent.getEnfants()[0]);
    }

    @Test
    void testTrouverEnfantParNom() {
        Parent parent = new Parent("Marie", "marie@gmail.com", "password");
        Enfant enfant = new Enfant("Alice", new String[]{}, "Vegetarien");
        parent.ajouterEnfant(enfant);
        Enfant trouvé = parent.trouverEnfantParNom("Alice");
        assertEquals(enfant, trouvé);
    }
}
