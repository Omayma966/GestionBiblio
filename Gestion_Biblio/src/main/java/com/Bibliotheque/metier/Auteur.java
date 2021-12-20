package com.Bibliotheque.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;

@Entity
public class Auteur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private int nbreLivres=0;
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Livre> livres = new ArrayList<Livre>();
	
	public Auteur() {
	}

	public Auteur(Long id, String nom, int nbreLivres, Collection<Livre> livres) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbreLivres = nbreLivres;
		this.livres = livres;
	}


	public void addLivres(Livre livre)
	{
		if(livre!= null && livres.contains(livre)==false) 
		{
			this.livres.add(livre);
			this.nbreLivres++;
			
		}
		
	}
	
	public Auteur(String nom) {
		this.nom = nom;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
 
	public Collection<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Collection<Livre> livres) {
		this.livres = livres;
	}

	public int getNbreLivres() {
		return nbreLivres;
	}

	public void setNbreLivres(int i) {
		this.nbreLivres = i;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auteur other = (Auteur) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", nom=" + nom + ", nbreLivres=" + nbreLivres +  "]";
	}

	
	
}
