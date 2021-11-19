package org.gestioncheque.thymeleaf.controller;

import java.util.List;

import org.gestioncheque.thymeleaf.form.EditCheque;
import org.gestioncheque.thymeleaf.model.BordereauVirement;
import org.gestioncheque.thymeleaf.service.BordereauVirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bordereauvirements")
public class BordereauVirementController {
@Autowired
BordereauVirementService bordereauvirementservice;
//@Secured(value={"ROLE_ADMIN","ROLE_USER"})
@GetMapping("/listebordereauvirements")
public String getlistborderequvirement(Model model) {
	
	List<BordereauVirement> listeBV=bordereauvirementservice.listeBordereauVirement();
	
	model.addAttribute("bordereauvirement",listeBV);
	
	return "listeBordereauVirement";
}
@RequestMapping(value="/formBordereauVirement",method=RequestMethod.GET)
public String formcq(Model model) {
	model.addAttribute("bordereauvirement",new BordereauVirement());
	return "formBordereauVirement";
}
//@Secured(value={"ROLE_ADMIN"})
@RequestMapping(value="/Savebordereauvirement",method=RequestMethod.POST)
public String savebv(BordereauVirement bv) {
	bordereauvirementservice.addBordereauVirement(bv);
	return "redirect:listebordereauvirements";
}
//@Secured(value={"ROLE_ADMIN"})
@RequestMapping("/edit/{id}")
public ModelAndView showEditProductForm(@PathVariable(name="id") long id) {
	ModelAndView mav=new ModelAndView("edit_bordereauvirement");
	BordereauVirement bordereauvirement=bordereauvirementservice.get(id);
	mav.addObject(" bordereauvirement", bordereauvirement);
	return mav;
}
//@Secured(value={"ROLE_ADMIN"})
@RequestMapping("/delete/{id}")
public String deletecheque(@PathVariable(name="id") long id) {
	bordereauvirementservice.delete(id);
	return "redirect:/bordereauvirements/listebordereauvirements";
} 



}
