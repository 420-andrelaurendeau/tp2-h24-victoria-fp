package ca.cal.tp2.service;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.repository.UtilisateurRepository;

public class ClientService {
    private final UtilisateurRepository utilisateurRepository;

    public ClientService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public ClientDTO createClient(String nom, String prenom) {
        if (nom == null || prenom == null)
            throw new NullPointerException("Les paramètres entrés ne peuvent pas être null");
        if (nom.isEmpty() || prenom.isEmpty())
            throw new IllegalArgumentException("Le nom et le prénom ne peuvent pas être vides");

        Client client = new Client(nom, prenom);
        utilisateurRepository.saveClient(client);
        return toDTO(client);
    }

    private ClientDTO toDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO(
                client.getId(),
                client.getNom(),
                client.getPrenom()
        );
        return clientDTO;
    }
}
