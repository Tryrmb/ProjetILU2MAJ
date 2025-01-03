package modele;

import java.util.ArrayList;
import java.util.List;

public abstract class Utilisateur {
 private String email;
 private String motDePasse;

 public Utilisateur(String email, String motDePasse) {
     this.email = email;
     this.motDePasse = motDePasse;
 }

 public String getEmail() {
     return email;
 }

 public String getMotDePasse() {
     return motDePasse;
 }

 public abstract String getRole();
}