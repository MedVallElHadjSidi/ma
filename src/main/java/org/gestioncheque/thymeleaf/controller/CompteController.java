package org.gestioncheque.thymeleaf.controller;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.model.Role;
import org.gestioncheque.thymeleaf.model.User;
import org.gestioncheque.thymeleaf.repository.UserRepository;
import org.gestioncheque.thymeleaf.service.CompteService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller

public class CompteController {
	@Autowired
	CompteService compteservice;
	
	@Autowired 
	UserRepository userrepository;
	//@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	
	@RequestMapping(value = "/")
	public String quoditienne(Model model,   @AuthenticationPrincipal UserDetailsService currentUser) {
		
	


		

		return "redirect:/gestionCompte";

	}
	
	@GetMapping("/gestionCompte")
	public String getlistcheque(Model model,@RequestParam(name = "page",defaultValue = "0") int page){
		
		Page<Compte> listeCmp=compteservice.listeComptes(page);
		int nbrepage = new int[listeCmp.getTotalPages()].length;

		model.addAttribute("pages",new int[listeCmp.getTotalPages()]);
		model.addAttribute("pageactuel",page);
		model.addAttribute("nbrepage",nbrepage);
		
		model.addAttribute("comptes",listeCmp.getContent());
		
		return "GestionCompteMenu";
	}
//	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/formcompte",method=RequestMethod.GET)
	public String formcmp(Model model) {
		model.addAttribute("compte",new Compte());
		return "GestionCompteMenu";
	}
//	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/SaveCompte",method=RequestMethod.POST)
	public String savecmp(Compte cmp) {
		System.out.println(cmp.getNumOrg());
		compteservice.addCompte(cmp);
		return "redirect:/gestionCompte";
	}
//	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/editcpt/{id}")
	public ModelAndView showEditCompteForm(@PathVariable(name="id") long id) {
		ModelAndView mav=new ModelAndView("edit_compte");
		Optional<Compte> compte=compteservice.get(id);
		mav.addObject("compte",compte);
		return mav;
	}
//	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/deletecpt/{id}")
	public String deletecopmte(@PathVariable(name="id") long id) {
		compteservice.delete(id);
		return "redirect:/gestionCompte";
	}
	
}
