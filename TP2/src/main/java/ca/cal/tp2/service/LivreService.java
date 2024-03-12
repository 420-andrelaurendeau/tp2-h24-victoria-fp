package ca.cal.tp2.service;

import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.DocumentRepository;

public class LivreService {

    private final DocumentRepository documentRepository;

    public LivreService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public LivreDTO createLivre(String titre, String auteur) {
        if (titre == null || auteur == null)
            throw new NullPointerException("Les paramètres entrés ne peuvent pas être null");
        if (titre.isEmpty() || auteur.isEmpty())
            throw new IllegalArgumentException("Le titre et l'auteur' ne peuvent pas être vides");

        Livre livre = documentRepository.saveLivre(titre, auteur);
        return toDTO(livre);
    }

    private LivreDTO toDTO(Livre livre) {
        LivreDTO livreDTO = new LivreDTO(
                livre.getIdLivre;
                livre.getTitre;
                livre.getAuteur;
        );
        return livreDTO;
    }
}
