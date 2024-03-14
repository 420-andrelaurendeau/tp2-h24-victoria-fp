package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDocument;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.time.LocalDate;
import java.util.List;

public class EmpruntRepositoryJPA implements EmpruntRepository {

    public EmpruntRepositoryJPA() {}

    @Override
    public Emprunt saveEmprunt(List<EmpruntDocument> empruntDocuments) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("select * from Emprunt where empruntDocuments=?");
        query.setParameter(1, empruntDocuments);

        Emprunt emprunt = new Emprunt(empruntDocuments);

        em.persist(emprunt);
        em.getTransaction().commit();
        em.close();

        return emprunt;
    }

    public Emprunt findEmpruntById(Long idEmprunt) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("select emprunt from Emprunt where idEmprunt=?");
        query.setParameter(1, idEmprunt);

        List<Emprunt> resultatQuery = query.getResultList();
        Emprunt empruntTrouve = resultatQuery.getFirst();

        em.getTransaction().commit();
        em.close();

        return empruntTrouve;
    }

    public EmpruntDocument saveEmpruntDocument(Emprunt emprunt, Document document, LocalDate dateRetourEmprunt) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery(
                "select empruntDocument from EmpruntDocument where emprunt=? " +
                        "AND document=? AND dateRetourEmprunt=?"
        );
        query.setParameter(1, emprunt);
        query.setParameter(2, document);
        query.setParameter(3, dateRetourEmprunt);

        EmpruntDocument empruntDocument = new EmpruntDocument(emprunt, document, dateRetourEmprunt);

        em.persist(empruntDocument);
        em.getTransaction().commit();
        em.close();

        return empruntDocument;
    }
}
