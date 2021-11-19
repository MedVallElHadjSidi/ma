package org.gestioncheque.thymeleaf.form;

public class CarnetChequeForm {
	private Long numCC;
	private Long numero;
	private long numCli;
	private long nbreCQ;
	
	
	
	public long getNumCli() {
		return numCli;
	}
	public void setNumCli(long numCli) {
		this.numCli = numCli;
	}
	public long getNbreCQ() {
		return nbreCQ;
	}
	public void setNbreCQ(long nbreCQ) {
		this.nbreCQ = nbreCQ;
	}
	public Long getNumCC() {
		return numCC;
	}
	public void setNumCC(Long numCC) {
		this.numCC = numCC;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public CarnetChequeForm(Long numCC, Long numero) {
		super();
		this.numCC = numCC;
		this.numero = numero;
	}
	public CarnetChequeForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
