package org.gestioncheque.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class CompteServiceImp implements CompteService{
	@Autowired
	CompteRepository compterepository;

	@Override
	public Page<Compte> listeComptes(int page) {
		// TODO Auto-generated method stub
		 return compterepository.findAll(PageRequest.of(page,4));
	}

	@SuppressWarnings("null")
	@Override
	public void addCompte(Compte cmp) {
		// TODO Auto-generated method stub
	
		compterepository.save(cmp);
	}

	@Override
	public Optional<Compte> get(long id) {	
		return compterepository.findById(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		compterepository.deleteById(id);
	}

	@Override
	public Compte getCompteByNumcLi(long numCli) {
		// TODO Auto-generated method stub
		return compterepository.getCompteByNumcLi(numCli);
	}

}
