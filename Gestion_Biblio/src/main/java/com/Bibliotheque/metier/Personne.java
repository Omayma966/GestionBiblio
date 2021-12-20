package com.Bibliotheque.metier;

import java.sql.Date;

public class Personne {
	
	private String cin ;
	private String nomPrenom ;
	private Date dateNais ;
	private String password ;
	private boolean actived ;
	
	
	public Personne() {
		super();
	}


	public Personne(String cin, String nomPrenom, Date dateNais, String password, boolean actived) {
		super();
		this.cin = cin;
		this.nomPrenom = nomPrenom;
		this.dateNais = dateNais;
		this.password = password;
		this.actived = actived;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getNomPrenom() {
		return nomPrenom;
	}


	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}


	public Date getDateNais() {
		return dateNais;
	}


	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActived() {
		return actived;
	}


	public void setActived(boolean actived) {
		this.actived = actived;
	}


	@Override
	public String toString() {
		return "Personne [cin=" + cin + ", nomPrenom=" + nomPrenom + ", dateNais=" + dateNais + ", password=" + password
				+ ", actived=" + actived + "]";
	}



	
	
	
	

}
