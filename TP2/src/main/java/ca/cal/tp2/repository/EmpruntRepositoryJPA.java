package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDocument;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

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
}
