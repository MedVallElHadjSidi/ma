package org.gestioncheque.thymeleaf.service;

import java.util.List;

import org.gestioncheque.thymeleaf.model.Cheque;
import org.gestioncheque.thymeleaf.repository.ChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChequeServiceImp implements ChequeService {
	@Autowired
	ChequeRepository chequerepository;

	@Override
	public List<Cheque> listeCheque() {
		// TODO Auto-generated method stub
		return chequerepository.findAll();
	}

	@Override
	public void addCheque(Cheque cq) {
		// TODO Auto-generated method stub
		chequerepository.saveAndFlush(cq);
	}

	@Override
	public Cheque get(long numCQ) {
		// TODO Auto-generated method stub
		return chequerepository.findById(numCQ).get();
	}

	@Override
	public void delete(long numCQ) {
		// TODO Auto-generated method stub
		chequerepository.deleteById(numCQ);
		
	}

	@Override
	public List<Cheque> search(long numCQ) {
		// TODO Auto-generated method stub
		return chequerepository.search(numCQ);
	}

}
