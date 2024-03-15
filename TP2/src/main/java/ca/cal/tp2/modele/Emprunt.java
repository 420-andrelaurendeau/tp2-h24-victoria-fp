package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Embeddable
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idEmprunt;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Client client;

    @Column
    private LocalDate dateEmprunt;

    public Emprunt() {

    }

    public Emprunt(Client client, LocalDate dateEmprunt) {
        this.client = client;
        this.dateEmprunt = dateEmprunt;
    }

    public Long getIdEmprunt() {
        return idEmprunt;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public Client getClient() {
        return client;
    }
}
