package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Livre;

public interface DocumentRepository {

    Livre saveLivre(String titre, String auteur, int nbExemplairesRestant, int nbPages);

    void updateLivre(Livre livre);

    Livre findLivreByTitle(String titre);

    Livre findLivreByAuteur(String auteur);

    Livre findLivreByCategorie(String categorie);

    Livre findLivreByTitle(int annee);

    int getNbExemplairesRestants(Long id);
}
