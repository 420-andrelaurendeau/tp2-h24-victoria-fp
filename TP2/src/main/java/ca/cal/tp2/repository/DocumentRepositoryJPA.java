package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DocumentRepositoryJPA implements DocumentRepository {

    public DocumentRepositoryJPA() {}

    @Override
    public Livre saveLivre(String titre, String auteur, int nbPages) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("select titre, auteur, nbPages from Document where auteur=?");
        query.setParameter(1, titre);

        Livre livre = new Livre(titre, auteur, nbPages);

        em.persist(livre);
        em.getTransaction().commit();
        em.close();

        return livre;
    }
}
