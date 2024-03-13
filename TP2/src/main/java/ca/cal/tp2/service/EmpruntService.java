package ca.cal.tp2.service;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDocument;
import ca.cal.tp2.repository.EmpruntRepository;

import java.util.List;

public class EmpruntService {

    private final EmpruntRepository empruntRepository;

    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public EmpruntDTO createEmprunt(List<EmpruntDocument> empruntDocuments) {
        if (empruntDocuments == null)
            throw new NullPointerException("La liste d'emprunt de documents ne peut pas être nulle");

        Emprunt emprunt = empruntRepository.saveEmprunt(empruntDocuments);
        return toDTO(emprunt);
    }

    private EmpruntDTO toDTO(Emprunt emprunt) {
        EmpruntDTO empruntDTO = new EmpruntDTO(
                emprunt.getIdEmprunt(),
                emprunt.getEmpruntDocuments()
        );
        return empruntDTO;
    }
}