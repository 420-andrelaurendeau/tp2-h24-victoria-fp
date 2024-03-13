package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Embeddable
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "idEmpruntDocument")
    private List<EmpruntDocument> empruntDocuments;

    public Emprunt() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
