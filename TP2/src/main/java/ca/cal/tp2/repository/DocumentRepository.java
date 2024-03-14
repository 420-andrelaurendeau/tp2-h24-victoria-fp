package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Livre;

public interface DocumentRepository {

    Livre saveLivre(String titre, String auteur, String categorie, int annee, int nbExemplairesRestants, int nbPages);

    void updateLivre(Livre livre);

    Livre findLivreByTitre(String titre);

    Livre findLivreByAuteur(String auteur);

    Livre findLivreByCategorie(String categorie);

    Livre findLivreByAnnee(int annee);

    int getNbExemplairesRestants(Long id);
}
