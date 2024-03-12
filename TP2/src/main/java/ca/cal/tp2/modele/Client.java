package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("client")
public class Client extends Utilisateur {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idClient;*/

    @OneToMany(mappedBy = "emprunts")
    @CollectionTable
    private List<Emprunt> emprunts;

    public Client() {}

    public Client(String nom, String prenom) {
        super(nom, prenom);
    }

    /*public Long getIdClient() {
        return idClient;
    }*/

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
}
