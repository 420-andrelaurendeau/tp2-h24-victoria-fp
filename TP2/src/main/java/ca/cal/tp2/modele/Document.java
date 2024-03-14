package ca.cal.tp2.modele;

import jakarta.persistence.*;


@Entity
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idDocument;

    @Column
    private String titre;

    @Column
    private String auteur;

    @Column
    private int nbExemplairesRestants;

    public Document() {}

    public Document(String titre, String auteur, int nbExemplairesRestants) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbExemplairesRestants = nbExemplairesRestants;
    }

    public Long getIdDocument() {
        return this.idDocument;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public int getNbExemplairesRestants() {
        return this.nbExemplairesRestants;
    }

    public void setNbExemplairesRestants(int nbExemplairesRestants) {
        this.nbExemplairesRestants = nbExemplairesRestants;
    }
}
