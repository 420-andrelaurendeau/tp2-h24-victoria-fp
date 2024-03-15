package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.modele.Utilisateur;
import jakarta.persistence.*;

import java.util.List;

public class UtilisateurRepositoryJPA implements UtilisateurRepository {

    public UtilisateurRepositoryJPA() {

    }

    @Override
    public Client saveClient(String nom, String prenom) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Client client = new Client(nom, prenom);
        em.persist(client);

        em.getTransaction().commit();
        em.close();

        return client;
    }

    @Override
    public Client findClientById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Client clientTrouve = em.find(Client.class, id);

        /*final Query query = em.createNativeQuery("select idUser, nom, prenom from Utilisateur where idUser = ?");
        query.setParameter(1, id);

        List<Client> resultatQuery = query.getResultList();
        Client clientTrouve = resultatQuery.getFirst();*/

        em.getTransaction().commit();
        em.close();

        return clientTrouve;
    }
}
