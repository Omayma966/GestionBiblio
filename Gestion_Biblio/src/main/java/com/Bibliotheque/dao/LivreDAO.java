package com.Bibliotheque.dao;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Bibliotheque.metier.Livre;

public interface LivreDAO extends JpaRepository<Livre, String> {
	
	public ArrayList<Livre> findByTitre(String titre);
	@Transactional
	public Optional<Livre> findById(String isbn);
}
