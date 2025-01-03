package modele;

import java.util.ArrayList;
import java.util.List;

public class Parent {
    private String nom;
    private String email;
    private String motDePasse;
    private List<Enfant> enfants;

    public Parent(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.enfants = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public List<Enfant> getEnfants() {
        return enfants;
    }

    public void ajouterEnfant(Enfant enfant) {
        enfants.add(enfant);
    }

    // Recherche un enfant par son nom
    public Enfant trouverEnfantParNom(String nomEnfant) {
        for (Enfant enfant : enfants) {
            if (enfant.getNom().equalsIgnoreCase(nomEnfant)) {
                return enfant;
            }
        }
        return null;
    }
}
