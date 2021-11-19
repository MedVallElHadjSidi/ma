package org.gestioncheque.thymeleaf.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class BordereauVirement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String numBV;
	private String statBV;
	private long numCBV;
	private long sequence;
	@ManyToOne
	CarnetBordereauVirement carnetbordereauvirement;
	public BordereauVirement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumBV() {
		return numBV;
	}
	public void setNumBV(String numBV) {
		this.numBV = numBV;
	}
	public String getStatBV() {
		return statBV;
	}
	public void setStatBV(String statBV) {
		this.statBV = statBV;
	}
	public long getNumCBV() {
		return numCBV;
	}
	public void setNumCBV(long numCBV) {
		this.numCBV = numCBV;
	}
	
	public CarnetBordereauVirement getCarnetbordereauvirement() {
		return carnetbordereauvirement;
	}
	public void setCarnetbordereauvirement(CarnetBordereauVirement carnetbordereauvirement) {
		this.carnetbordereauvirement = carnetbordereauvirement;
	}
	public long getSequence() {
		return sequence;
	}
	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

}
