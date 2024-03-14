package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDocument;

import java.time.LocalDate;
import java.util.List;

public interface EmpruntRepository {

    Emprunt saveEmprunt(List<EmpruntDocument> empruntDocuments, LocalDate dateEmprunt);

    Emprunt findEmpruntById(Long idEmprunt);

    EmpruntDocument saveEmpruntDocument(Emprunt emprunt, Document document, LocalDate dateRetourEmprunt);
}
