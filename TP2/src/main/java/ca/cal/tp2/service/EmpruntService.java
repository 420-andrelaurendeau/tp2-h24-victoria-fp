package ca.cal.tp2.service;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDocument;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final DocumentRepository documentRepository;

    public EmpruntService(EmpruntRepository empruntRepository, DocumentRepository documentRepository) {
        this.empruntRepository = empruntRepository;
        this.documentRepository = documentRepository;
    }

    public EmpruntDTO createEmprunt(List<EmpruntDocument> empruntDocuments) {
        if (empruntDocuments == null)
            throw new NullPointerException("La liste d'emprunt de documents ne peut pas être nulle");

        Emprunt emprunt = empruntRepository.saveEmprunt(empruntDocuments);
        return empruntToDTO(emprunt);
    }

    public EmpruntDocumentDTO createEmpruntDocumentLivre(EmpruntDTO empruntDTO, LivreDTO livreDTO) {
        if (empruntDTO == null || livreDTO == null)
            throw new NullPointerException("Les paramètres entrés ne peuvent pas être null");

        int exemplairesRestants = documentRepository.nbExemplairesRestants(livreDTO.id());

        if (exemplairesRestants == 0)
            throw new NullPointerException("Aucun exemplaire restant pour " + livreDTO.titre());

        Emprunt emprunt = empruntRepository.findEmpruntById(empruntDTO.id());
        Livre livre = documentRepository.findLivreByTitle(livreDTO.titre());
        LocalDate dateEmprunt = emprunt.getDateEmprunt();
        LocalDate dateRetourEmprunt = dateEmprunt.plusWeeks(3);

        livre.setNbExemplairesRestants(exemplairesRestants--);
        documentRepository.updateLivre(livre);

        EmpruntDocument empruntDocument = empruntRepository.saveEmpruntDocument(emprunt, livre, dateRetourEmprunt);
        return empruntDocumenToDTO(empruntDocument);
    }

    private EmpruntDTO empruntToDTO(Emprunt emprunt) {
        EmpruntDTO empruntDTO = new EmpruntDTO(
                emprunt.getIdEmprunt(),
                emprunt.getEmpruntDocuments()
        );
        return empruntDTO;
    }

    private EmpruntDocumentDTO empruntDocumenToDTO(EmpruntDocument empruntDocument) {
        EmpruntDocumentDTO empruntDocumentDTO = new EmpruntDocumentDTO(
                empruntDocument.getIdEmpruntDocument(),
                empruntDocument.getEmprunt(),
                empruntDocument.getDocument(),
                empruntDocument.getDateRetour()
        );
        return empruntDocumentDTO;
    }
}
