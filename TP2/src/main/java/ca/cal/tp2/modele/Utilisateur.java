package ca.cal.tp2.modele;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Utilisateur {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;

    public Utilisateur() {

    }

    public Utilisateur(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
}
