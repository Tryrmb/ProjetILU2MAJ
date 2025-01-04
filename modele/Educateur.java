package modele;

public class Educateur {
    private String nom;
    private String email;
    private String motDePasse;

    // Constructeur
    public Educateur(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    // Méthode pour vérifier l'identité de l'éducateur
    public boolean verifierIdentite(String email, String motDePasse) {
        return this.email.equals(email) && this.motDePasse.equals(motDePasse);
    }

    @Override
    public String toString() {
        return "Educateur{" +
                "nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
