package org.gestioncheque.thymeleaf.form;

public class BordereauVirementForm {
	
	private String numBV;
	private Long numero;
	private Long montant;
	private String datemission;
	private String datecheance;
	private long numcpte;
	public String getNumBV() {
		return numBV;
	}
	public void setNumBV(String numBV) {
		this.numBV = numBV;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public BordereauVirementForm(String numBV, Long numero) {
		super();
		this.numBV = numBV;
		this.numero = numero;
	}
	public BordereauVirementForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getMontant() {
		return montant;
	}
	public void setMontant(Long montant) {
		this.montant = montant;
	}
	public String getDatemission() {
		return datemission;
	}
	public void setDatemission(String datemission) {
		this.datemission = datemission;
	}
	public String getDatecheance() {
		return datecheance;
	}
	public void setDatecheance(String datecheance) {
		this.datecheance = datecheance;
	}
	public long getNumcpte() {
		return numcpte;
	}
	public void setNumcpte(long numcpte) {
		this.numcpte = numcpte;
	}
	
	
}
