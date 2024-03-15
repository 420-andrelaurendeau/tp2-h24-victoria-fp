package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDocument;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class EmpruntRepositoryJPA implements EmpruntRepository {

    public EmpruntRepositoryJPA() {}

    @Override
    public Emprunt saveEmprunt(Client client, LocalDate dateEmprunt) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Emprunt emprunt = new Emprunt(client, dateEmprunt);
        em.persist(emprunt);

        em.getTransaction().commit();
        em.close();

        return emprunt;
    }

    public Emprunt findEmpruntById(Long idEmprunt) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Emprunt empruntTrouve = em.find(Emprunt.class, idEmprunt);

        em.getTransaction().commit();
        em.close();

        return empruntTrouve;
    }

    public EmpruntDocument saveEmpruntDocument(Emprunt emprunt, Document document, LocalDate dateRetourEmprunt) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        EmpruntDocument empruntDocument = new EmpruntDocument(emprunt, document, dateRetourEmprunt);
        em.persist(empruntDocument);

        em.getTransaction().commit();
        em.close();

        return empruntDocument;
    }
}
