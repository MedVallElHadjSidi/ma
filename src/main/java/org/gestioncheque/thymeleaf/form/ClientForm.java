package org.gestioncheque.thymeleaf.form;

import javax.persistence.Column;

public class ClientForm {
	
	private String first_Name;
	private String last_Name;
	private String email;
	private String date_Naissance;
	private Long numero;
	private Long numclient;
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate_Naissance() {
		return date_Naissance;
	}
	public void setDate_Naissance(String date_Naissance) {
		this.date_Naissance = date_Naissance;
	}
	
	public ClientForm(String first_Name, String last_Name, String email, String date_Naissance) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
		this.date_Naissance = date_Naissance;
		
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	public Long getNumclient() {
		return numclient;
	}
	public void setNumclient(Long numclient) {
		this.numclient = numclient;
	}
	
	
	

}
