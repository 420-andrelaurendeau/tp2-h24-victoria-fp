package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Embeddable
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idEmprunt;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL)
    private List<EmpruntDocument> empruntDocuments = new ArrayList<>();

    @Column
    private LocalDate dateEmprunt;

    public Emprunt() {

    }

    public Emprunt(List<EmpruntDocument> empruntDocuments, LocalDate dateEmprunt) {
        this.empruntDocuments = empruntDocuments;
        this.dateEmprunt = dateEmprunt;
    }

    public void setIdEmprunt(Long idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    public Long getIdEmprunt() {
        return idEmprunt;
    }

    public List<EmpruntDocument> getEmpruntDocuments() {
        return empruntDocuments;
    }

    public void setEmpruntDocuments(List<EmpruntDocument> empruntDocuments) {
        this.empruntDocuments = empruntDocuments;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }
}
