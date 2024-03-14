package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDocument;

import java.util.List;

public interface EmpruntRepository {

    Emprunt saveEmprunt(List<EmpruntDocument> empruntDocuments);

    Emprunt findEmpruntById(Long idEmprunt);
}
