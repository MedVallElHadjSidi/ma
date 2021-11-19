package org.gestioncheque.thymeleaf.form;

public class CompteForm {
	 private Long numero;
	 private int numCpte;
	     String lib;
     String typecli;
     int nomOrg;
     int numOrg;
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public int getNumCpte() {
		return numCpte;
	}
	public void setNumCpte(int numCpte) {
		this.numCpte = numCpte;
	}
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	public String getTypecli() {
		return typecli;
	}
	public void setTypecli(String typecli) {
		this.typecli = typecli;
	}
	public int getNomOrg() {
		return nomOrg;
	}
	public void setNomOrg(int nomOrg) {
		this.nomOrg = nomOrg;
	}
	public int getNumOrg() {
		return numOrg;
	}
	public void setNumOrg(int numOrg) {
		this.numOrg = numOrg;
	}
	public CompteForm(Long numero, int numCpte, String lib, String typecli, int nomOrg, int numOrg) {
		super();
		this.numero = numero;
		this.numCpte = numCpte;
		this.lib = lib;
		this.typecli = typecli;
		this.nomOrg = nomOrg;
		this.numOrg = numOrg;
	}
	public CompteForm() {
		super();
	}
     
     
	

}
