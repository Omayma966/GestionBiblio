package com.Bibliotheque.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Bibliotheque.metier.Auteur;


public interface AuteurDAO extends JpaRepository<Auteur, Long> {
	
	public void deleteById(Long id);
	/*public Optional <Auteur> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}*/


	public void deleteById(String id);

}
