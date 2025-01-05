package enumeration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TypeActiviteTest {

    @Test
    void testEnumValues() {
        // Vérifie que les valeurs de l'énumération sont correctes
        TypeActivite[] valeurs = TypeActivite.values();
        assertArrayEquals(new TypeActivite[]{
                TypeActivite.CULINAIRE,
                TypeActivite.RECREATIVE,
                TypeActivite.SORTIEFORET,
                TypeActivite.SORTIEAQUATIQUE
        }, valeurs, "Les valeurs de l'énumération ne correspondent pas.");
    }

    @Test
    void testEnumValueOf() {
        // Vérifie que valueOf fonctionne pour chaque élément
        assertEquals(TypeActivite.CULINAIRE, TypeActivite.valueOf("CULINAIRE"));
        assertEquals(TypeActivite.RECREATIVE, TypeActivite.valueOf("RECREATIVE"));
        assertEquals(TypeActivite.SORTIEFORET, TypeActivite.valueOf("SORTIEFORET"));
        assertEquals(TypeActivite.SORTIEAQUATIQUE, TypeActivite.valueOf("SORTIEAQUATIQUE"));
    }

    @Test
    void testEnumToString() {
        // Vérifie que toString renvoie le nom correct
        assertEquals("CULINAIRE", TypeActivite.CULINAIRE.toString());
        assertEquals("RECREATIVE", TypeActivite.RECREATIVE.toString());
        assertEquals("SORTIEFORET", TypeActivite.SORTIEFORET.toString());
        assertEquals("SORTIEAQUATIQUE", TypeActivite.SORTIEAQUATIQUE.toString());
    }

    @Test
    void testEnumInvalidValueOf() {
        // Vérifie qu'une exception est levée pour une valeur invalide
        assertThrows(IllegalArgumentException.class, () -> TypeActivite.valueOf("INVALID"));
    }
}
