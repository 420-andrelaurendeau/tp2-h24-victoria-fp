package ca.cal.tp2;

import ca.cal.tp2.modele.Client;
import ca.cal.tp2.repository.UtilisateurRepositoryJPA;
import ca.cal.tp2.service.ClientDTO;
import ca.cal.tp2.service.ClientService;
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
        ClientDTO clientDTO = clientService.createClient("Doe","John");
        // ----------------------------------------------------

        em.getTransaction().commit();
        em.close();
        emf.close();

        Thread.currentThread().join();
    }
}