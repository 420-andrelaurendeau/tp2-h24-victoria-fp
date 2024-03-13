package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Embeddable
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idEmprunt;

    @OneToMany
    private List<EmpruntDocument> empruntDocuments;

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
