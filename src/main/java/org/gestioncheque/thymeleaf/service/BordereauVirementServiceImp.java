package org.gestioncheque.thymeleaf.service;

import java.util.List;

import org.gestioncheque.thymeleaf.model.BordereauVirement;
import org.gestioncheque.thymeleaf.repository.BordereauVirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BordereauVirementServiceImp implements BordereauVirementService{
	@Autowired 
    BordereauVirementRepository bordereauvirementrepository;
	@Override
	public List<BordereauVirement> listeBordereauVirement() {
		// TODO Auto-generated method stub
		return bordereauvirementrepository.findAll();
	}

	@Override
	public void addBordereauVirement(BordereauVirement bv) {
		// TODO Auto-generated method stub
		bordereauvirementrepository.saveAndFlush(bv);
	}

	@Override
	public BordereauVirement get(long numBV) {
		// TODO Auto-generated method stub
		return bordereauvirementrepository.findById(numBV).get();
	}

	@Override
	public void delete(long numBV) {
		// TODO Auto-generated method stub
		bordereauvirementrepository.deleteById(numBV);
		
	}

	@Override
	public List<BordereauVirement> search(long numBV) {
		// TODO Auto-generated method stub
		return bordereauvirementrepository.search(numBV);
	}

}
