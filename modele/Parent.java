package modele;

public class Parent {
    private String nom;
    private String email;
    private String motDePasse;
    private Enfant[] enfants; // Tableau pour stocker les enfants
    private int nombreEnfants; // Nombre actuel d'enfants dans le tableau

    public Parent(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.enfants = new Enfant[10]; // Taille fixe par défaut
        this.nombreEnfants = 0;
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

    public Enfant[] getEnfants() {
        return enfants;
    }

    public int getNombreEnfants() {
        return nombreEnfants;
    }

    public void ajouterEnfant(Enfant enfant) {
        if (nombreEnfants < enfants.length) {
            enfants[nombreEnfants] = enfant;
            nombreEnfants++;
        } else {
            System.out.println("Impossible d'ajouter l'enfant : tableau plein.");
        }
    }

    public Enfant trouverEnfantParNom(String nomEnfant) {
        for (int i = 0; i < nombreEnfants; i++) {
            if (enfants[i].getNom().equalsIgnoreCase(nomEnfant)) {
                return enfants[i];
            }
        }
        return null;
    }
}
