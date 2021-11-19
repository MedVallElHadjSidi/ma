package org.gestioncheque.thymeleaf.service;

import java.util.List;

import org.gestioncheque.thymeleaf.model.Cheque;

public interface ChequeService {
    public List<Cheque> listeCheque();
	public void addCheque(Cheque cq);
	public Cheque get(long numCQ);
	public void delete(long numCQ);
	public List<Cheque> search(long numCQ);
}
