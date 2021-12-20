package com.Bibliotheque.metier;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Livre implements Serializable{
	@Id
	@Column(length=20)
	private String isbn;
	private String titre;
	private int annee;
	
	public Livre() {
	}
	
	public Livre(String isbn, String titre, int annee) {
		this.isbn = isbn;
		this.titre = titre;
		this.annee = annee;
	}
	
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "\nLivre [isbn=" + isbn + ", titre=" + titre + ", annee=" + annee + "]";
	}
	
}
