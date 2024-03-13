package ca.cal.tp2.modele;

import jakarta.persistence.*;

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
}
