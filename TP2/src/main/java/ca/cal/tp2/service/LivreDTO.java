package ca.cal.tp2.service;

public record LivreDTO(Long idDocument, String titre, String auteur, String categorie, int annee, int nbExemplairesRestants, int nbPages) {}
