package org.gestioncheque.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.Compte;

public interface CompteService {
    public List<Compte> listeComptes ();
	public void addCompte(Compte cmp);
	public Optional<Compte> get(long id);
	public void delete(long id);
	public Compte getCompteByNumcLi(long l);
}
