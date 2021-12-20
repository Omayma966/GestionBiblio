package com.Bibliotheque.controleur;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bibliotheque.dao.AuteurDAO;
import com.Bibliotheque.metier.Auteur;


@Controller
@Service
@RequestMapping("auteur")
public class ControleurAuteur {
	
	private final AuteurDAO auteurDAO;
	
	@Autowired
	public ControleurAuteur(AuteurDAO auteurDAO)
	{
		this.auteurDAO=auteurDAO;
	}
	
	@GetMapping("menu")
	public String menu()
	{
		return "pages/menu";
	}
	
	@GetMapping("gerer")
	public String gerer(ModelMap modelMap)
	{	
		modelMap.addAttribute("auteurs", auteurDAO.findAll());
		return "pages/auteurs";
	}
	
	@GetMapping("add")
	public void add(@RequestParam(required = true, name = "nom") String nom, ModelMap modelMap,  HttpServletResponse response)
	{
		auteurDAO.save(new Auteur(nom));
		try {
            response.sendRedirect("gerer");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@DeleteMapping("/auteurs/{id}")
	  void deleteAuteur(@PathVariable Long id) {
		auteurDAO.deleteById(id);
	  }
	@GetMapping("remove")
	 public String deleteActeur(@RequestParam(required = true, name = "id") Long id, ModelMap modelMap) {
		
		if(auteurDAO.getById(id)!=null)
			auteurDAO.deleteById(id);
		
		modelMap.addAttribute("auteurs", auteurDAO.findAll());
		return "pages/auteurs";
	  }
 
}
