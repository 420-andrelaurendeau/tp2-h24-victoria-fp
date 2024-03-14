package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Livre;

public interface DocumentRepository {

    Livre saveLivre(String titre, String auteur, int nbExemplairesRestant, int nbPages);

    Livre findLivreByTitle(String titre);

    void updateLivre(Livre livre);
}
