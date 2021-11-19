package org.gestioncheque.thymeleaf.model;

public class CompteBordereauVirement {
	private String numBv;
	private long  numCli;
	private String nom;
	public CompteBordereauVirement(String numBv, long numCli, String nom) {
		super();
		this.numBv = numBv;
		this.numCli = numCli;
		this.nom = nom;
	}
	public String getNumBv() {
		return numBv;
	}
	public void setNumBv(String numBv) {
		this.numBv = numBv;
	}
	public long getNumCli() {
		return numCli;
	}
	public void setNumCli(long numCli) {
		this.numCli = numCli;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
