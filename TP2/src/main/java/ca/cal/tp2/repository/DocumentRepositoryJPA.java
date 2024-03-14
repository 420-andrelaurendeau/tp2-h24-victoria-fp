package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class DocumentRepositoryJPA implements DocumentRepository {

    public DocumentRepositoryJPA() {}

    @Override
    public Livre saveLivre(String titre, String auteur, String categorie, int annee, int nbExemplairesRestants, int nbPages) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("select * from Document where auteur=?");
        query.setParameter(1, titre);

        Livre livre = new Livre(titre, auteur, categorie, annee, nbExemplairesRestants, nbPages);

        em.persist(livre);
        em.getTransaction().commit();
        em.close();

        return livre;
    }

    @Override
    public void updateLivre(Livre livre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.merge(livre);

        em.getTransaction().commit();
        em.close();
    }


    @Override
    public Livre findLivreByTitre(String titre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("select livre from Document where titre like ?");
        query.setParameter(1, titre);

        List<Livre> resultatQuery = query.getResultList();
        Livre livreTrouve = resultatQuery.getFirst();

        em.getTransaction().commit();
        em.close();

        return livreTrouve;
    }

    @Override
    public Livre findLivreByAuteur(String auteur) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("select livre from Document where auteur = ?");
        query.setParameter(1, auteur);

        List<Livre> resultatQuery = query.getResultList();
        Livre livreTrouve = resultatQuery.getFirst();

        em.getTransaction().commit();
        em.close();

        return livreTrouve;
    }

    @Override
    public Livre findLivreByCategorie(String categorie) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("select livre from Document where categorie = ?");
        query.setParameter(1, categorie);

        List<Livre> resultatQuery = query.getResultList();
        Livre livreTrouve = resultatQuery.getFirst();

        em.getTransaction().commit();
        em.close();

        return livreTrouve;
    }

    @Override
    public Livre findLivreByAnnee(int annee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery("select livre from Document where annee = ?");
        query.setParameter(1, annee);

        List<Livre> resultatQuery = query.getResultList();
        Livre livreTrouve = resultatQuery.getFirst();

        em.getTransaction().commit();
        em.close();

        return livreTrouve;
    }

    @Override
    public int getNbExemplairesRestants(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Query query = em.createNativeQuery(
                "select nbExemplairesRestants from Document where idDocument = ?"
        );
        query.setParameter(1, id);

        List<Integer> resultatQuery = query.getResultList();
        int nbExemplairesRestantsTrouve = resultatQuery.getFirst();

        em.getTransaction().commit();
        em.close();

        return nbExemplairesRestantsTrouve;
    }
}
