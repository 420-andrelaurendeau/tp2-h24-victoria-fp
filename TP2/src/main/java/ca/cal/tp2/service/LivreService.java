package ca.cal.tp2.service;

import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.DocumentRepository;

public class LivreService {

    private final DocumentRepository documentRepository;

    public LivreService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public LivreDTO createLivre(String titre, String auteur, int nbExemplairesRestants, int nbPages) {
        if (titre == null || auteur == null)
            throw new NullPointerException("Les paramètres entrés ne peuvent pas être null");
        if (titre.isEmpty() || auteur.isEmpty())
            throw new IllegalArgumentException("Le titre et l'auteur' ne peuvent pas être vides");

        Livre livre = documentRepository.saveLivre(titre, auteur, nbExemplairesRestants, nbPages);
        return toDTO(livre);
    }

    public LivreDTO findLivreByTitre(String titre) {
        if (titre == null || titre.isEmpty())
            throw new NullPointerException("Le titre ne peut pas être null ni vide");

        Livre livre = documentRepository.findLivreByTitre(titre);
        return toDTO(livre);
    }

    public LivreDTO findLivreByAuteur(String auteur) {
        if (auteur == null || auteur.isEmpty())
            throw new NullPointerException("Le nom de l'auteur ne peut pas être null ni vide");

        Livre livre = documentRepository.findLivreByAuteur(auteur);
        return toDTO(livre);
    }

    public LivreDTO findLivreByCategorie(String categorie) {
        if (categorie == null || categorie.isEmpty())
            throw new NullPointerException("Le nom de la catégorie ne peut pas être null ni vide");

        Livre livre = documentRepository.findLivreByAuteur(categorie);
        return toDTO(livre);
    }

    public LivreDTO findLivreByAnnee(int annee) {
        if (annee < 0 || annee > 2024)
            throw new IndexOutOfBoundsException("Entrez une année valide");

        Livre livre = documentRepository.findLivreByAnnee(annee);
        return toDTO(livre);
    }

    private LivreDTO toDTO(Livre livre) {
        LivreDTO livreDTO = new LivreDTO(
                livre.getIdDocument(),
                livre.getTitre(),
                livre.getAuteur(),
                livre.getNbExemplairesRestants(),
                livre.getNbPages()
        );
        return livreDTO;
    }
}
