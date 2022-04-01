package org.gestioncheque.thymeleaf.controller;

import java.util.Date;
import java.util.List;

import org.gestioncheque.thymeleaf.form.EditCheque;
import org.gestioncheque.thymeleaf.model.BordereauVirement;
import org.gestioncheque.thymeleaf.model.CarnetBordereauVirement;
import org.gestioncheque.thymeleaf.model.CarnetCheque;
import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.repository.BordereauVirementRepository;
import org.gestioncheque.thymeleaf.repository.CarnetBordereauVirementRepository;
import org.gestioncheque.thymeleaf.repository.CompteRepository;
import org.gestioncheque.thymeleaf.service.BordereauVirementService;
import org.gestioncheque.thymeleaf.service.CarnetBordereauVirementReportService;
import org.gestioncheque.thymeleaf.service.CarnetBordereauVirementService;
import org.gestioncheque.thymeleaf.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CarnetBordereauVirementController {
	@Autowired
	CarnetBordereauVirementService carnetbordereauvirementservice;
	@Autowired
	CompteService compteservice;
	@Autowired
	BordereauVirementService bordereauvirementservice;
	@Autowired
	CarnetBordereauVirementReportService carnetBordereauVirementReportservice;
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	BordereauVirementRepository bordereauVirementRepository;
	
	@Autowired
	CarnetBordereauVirementRepository carnetBv;
	
	//@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/ajoutercarnetbordereauvirement")
	public String ajoutcarnetbordereauvirement() {
		return "AjoutCarnetBordereauVirement";
	}
	//@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/gestionBordereauVirement")
	public String getlistcarnetbordereauvirement(Model model,@RequestParam(name = "page",defaultValue = "0") int page) {
		
		List<Compte> comptes = compteRepository.findAll();
		model.addAttribute("comptes", comptes);
		
		Page<CarnetBordereauVirement> listeCBV=carnetbordereauvirementservice.listeCarnetBordereauVirement(page);
		int nbrepage = new int[listeCBV.getTotalPages()].length;
		
		model.addAttribute("pages",new int[listeCBV.getTotalPages()]);
		model.addAttribute("pageactuel",page);
		model.addAttribute("nbrepage",nbrepage);
		
		model.addAttribute("carnetbordereauvirement",listeCBV.getContent());
		
		
		return "GestionBordereauVirementMenu";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/searchbv")
	public String searchBV(Model model, @Param("keyword") Long keyword) {
		List<Compte> listeCpte=carnetbordereauvirementservice.search(keyword);
		System.out.print("Taille liste cpte : " + listeCpte.size());
		if (listeCpte.size()==0) {
			
			model.addAttribute("error", "Compte inexistant");
			
			return "redirect:ajoutercarnetcheque";
		} 
		
		model.addAttribute("compte",listeCpte.get(0));
		model.addAttribute("keyword", keyword);
		model.addAttribute("carnetbordereauvirement",new CarnetBordereauVirement());
		return "ListeCompteCarnetBordereauVirement";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/Savecarnetbordereauvirement",method=RequestMethod.POST)
	public String savecq(CarnetBordereauVirement cbv) {
		carnetbordereauvirementservice.addCarnetBordereauVirement(cbv);
		return "redirect:gestionBordereauVirement";
	}
	//@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping("/listbordereauvirement")
	public String listeBV(Model model,@RequestParam(name="id") long id,@RequestParam(name = "page",defaultValue = "0") int page) {
		Page<BordereauVirement> listebv=carnetbordereauvirementservice.listebvs(id,page);
		
      int nbrepage = new int[listebv.getTotalPages()].length;
		
		model.addAttribute("pages",new int[listebv.getTotalPages()]);
		model.addAttribute("pageactuel",page);
		model.addAttribute("nbrepage",nbrepage);
		model.addAttribute("id", id);
		
		model.addAttribute("bordereauvirement",listebv.getContent());
		return "listeBordereauVirement";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/editBV/{id}")
	public ModelAndView showEditBVForm(@PathVariable(name="id") long id) {
		ModelAndView mav=new ModelAndView("edit_carnetbordereauvirement");
		CarnetBordereauVirement carnetbordereauvirement= carnetbordereauvirementservice.get(id);
		mav.addObject("carnetbordereauvirement",carnetbordereauvirement);
		return mav;
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/deleteBV/{id}")
	public String deletebv(@PathVariable(name="id") long id) {
		CarnetBordereauVirement carnetbordereauvirement=carnetbordereauvirementservice.get(id);
		List<BordereauVirement> listbordereauvirement=bordereauvirementservice.search(id);
		for(int i=0;i<=carnetbordereauvirement.getNbreBV();i++) {
			bordereauvirementservice.delete(listbordereauvirement.get(i).getId());
		}
		carnetbordereauvirementservice.delete(id);
		return "redirect:/carnetbordereauvirements/listecarnetbordereauvirements";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/imprimerBV/{id}")
	public String imprimer(Model model,@PathVariable(name="id") long id) throws Exception {
		  String generer=carnetBordereauVirementReportservice.generateReport(id);  
		  CarnetBordereauVirement c = carnetBv.findById(id).get();
		  c.setStatCBV("imprimer");
		  Date d= new Date();
		  c.setDateImp(d);
		  carnetBv.save(c);
		  model.addAttribute("generer",generer);
		  return "report";
		 
		 
		
	
	}
	@PostMapping("/bvedit")
	public String BVStatus(EditCheque e) {
		System.out.println(e.getStatut());
		System.out.println(e.getIdcarnet());
		System.out.println(e.getIdcheque());
		Long id =Long.parseLong( e.getIdcheque());
		BordereauVirement b= bordereauVirementRepository.findById(id).get();
		b.setStatBV(e.getStatut());
		bordereauVirementRepository.save(b);
		
		return "redirect:/listbordereauvirement?id="+e.getIdcarnet()+"&page="+e.getPage();
	}
	@RequestMapping(value = "/listbordereauvirement/takedata",method = RequestMethod.GET)
	public String updateEmployer(Model model,@RequestParam(name = "idc") String idcarnet ,@RequestParam(name = "idch")  String idcheque){
		model.addAttribute("id",idcarnet);
		model.addAttribute("idch", idcheque);
		model.addAttribute("modal", "modal");
		model.addAttribute("exampleModal", "#exampleModal");
		System.out.println("idCarnet" +idcarnet);

		return "statuschange";
	}

	
	

}
