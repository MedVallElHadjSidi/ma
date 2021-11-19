package org.gestioncheque.thymeleaf.model;

public class CompteCheque {
	private String numCq;
	private long numCli;
	private String nom;
	
	public CompteCheque() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteCheque(String numCq, long numCli, String nom) {
		super();
		this.numCq = numCq;
		this.numCli = numCli;
		this.nom = nom;
	}

	public String getNumCq() {
		return numCq;
	}
	public void setNumCq(String numCq) {
		this.numCq = numCq;
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
