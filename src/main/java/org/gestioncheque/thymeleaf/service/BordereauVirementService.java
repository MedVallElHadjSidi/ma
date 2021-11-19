package org.gestioncheque.thymeleaf.service;

import java.util.List;

import org.gestioncheque.thymeleaf.model.BordereauVirement;

public interface BordereauVirementService {
	public List<BordereauVirement> listeBordereauVirement();
	public void addBordereauVirement(BordereauVirement bv);
	public BordereauVirement get(long numBV);
	public void delete(long numBV);
	public List<BordereauVirement> search(long numBV);

}
