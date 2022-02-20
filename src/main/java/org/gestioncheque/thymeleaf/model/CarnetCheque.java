package org.gestioncheque.thymeleaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarnetCheque implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long numCC;
private String statCC;
private Date dateCre;
private Date dateImp;
private Date dateEmi;
private long numCli;
private long nbreCQ;
private String codeEmp;
public long getNumCli() {
	return numCli;
}
public void setNumCli(long numCli) {
	this.numCli = numCli;
}
public CarnetCheque() {
	super();
	// TODO Auto-generated constructor stub
}
public long getNumCC() {
	return numCC;
}
public void setNumCC(long numCC) {
	this.numCC = numCC;
}
public String getStatCC() {
	return statCC;
}
public void setStatCC(String statCC) {
	this.statCC = statCC;
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

public long getNbreCQ() {
	return nbreCQ;
}
public void setNbreCQ(long nbreCQ) {
	this.nbreCQ = nbreCQ;
}
public String getCodeEmp() {
	return codeEmp;
}
public void setCodeEmp(String codeEmp) {
	this.codeEmp = codeEmp;
}


}
