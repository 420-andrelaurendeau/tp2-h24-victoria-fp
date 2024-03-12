package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.modele.Utilisateur;
import jakarta.persistence.*;

public class UtilisateurRepositoryJPA implements UtilisateurRepository {

    public UtilisateurRepositoryJPA() {

    }

    @Override
    public Client saveClient(String nom, String prenom) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("select prenom, nom from Client where nom=?");
        query.setParameter(1, nom);

        Client client = new Client(nom, prenom);

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
