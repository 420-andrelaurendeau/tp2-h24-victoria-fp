package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.modele.Utilisateur;
import jakarta.persistence.*;

public class UtilisateurRepositoryJPA implements UtilisateurRepository {

    public UtilisateurRepositoryJPA() {

    }

    @Override
    public Client saveClient(Client client) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("insert into Utilisateur (nom, prenom) VALUES(?, ?)", Utilisateur.class);
        query.setParameter(1, client.getNom());
        query.setParameter(2, client.getPrenom());

        em.persist(client);
        em.getTransaction().commit();
        em.close();

        return client;
    }


    @Override
    public Utilisateur get(long id) {
        return null;
    }
}
