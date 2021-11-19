package org.gestioncheque.thymeleaf.service;

import java.util.List;

import org.gestioncheque.thymeleaf.model.BordereauVirement;
import org.gestioncheque.thymeleaf.model.CarnetBordereauVirement;
import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.model.CompteBordereauVirement;
import org.springframework.data.repository.query.Param;

public interface CarnetBordereauVirementService {
	public List<CarnetBordereauVirement> listeCarnetBordereauVirement();
	public void addCarnetBordereauVirement(CarnetBordereauVirement cbv);
	public CarnetBordereauVirement get(long numCBV);
	public void delete(long numCBV);
	List<Compte> search(Long keyword);
	public Long  getMaxId();
	public List<BordereauVirement> listebv(long keyword);
	public String getlastnumbv(Long keyword);
	public Long getmaxsequence(@Param("keyword") Long keyword);
	public List<CompteBordereauVirement> listebordereauvirementimp(@Param("keyword") Long keyword);
}
