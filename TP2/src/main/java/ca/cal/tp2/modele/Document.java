package ca.cal.tp2.modele;

import jakarta.persistence.*;

@Entity
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
}
