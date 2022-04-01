package org.gestioncheque.thymeleaf.form;

public class EditCheque {
	private String idcarnet;
	private String idcheque;
	private String statut;
	private String numerocheque;
	private int page;
	public EditCheque(String idcarnet, String idcheque, String statut) {
		super();
		this.idcarnet = idcarnet;
		this.idcheque = idcheque;
		this.statut = statut;
	}
	public EditCheque() {
		super();
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getNumerocheque() {
		return numerocheque;
	}
	public void setNumerocheque(String numerocheque) {
		this.numerocheque = numerocheque;
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
