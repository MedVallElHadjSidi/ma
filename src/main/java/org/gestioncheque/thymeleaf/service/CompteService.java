package org.gestioncheque.thymeleaf.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.Compte;
import org.springframework.data.domain.Page;

public interface CompteService {
    public Page<Compte> listeComptes (int pageble);
	public void addCompte(Compte cmp);
	public Optional<Compte> get(long id);
	public void delete(long id);
	public Compte getCompteByNumcLi(long l);
}
