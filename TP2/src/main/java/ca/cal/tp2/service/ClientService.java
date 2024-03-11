package ca.cal.tp2.service;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.repository.ClientRepository;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO createClient(Long id, String nom, String prenom) {
        if (id == null || nom == null || prenom == null)
            throw new NullPointerException("Les paramètres entrés ne peuvent pas être null");
        if (nom.isEmpty() || prenom.isEmpty())
            throw new IllegalArgumentException("Le nom et le prénom ne peuvent pas être vides");

        Client client = new Client(id, nom, prenom);
        clientRepository.save(client);
        return toDTO(client);
    }


}
