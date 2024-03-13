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

    public Document() {}

    public Document(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
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
}
