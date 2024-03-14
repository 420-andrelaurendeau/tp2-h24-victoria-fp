package ca.cal.tp2;

import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.UtilisateurRepositoryJPA;
import ca.cal.tp2.service.ClientDTO;
import ca.cal.tp2.service.ClientService;
import ca.cal.tp2.service.LivreDTO;
import ca.cal.tp2.service.LivreService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.createTcpServer();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2victoria");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        // Création d'un Client -------------------------------
        ClientService clientService = new ClientService(new UtilisateurRepositoryJPA());
        ClientDTO client1 = clientService.createClient("Doe","John");
        // ----------------------------------------------------


        // Création de deux Livres  --------------------------------
        LivreService livreService = new LivreService(new DocumentRepositoryJPA());
        LivreDTO livre1 = livreService.createLivre(
                "Le passager",
                "Patrick Sénécal",
                "Horreur",
                1991,
                50,
                214
        );

        LivreDTO livre2 = livreService.createLivre(
                "Un titre",
                "Auteur Quelconque",
                "Categorie",
                2000,
                0,
                500
        );

        System.out.println("livre1");
        System.out.println("ID : " + livre1.idDocument());
        System.out.println("Titre : " + livre1.titre());
        System.out.println("Auteur : " + livre1.auteur());
        System.out.println("Catégorie : " + livre1.categorie());
        System.out.println("Année : " + livre1.annee());
        System.out.println("Nombre d'exemplaires : " + livre1.nbExemplairesRestants());
        System.out.println("Nombre de pages : " + livre1.nbPages());
        System.out.println("---------------------------------");

        System.out.println("livre2");
        System.out.println("ID : " + livre2.idDocument());
        System.out.println("Titre : " + livre2.titre());
        System.out.println("Auteur : " + livre2.auteur());
        System.out.println("Catégorie : " + livre2.categorie());
        System.out.println("Année : " + livre2.annee());
        System.out.println("Nombre d'exemplaires : " + livre2.nbExemplairesRestants());
        System.out.println("Nombre de pages : " + livre2.nbPages());
        System.out.println("---------------------------------");
        // ----------------------------------------------------


        em.getTransaction().commit();
        em.close();
        emf.close();

        Thread.currentThread().join();
    }
}