package org.gestioncheque.thymeleaf.form;

import com.sun.istack.NotNull;

public class CmpteForm {
private Long numCpte;
private String libelle;
private Long numero;
private Long numOrg;
private Long numCli;


public CmpteForm(Long numCpte, String libelle, Long numero) {
	super();
	this.numCpte = numCpte;
	this.libelle = libelle;
	this.numero = numero;
}
public CmpteForm() {
	super();
	// TODO Auto-generated constructor stub
}



public Long getNumOrg() {
	return numOrg;
}
public void setNumOrg(Long numOrg) {
	this.numOrg = numOrg;
}
public Long getNumCli() {
	return numCli;
}
public void setNumCli(Long numCli) {
	this.numCli = numCli;
}
public Long getNumCpte() {
	return numCpte;
}
public void setNumCpte(Long numCpte) {
	this.numCpte = numCpte;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public Long getNumero() {
	return numero;
}
public void setNumero(Long numero) {
	this.numero = numero;
}


}
