package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("client")
public class Client extends Utilisateur {

    @OneToMany
    private List<Emprunt> emprunts;

    public Client() {}

    public Client(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public Long getIdUser() {
        return super.getIdUser();
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
