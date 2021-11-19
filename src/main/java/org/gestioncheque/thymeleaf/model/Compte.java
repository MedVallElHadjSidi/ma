package org.gestioncheque.thymeleaf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import com.sun.istack.NotNull;
@Entity
public class Compte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long numCli;
	@NotNull
	private String lib;
	@Column(nullable = true)
	private Integer numOrg;
	private String typeCli;
	private int numCpte;
	private String nom;
	public Compte(long id, long numCli, String lib, Integer numOrg, String typeCli, int numCpte, String nom) {
		super();
		this.id = id;
		this.numCli = numCli;
		this.lib = lib;
		this.numOrg = numOrg;
		this.typeCli = typeCli;
		this.numCpte = numCpte;
		this.nom = nom;
	}
	public Compte(long numCli, String lib, String typeCli, int numCpte, String nom) {
		super();
		this.numCli = numCli;
		this.lib = lib;
		this.typeCli = typeCli;
		this.numCpte = numCpte;
		this.nom = nom;
	}
	public Compte(long numCli, String lib, Integer numOrg, String typeCli, int numCpte, String nom) {
		super();
		this.numCli = numCli;
		this.lib = lib;
		this.numOrg = numOrg;
		this.typeCli = typeCli;
		this.numCpte = numCpte;
		this.nom = nom;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumCli() {
		return numCli;
	}
	public void setNumCli(long numCli) {
		this.numCli = numCli;
	}
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	public Integer getNumOrg() {
		return numOrg;
	}
	public void setNumOrg(Integer numOrg) {
		this.numOrg = numOrg;
	}
	public String getTypeCli() {
		return typeCli;
	}
	public void setTypeCli(String typeCli) {
		this.typeCli = typeCli;
	}
	public int getNumCpte() {
		return numCpte;
	}
	public void setNumCpte(int numCpte) {
		this.numCpte = numCpte;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Compte() {
		super();
	}

	
}
