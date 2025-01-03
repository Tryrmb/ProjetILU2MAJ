package gestion;

import java.util.ArrayList;
import java.util.List;


// Classe générique
public class AllergieEtRestriction<T> {
    private List<T> typeRestrictions = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();
    private List<Integer> niveauxGravite = new ArrayList<>();
    private List<String> actionsPrevention = new ArrayList<>();

    // Méthode pour ajouter une restriction
    public void ajouterRestriction(T restriction, String description, int niveau, String action)
            throws RestrictionIncompatibleException {
        if (niveau < 0 || niveau > 10) {
            throw new RestrictionIncompatibleException("Le niveau de gravité doit être compris entre 0 et 10.");
        }
        typeRestrictions.add(restriction);
        descriptions.add(description);
        niveauxGravite.add(niveau);
        actionsPrevention.add(action);
    }

    // Méthode pour vérifier la compatibilité
    public boolean verifierCompatibilite(T restriction) {
        return !typeRestrictions.contains(restriction);
    }

    // Méthode pour générer une alerte
    public void genererAlerte(int index) {
        if (index >= 0 && index < typeRestrictions.size()) {
            System.out.println("ALERTE : Restriction détectée !");
            System.out.println("Type : " + typeRestrictions.get(index));
            System.out.println("Description : " + descriptions.get(index));
            System.out.println("Niveau de gravité : " + niveauxGravite.get(index));
            System.out.println("Action préventive : " + actionsPrevention.get(index));
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
}