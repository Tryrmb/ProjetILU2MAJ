package gestion;

// Classe générique
public class AllergieEtRestriction<T> {
    private static final int MAX_RESTRICTIONS = 100; // Taille maximale pour les restrictions

    private T[] typeRestrictions; // Tableau pour les types de restrictions
    private String[] descriptions; // Tableau pour les descriptions
    private int[] niveauxGravite; // Tableau pour les niveaux de gravité
    private String[] actionsPrevention; // Tableau pour les actions préventives
    private int nombreRestrictions; // Nombre actuel de restrictions

    @SuppressWarnings("unchecked")
    public AllergieEtRestriction() {
        this.typeRestrictions = (T[]) new Object[MAX_RESTRICTIONS];
        this.descriptions = new String[MAX_RESTRICTIONS];
        this.niveauxGravite = new int[MAX_RESTRICTIONS];
        this.actionsPrevention = new String[MAX_RESTRICTIONS];
        this.nombreRestrictions = 0;
    }

    // Méthode pour ajouter une restriction
    public void ajouterRestriction(T restriction, String description, int niveau, String action)
            throws RestrictionIncompatibleException {
        if (niveau < 0 || niveau > 10) {
            throw new RestrictionIncompatibleException("Le niveau de gravité doit être compris entre 0 et 10.");
        }
        if (nombreRestrictions >= MAX_RESTRICTIONS) {
            System.out.println("Erreur : Limite maximale de restrictions atteinte.");
            return;
        }
        typeRestrictions[nombreRestrictions] = restriction;
        descriptions[nombreRestrictions] = description;
        niveauxGravite[nombreRestrictions] = niveau;
        actionsPrevention[nombreRestrictions] = action;
        nombreRestrictions++;
    }

    // Méthode pour vérifier la compatibilité
    public boolean verifierCompatibilite(T restriction) {
        for (int i = 0; i < nombreRestrictions; i++) {
            if (typeRestrictions[i].equals(restriction)) {
                return false; // Incompatible si la restriction existe
            }
        }
        return true; // Compatible si aucune restriction trouvée
    }

    // Méthode pour générer une alerte
    public void genererAlerte(int index) {
        if (index >= 0 && index < nombreRestrictions) {
            System.out.println("ALERTE : Restriction détectée !");
            System.out.println("Type : " + typeRestrictions[index]);
            System.out.println("Description : " + descriptions[index]);
            System.out.println("Niveau de gravité : " + niveauxGravite[index]);
            System.out.println("Action préventive : " + actionsPrevention[index]);
        } else {
            System.out.println("Indice invalide pour générer une alerte.");
        }
    }

    // Classe interne pour gérer les notifications
    public class Notification {
        public void envoyerNotification(T restriction) {
            System.out.println("Notification : La restriction \"" + restriction
                    + "\" pourrait poser un problème. Veuillez vérifier.");
        }
    }

    // Méthode pour afficher toutes les restrictions
    public void afficherRestrictions() {
        System.out.println("\n--- Liste des Restrictions ---");
        for (int i = 0; i < nombreRestrictions; i++) {
            System.out.println("Type : " + typeRestrictions[i] + ", Description : " + descriptions[i]
                    + ", Niveau : " + niveauxGravite[i] + ", Action : " + actionsPrevention[i]);
        }
    }
}
