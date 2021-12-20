package com.Bibliotheque.controleur;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bibliotheque.dao.AuteurDAO;
import com.Bibliotheque.dao.LivreDAO;
import com.Bibliotheque.metier.Auteur;
import com.Bibliotheque.metier.Livre;

@Controller
@RequestMapping("livre")
public class ControleurLivre {

private final LivreDAO livreDAO;
private final AuteurDAO auteurDAO;
	
	@Autowired
	public ControleurLivre(LivreDAO livreDAO, AuteurDAO auteurDAO)
	{
		this.livreDAO=livreDAO;
		this.auteurDAO=auteurDAO;
	}
	
	@GetMapping("gerer")
	public String gerer(ModelMap modelMap)
	{
		modelMap.addAttribute("livres", livreDAO.findAll());
		modelMap.addAttribute("auteurs", auteurDAO.findAll());
		return "pages/livres";
	}
	
	@GetMapping("/livreAuteur")
	public String affecter(ModelMap modelMap)
	{
		modelMap.addAttribute("livres", livreDAO.findAll());
		modelMap.addAttribute("auteurs", auteurDAO.findAll());
		return "pages/auteurLivre";
	}
	
	@GetMapping("/nblivre")
	public String nblivre(ModelMap modelMap)
	{
		modelMap.addAttribute("livres", livreDAO.findAll());
		modelMap.addAttribute("auteurs", auteurDAO.findAll());
		return "pages/nbLivreAuteur";
	}
	
	@PostMapping("add")
	public void add(@RequestParam(required = true, name = "title") String titre, @RequestParam(required = true, name = "isbn") String isbn, @RequestParam(required = true, name = "year") int annee, HttpServletResponse response)
	{
		
		livreDAO.save(new Livre(isbn, titre, annee));
		try {
            response.sendRedirect("gerer");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@PostMapping("aff")
	public void affLivreAuteur(@RequestParam(required = true, name = "books") String isbn, @RequestParam(required = true, name = "authors") Long id, HttpServletResponse response)
	{
		Livre livre = livreDAO.getById(isbn);
		Auteur auteur = auteurDAO.getById(id);
		auteur.addLivres(livre);
		auteurDAO.save(auteur);
		try {
            response.sendRedirect("livreAuteur");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	@GetMapping("remove")
	 public String deleteLivre(@RequestParam(required = true, name = "isbn") String isbn, ModelMap modelMap) {
		
		if(livreDAO.getById(isbn)!=null)
			livreDAO.deleteById(isbn);
		
		modelMap.addAttribute("livres", livreDAO.findAll());
		modelMap.addAttribute("auteurs", auteurDAO.findAll());
		return "pages/livres";
	  }
	
    @PutMapping("/livres/{isbn}")
	  Livre replaceLivre(@RequestBody Livre newLivre, @PathVariable String isbn) {
	    
	    return livreDAO.findById(isbn)
	    	.map(livre -> {
	        livre.setTitre(newLivre.getTitre());
	        livre.setAnnee(newLivre.getAnnee());
	        return livreDAO.save(livre);
	      })
	      .orElseGet(() -> {
	    	  newLivre.setIsbn(isbn);
	        return livreDAO.save(newLivre);
	      });
	  }
}
