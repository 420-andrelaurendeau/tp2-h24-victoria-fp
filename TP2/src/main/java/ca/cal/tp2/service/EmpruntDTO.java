package ca.cal.tp2.service;

import ca.cal.tp2.modele.EmpruntDocument;

import java.util.List;

public record EmpruntDTO(Long id, List<EmpruntDocument> empruntDocuments) {
}