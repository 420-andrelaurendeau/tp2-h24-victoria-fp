package ca.cal.tp2.service;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDocument;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.EmpruntRepository;
import ca.cal.tp2.repository.UtilisateurRepository;
import ca.cal.tp2.repository.UtilisateurRepositoryJPA;

import java.time.LocalDate;
import java.util.List;

public class EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final DocumentRepository documentRepository;
    private final UtilisateurRepository utilisateurRepository;

    public EmpruntService(EmpruntRepository empruntRepository,
                          DocumentRepository documentRepository,
                          UtilisateurRepository utilisateurRepository)
    {
        this.empruntRepository = empruntRepository;
        this.documentRepository = documentRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public EmpruntDTO createEmprunt(ClientDTO clientDTO, LocalDate dateEmprunt) {
        if (clientDTO == null || dateEmprunt == null)
            throw new NullPointerException("Les paramètres entrés ne peuvent pas être null");

        Client client = utilisateurRepository.findClientById(clientDTO.idUser());
        Emprunt emprunt = empruntRepository.saveEmprunt(client, dateEmprunt);
        return empruntToDTO(emprunt);
    }

    public EmpruntDocumentDTO createEmpruntDocumentLivre(EmpruntDTO empruntDTO, LivreDTO livreDTO) {
        if (empruntDTO == null || livreDTO == null)
            throw new NullPointerException("Les paramètres entrés ne peuvent pas être null");

        int exemplairesRestants = documentRepository.getNbExemplairesRestants(livreDTO.idDocument());
        if (exemplairesRestants == 0)
            throw new NullPointerException("Aucun exemplaire restant pour " + livreDTO.titre());

        Emprunt emprunt = empruntRepository.findEmpruntById(empruntDTO.id());
        List<Livre> listeLivres = documentRepository.findLivreByTitre(livreDTO.titre());
        Livre livre = listeLivres.getFirst();
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
                emprunt.getClient(),
                emprunt.getDateEmprunt()
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
