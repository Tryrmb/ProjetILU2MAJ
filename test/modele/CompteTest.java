package modele;

import modele.Compte;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompteTest {

    @Test
    void testCompteCreation() {
        Compte compte = new Compte("jean@gmail.com", "password");
        assertEquals("jean@gmail.com", compte.getEmail(), "L'email doit correspondre.");
        assertEquals("password", compte.getMotDePasse(), "Le mot de passe doit correspondre.");
        assertEquals("Parent", compte.getRole(), "Le rôle doit être 'Parent'.");
    }
}
