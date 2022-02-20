package org.gestioncheque.thymeleaf.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.gestioncheque.thymeleaf.model.CarnetCheque;
import org.gestioncheque.thymeleaf.model.Cheque;
import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.model.CompteCheque;
import org.springframework.data.repository.query.Param;

public interface CarnetChequeService {
	public Page<CarnetCheque> listeCarnetCheque(int pageble);
	public void addCarnetCheque(CarnetCheque ccq);
	public CarnetCheque get(long numCCQ);
	public void delete(long numCCQ);
	List<Compte> search(Long keyword);
	public Long  getMaxId();
	public List<Cheque> listecheque(long keyword);
	public Page<Cheque> listecheques(long keyword,int pageble);
	public String getlastnumcq(Long keyword);
	public Long getmaxsequence(@Param("keyword") Long keyword);
	public List<CompteCheque> listechequeimp(@Param("keyword") Long keyword);
	

}
