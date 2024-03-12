package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.modele.Prepose;
import ca.cal.tp2.modele.Utilisateur;

public interface UtilisateurRepository {
    Client saveClient(Client client);
    /*Prepose savePrepose(Prepose client);*/

    Utilisateur get(long id);
}
