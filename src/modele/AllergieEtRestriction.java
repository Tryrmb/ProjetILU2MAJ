package modele;

public class AllergieEtRestriction {
    private String type;
    private String details;

    // Constructeur
    public AllergieEtRestriction(String type, String details) {
        this.type = type;
        this.details = details;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }

    // Classe interne : Notification
    public class Notification {
        private String message;
        private String typeNotification;

        // Méthode pour créer une notification
        public void creerNotification(String message, String type) {
            this.message = message;
            this.typeNotification = type;
        }

        // Méthode pour envoyer la notification
        public void envoyerNotification() {
            System.out.println("Notification [" + typeNotification + "]: " + message);
        }
    }
}