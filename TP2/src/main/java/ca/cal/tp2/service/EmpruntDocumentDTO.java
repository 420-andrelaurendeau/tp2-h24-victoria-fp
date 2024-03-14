package ca.cal.tp2.service;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;

import java.time.LocalDate;

public record EmpruntDocumentDTO(Long idEmpruntDocument, Emprunt emprunt, Document document, LocalDate dateRetour) { }
