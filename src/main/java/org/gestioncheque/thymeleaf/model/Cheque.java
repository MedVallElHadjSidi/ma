package org.gestioncheque.thymeleaf.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Cheque implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String numCQ;
	private String statCQ;
	private long numCC;
	private long sequence;
	@ManyToOne
	CarnetCheque carnetCheque;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CarnetCheque getCarnetCheque() {
		return carnetCheque;
	}
	public void setCarnetCheque(CarnetCheque carnetCheque) {
		this.carnetCheque = carnetCheque;
	}
	public Cheque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNumCQ() {
		return numCQ;
	}
	public void setNumCQ(String numCQ) {
		this.numCQ = numCQ;
	}
	public String getStatCQ() {
		return statCQ;
	}
	public void setStatCQ(String statCQ) {
		this.statCQ = statCQ;
	}
	
	  public long getNumCC() { return numCC; } public void setNumCC(long numCC) {
	  this.numCC = numCC; }
	public long getSequence() {
		return sequence;
	}
	public void setSequence(long sequence) {
		this.sequence = sequence;
	}
	 
	
	
}
