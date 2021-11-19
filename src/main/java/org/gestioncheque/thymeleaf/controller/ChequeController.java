package org.gestioncheque.thymeleaf.controller;

import java.util.List;

import org.gestioncheque.thymeleaf.model.Cheque;
import org.gestioncheque.thymeleaf.service.ChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cheques")
public class ChequeController {
	@Autowired
	ChequeService chequeservice;
	
	//@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/listecheques")
	public String getlistcheque(Model model) {
		
		List<Cheque> listeCQ=chequeservice.listeCheque();
		
		model.addAttribute("cheque",listeCQ);
		
		return "listeCheque";
	}

	@RequestMapping(value="/formcheque",method=RequestMethod.GET)
	public String formcq(Model model) {
		model.addAttribute("cheque",new Cheque());
		return "formCheque";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/SaveCheque",method=RequestMethod.POST)
	public String savecq(Cheque cq) {
		chequeservice.addCheque(cq);
		return "redirect:listecheques";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name="id") long id) {
		ModelAndView mav=new ModelAndView("edit_cheque");
		Cheque cheque=chequeservice.get(id);
		mav.addObject("cheque",cheque);
		return mav;
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/delete/{id}")
	public String deletecheque(@PathVariable(name="id") long id) {
		chequeservice.delete(id);
		return "redirect:/cheques/listecheques";
	} 
}
