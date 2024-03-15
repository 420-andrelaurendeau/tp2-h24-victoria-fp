package ca.cal.tp2;

import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepositoryJPA;
import ca.cal.tp2.repository.UtilisateurRepositoryJPA;
import ca.cal.tp2.service.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

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


        // Création d'un Emprunt de Livre qui a plusieurs exemplaires -----------------------------
        EmpruntService empruntService = new EmpruntService(
                new EmpruntRepositoryJPA(), new DocumentRepositoryJPA(), new UtilisateurRepositoryJPA()
        );

        LocalDate dateEmprunt1 = LocalDate.of(2024, 03, 10);
        EmpruntDTO emprunt1 = empruntService.createEmprunt(client1, dateEmprunt1);
        EmpruntDocumentDTO empruntDocument1 = empruntService.createEmpruntDocumentLivre(emprunt1, livre1);

        System.out.println("empruntDocument1");
        System.out.println("Date de l'emprunt : " + emprunt1.dateEmprunt());
        System.out.println("Client qui a fait l'emprunt : " + emprunt1.client().getPrenom());
        System.out.println("Document emprunté : " + empruntDocument1.document());
        System.out.println("Date limite de retour : " + empruntDocument1.dateRetour());
        System.out.println("---------------------------------");
        // ----------------------------------------------------------------------------------------

        // Essai d'emprunt de document qui n'a plus d'exemplaires (doit échouer) ------------------
        try {
            LocalDate dateEmprunt2 = LocalDate.of(2022, 02, 2);
            EmpruntDTO emprunt2 = empruntService.createEmprunt(client1, dateEmprunt2);
            EmpruntDocumentDTO empruntDocument2 = empruntService.createEmpruntDocumentLivre(emprunt2, livre2);
        } catch (NullPointerException e) {
            System.out.println("Test échoué");
            System.out.println("---------------------------------");
        }
        // ----------------------------------------------------------------------------------------


        // Recherche d'un livre selon son titre ------------------
        LivreDTO livreRechercheParTitre = livreService.findLivreByTitre("passager");
        System.out.println("ID du livre dont le titre contient 'passager' : " + livreRechercheParTitre.idDocument());
        System.out.println("---------------------------------");
        // -------------------------------------------------------

        // Recherche d'un livre selon son auteur ------------------
        LivreDTO livreRechercheParAuteur = livreService.findLivreByAuteur("Auteur Quelconque");
        System.out.println("ID du livre dont l'auteur est 'Auteur Quelconque' : " + livreRechercheParAuteur.idDocument());
        System.out.println("---------------------------------");
        // -------------------------------------------------------



        em.getTransaction().commit();
        em.close();
        emf.close();

        Thread.currentThread().join();
    }
}