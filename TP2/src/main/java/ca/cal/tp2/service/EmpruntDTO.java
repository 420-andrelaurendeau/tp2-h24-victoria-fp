package ca.cal.tp2.service;

import ca.cal.tp2.modele.Client;

import java.time.LocalDate;

public record EmpruntDTO(Long id, Client client, LocalDate dateEmprunt) { }
