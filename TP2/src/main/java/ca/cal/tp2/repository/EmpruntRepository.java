package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDocument;

import java.time.LocalDate;

public interface EmpruntRepository {

    Emprunt saveEmprunt(Client client, LocalDate dateEmprunt);

    Emprunt findEmpruntById(Long idEmprunt);

    EmpruntDocument saveEmpruntDocument(Emprunt emprunt, Document document, LocalDate dateRetourEmprunt);
}
