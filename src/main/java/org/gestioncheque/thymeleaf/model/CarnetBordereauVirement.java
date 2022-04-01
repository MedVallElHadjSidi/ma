package org.gestioncheque.thymeleaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CarnetBordereauVirement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numCBV;
	private String statCBV;
	private Date dateCre;
	private Date dateImp;
	private Date dateEmi;
	private long numCli;
	private long nbreBV;
	private String codeEmp;
	public CarnetBordereauVirement() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public long getNumCBV() {
		return numCBV;
	}


	public void setNumCBV(long numCBV) {
		this.numCBV = numCBV;
	}


	public String getStatCBV() {
		return statCBV;
	}
	public void setStatCBV(String statCBV) {
		this.statCBV = statCBV;
	}
	public Date getDateCre() {
		return dateCre;
	}
	public void setDateCre(Date dateCre) {
		this.dateCre = dateCre;
	}
	public Date getDateImp() {
		return dateImp;
	}
	public void setDateImp(Date dateImp) {
		this.dateImp = dateImp;
	}
	public Date getDateEmi() {
		return dateEmi;
	}
	public void setDateEmi(Date dateEmi) {
		this.dateEmi = dateEmi;
	}
	public long getNumCli() {
		return numCli;
	}
	public void setNumCli(long numCli) {
		this.numCli = numCli;
	}
	public long getNbreBV() {
		return nbreBV;
	}
	public void setNbreBV(long nbreBV) {
		this.nbreBV = nbreBV;
	}


	public String getCodeEmp() {
		return codeEmp;
	}


	public void setCodeEmp(String codeEmp) {
		this.codeEmp = codeEmp;
	}
	
	

}
