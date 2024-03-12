package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Livre;

public interface DocumentRepository {

    public Livre saveLivre(String titre, String auteur);
}
