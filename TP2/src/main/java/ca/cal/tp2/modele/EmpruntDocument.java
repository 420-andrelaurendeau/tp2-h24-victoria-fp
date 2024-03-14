package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Embeddable
public class EmpruntDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idEmpruntDocument;

    @ManyToOne
    @JoinColumn(name = "idDocument")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "idEmprunt")
    private Emprunt emprunt;

    @Column
    private LocalDate dateRetour;

    public EmpruntDocument() {}

    public EmpruntDocument(Emprunt emprunt, Document document, LocalDate dateRetour) {
        this.emprunt = emprunt;
        this.document = document;
        this.dateRetour = dateRetour;
    }

    public Long getIdEmpruntDocument() {
        return idEmpruntDocument;
    }

    public void setIdEmpruntDocument(Long idEmpruntDocument) {
        this.idEmpruntDocument = idEmpruntDocument;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }
}
