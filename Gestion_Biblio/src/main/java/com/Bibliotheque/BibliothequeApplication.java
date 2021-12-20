package com.Bibliotheque;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestProperties;
import org.springframework.context.ApplicationContext;

import com.Bibliotheque.dao.AuteurDAO;
import com.Bibliotheque.dao.LivreDAO;
import com.Bibliotheque.metier.Auteur;
import com.Bibliotheque.metier.Livre;

@SpringBootApplication
public class BibliothequeApplication {

	
	public static void main(String[] args) {
		ApplicationContext cnt= SpringApplication.run(BibliothequeApplication.class, args);
		AuteurDAO auteurDAO=cnt.getBean(AuteurDAO.class);
		LivreDAO livreDAO=cnt.getBean(LivreDAO.class);
		/*
		 * Auteur auteur1=new Auteur("Louis-Ferdinand Céline"); Auteur auteur2=new
		 * Auteur("Victor Hugo"); Livre livre1=new Livre("978-2505060833",
		 * "Voyage au bout de la nuit", 1932); Livre livre2=new Livre("978-2505060192",
		 * "Les Misérables", 1862); Livre livre3=new Livre("978-2505060840",
		 * "Notre-Dame de Paris", 1831); Livre livre4=new Livre("978-2331052071",
		 * "Ruy Blas", 1838); Livre livre5=new Livre("978-2331052897", "Mort à crédit",
		 * 1963);
		 * 
		 * livreDAO.save(livre1); livreDAO.save(livre2); livreDAO.save(livre3);
		 * livreDAO.save(livre4); livreDAO.save(livre5);
		 * 
		 * 
		 * auteur1.addLivres(livre1); auteur2.addLivres(livre2);
		 * auteur2.addLivres(livre3); auteur2.addLivres(livre4);
		 * auteur1.addLivres(livre5);
		 * 
		 * 
		 * 
		 * Auteur auteur3=new Auteur("Marcel Pagnol"); Auteur auteur4=new
		 * Auteur("Jules Vallès"); Auteur auteur5=new Auteur("Alphonse Daudet"); Auteur
		 * auteur6=new Auteur("Claude Cahun");
		 * 
		 * auteurDAO.save(auteur1); auteurDAO.save(auteur2); auteurDAO.save(auteur3);
		 * auteurDAO.save(auteur4); auteurDAO.save(auteur5); auteurDAO.save(auteur6);
		 * 
		 * Livre livre6=new Livre("978-2331052854", "Le Château de ma mère", 1957);
		 * Livre livre7=new Livre("978-2331052808", "Le Bachelier", 1881 ); Livre
		 * livre8=new Livre("978-2331052882", "Le Petit Chose", 1868); Livre livre9=new
		 * Livre("978-2331052869", "Aveux non avenus", 1930);
		 * 
		 * livreDAO.save(livre6); livreDAO.save(livre7); livreDAO.save(livre8);
		 * livreDAO.save(livre9);
		 * 
		 * auteur3.addLivres(livre6); auteur4.addLivres(livre7);
		 * auteur5.addLivres(livre8); auteur6.addLivres(livre9);
		 * 
		 * 
		 * auteurDAO.save(auteur1); auteurDAO.save(auteur2); auteurDAO.save(auteur3);
		 * auteurDAO.save(auteur4); auteurDAO.save(auteur5); auteurDAO.save(auteur6);
		 * 
		 * 
		 * 
		 * System.out.println(livreDAO.findAll()); System.out.println(auteur6);
		 */
		
		
		
	}

}
