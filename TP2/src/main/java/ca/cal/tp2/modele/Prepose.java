package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("prepose")
public class Prepose extends Utilisateur {
    public Prepose() {}

    public Prepose(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }
}
