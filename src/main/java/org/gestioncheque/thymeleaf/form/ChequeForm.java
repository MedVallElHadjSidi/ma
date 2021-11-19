package org.gestioncheque.thymeleaf.form;

public class ChequeForm {
	private String idcarnet;
	private String idcheque;
	private String statut;
	public ChequeForm(String idcarnet, String idcheque, String statut) {
		super();
		this.idcarnet = idcarnet;
		this.idcheque = idcheque;
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
	public String getIdcheque() {
		return idcheque;
	}
	public void setIdcheque(String idcheque) {
		this.idcheque = idcheque;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	

}
