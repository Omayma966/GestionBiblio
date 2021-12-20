package com.Bibliotheque.controleur;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/")
public class ControleurUser {
	
	
	  @GetMapping("index")
	  public String index(@RequestParam(name = "name", required =true, defaultValue = "Guidara") String nom, ModelMap modelMap)
	  {
		  modelMap.addAttribute("name", nom);
		  return "pages/index";
	  }
	  
}
