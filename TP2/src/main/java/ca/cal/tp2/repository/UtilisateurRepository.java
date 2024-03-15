package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Client;

public interface UtilisateurRepository {
    Client saveClient(String nom, String prenom);

    Client findClientById(Long id);
}
