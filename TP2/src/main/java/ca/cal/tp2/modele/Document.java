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
    private String categorie;

    @Column
    private int annee;

    @Column
    private int nbExemplairesRestants;



    public Document() {}

    public Document(String titre, String auteur, String categorie, int annee, int nbExemplairesRestants) {
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.annee = annee;
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

    public String getCategorie() {
        return categorie;
    }

    public int getAnnee() {
        return annee;
    }

    public int getNbExemplairesRestants() {
        return this.nbExemplairesRestants;
    }

    public void setNbExemplairesRestants(int nbExemplairesRestants) {
        this.nbExemplairesRestants = nbExemplairesRestants;
    }
}
