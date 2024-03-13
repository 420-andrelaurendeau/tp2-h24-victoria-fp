package ca.cal.tp2.modele;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("livre")
public class Livre extends Document {

    @Column
    private int nbPages;

    public Livre() {}

    public Livre(String titre, String auteur, int nbPages) {
        super(titre, auteur);
        this.nbPages = nbPages;
    }

    @Override
    public Long getIdDocument() {
        return super.getIdDocument();
    }

    @Override
    public String getTitre() {
        return super.getTitre();
    }

    @Override
    public String getAuteur() {
        return super.getAuteur();
    }

    public int getNbPages() {
        return this.nbPages;
    }
}
