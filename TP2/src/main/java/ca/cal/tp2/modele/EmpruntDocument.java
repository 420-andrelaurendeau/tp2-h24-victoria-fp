package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Embeddable
public class EmpruntDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idEmpruntDocument;

    @ManyToOne
    @JoinColumn(name = "id_document")
    private Document document;

    @Column
    private Date dateRetour;

    public EmpruntDocument() {}

    public EmpruntDocument(Document document, Date dateRetour) {
        this.document = document;
        this.dateRetour = dateRetour;
    }

    public Long getIdEmpruntDocument() {
        return idEmpruntDocument;
    }

    public void setIdEmpruntDocument(Long idEmpruntDocument) {
        this.idEmpruntDocument = idEmpruntDocument;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }
}
