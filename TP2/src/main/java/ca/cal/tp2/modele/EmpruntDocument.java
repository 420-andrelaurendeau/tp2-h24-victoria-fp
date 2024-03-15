package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public Document getDocument() {
        return this.document;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

}
