package ca.cal.tp2.modele;

import jakarta.persistence.*;

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

    // TODO: ajouter dateEmprunt

    public Emprunt() {

    }

    public Emprunt(List<EmpruntDocument> empruntDocuments) {
        this.empruntDocuments = empruntDocuments;
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
}
