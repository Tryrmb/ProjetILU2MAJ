package modele;

import modele.Enfant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnfantTest {

    @Test
    void testAjouterAllergie() {
        Enfant enfant = new Enfant("Alice", new String[]{}, "Vegetarien");
        enfant.ajouterAllergie("Lactose");
        assertArrayEquals(new String[]{"Lactose"}, enfant.getAllergies());
    }

    @Test
    void testSupprimerAllergie() {
        Enfant enfant = new Enfant("Alice", new String[]{"Lactose"}, "Vegetarien");
        boolean supprimé = enfant.supprimerAllergie("Lactose");
        assertTrue(supprimé);
        assertNull(enfant.getAllergies()[0]);
    }

    @Test
    void testAjouterActivite() {
        Enfant enfant = new Enfant("Alice", new String[]{}, "Vegetarien");
        enfant.ajouterActivite("Natation");
        assertArrayEquals(new String[]{"Natation"}, enfant.getActivites());
    }

    @Test
    void testAjouterProblemeDeSante() {
        Enfant enfant = new Enfant("Alice", new String[]{}, "Vegetarien");
        enfant.ajouterProblemeDeSante("Asthme");
        assertArrayEquals(new String[]{"Asthme"}, enfant.getProblemesDeSante());
    }

    @Test
    void testSetBilan() {
        Enfant enfant = new Enfant("Alice", new String[]{}, "Vegetarien");
        enfant.setBilan("Très bien");
        assertEquals("Très bien", enfant.getBilan());
    }
}
