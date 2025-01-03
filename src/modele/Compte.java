package modele;

public class Compte extends Utilisateur {
    public Compte(String email, String motDePasse) {
        super(email, motDePasse);
    }

    @Override
    public String getRole() {
        return "Parent";
    }
}
