package org.gestioncheque.thymeleaf.form;

public class ChequeForm {
	private String idcarnet;
	private String numcheque;
	private String statut;
	private String idcheque;
	private int page ;
	public ChequeForm(String idcarnet, String idcheque, String statut) {
		super();
		this.idcarnet = idcarnet;
		this.numcheque = idcheque;
		this.statut = statut;
	}
	public ChequeForm() {
		super();
	}
	public String getIdcarnet() {
		return idcarnet;
	}
	public void setIdcarnet(String idcarnet) {
		this.idcarnet = idcarnet;
	}

	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getNumcheque() {
		return numcheque;
	}
	public void setNumcheque(String numcheque) {
		this.numcheque = numcheque;
	}
	public String getIdcheque() {
		return idcheque;
	}
	public void setIdcheque(String idcheque) {
		this.idcheque = idcheque;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
	
	

}
