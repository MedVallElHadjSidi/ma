package org.gestioncheque.thymeleaf.controller;

import java.util.List;

import org.gestioncheque.thymeleaf.form.ChequeForm;
import org.gestioncheque.thymeleaf.model.BordereauVirement;
import org.gestioncheque.thymeleaf.model.CarnetCheque;
import org.gestioncheque.thymeleaf.model.Cheque;
import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.repository.ChequeRepository;
import org.gestioncheque.thymeleaf.repository.CompteRepository;
import org.gestioncheque.thymeleaf.service.CarnetChequeReportService;
import org.gestioncheque.thymeleaf.service.CarnetChequeService;
import org.gestioncheque.thymeleaf.service.ChequeService;
import org.gestioncheque.thymeleaf.service.CompteService;
import org.gestioncheque.thymeleaf.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

public class CarnetChequeController {
	@Autowired
	CarnetChequeService carnetchequeservice;
	@Autowired
	CompteService compteservice;
	@Autowired
	ChequeService chequeservice;
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	ChequeRepository chequeRepository;
	
	@Autowired
	CarnetChequeReportService carnetChequeReportService;
	@Autowired
	ReportService reportService;
	//@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/ajoutercarnetcheque")
	public String ajoutcarnetcheque() {
		return "AjoutCarnetCheque";
	}
	//@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/gestionCheque")
	public String getlistcarnetcheque(Model model,@RequestParam(name = "page",defaultValue = "0") int page) {
		List<Compte> comptes = compteRepository.findAll();
		model.addAttribute("comptes", comptes);
		Page<CarnetCheque> listeCCQ=carnetchequeservice.listeCarnetCheque(page);
		int nbrepage = new int[listeCCQ.getTotalPages()].length;
		
		model.addAttribute("pages",new int[listeCCQ.getTotalPages()]);
		model.addAttribute("pageactuel",page);
		model.addAttribute("nbrepage",nbrepage);
		model.addAttribute("carnetcheques",listeCCQ.getContent());
		
		
		return "GestionChequeMenu";
	}
	//@Secured(value={"ROLE_ADMIN"})
	/*
	 * @RequestMapping(value="/formcarnetcheque",method=RequestMethod.GET) public String formccq(Model model) {
	 * 
	 * List<Compte> comptes = compteRepository.findAll();
	 * model.addAttribute("comptes", comptes); return "GestionChequeMenu"; }
	 */
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/SaveCarnetCheque",method=RequestMethod.POST)
	public String savecq(CarnetCheque ccq) {
		System.out.println("numero carnet" + ccq.getNumCC());
		System.out.println("numero client" + ccq.getNumCli());
		System.out.println("number cheque" + ccq.getNbreCQ());
		carnetchequeservice.addCarnetCheque(ccq);
		return "redirect:gestionCheque";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/editCC/{id}")
	public ModelAndView showEditCarnetForm(@PathVariable(name="id") long id) {
		ModelAndView mav=new ModelAndView("edit_carnetcheque");
		CarnetCheque carnetcheque=carnetchequeservice.get(id);
		mav.addObject("carnetcheque",carnetcheque);
		return mav;
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/deleteCC/{id}")
	public String deletecheque(@PathVariable(name="id") long id) {
		CarnetCheque carnetcheque=carnetchequeservice.get(id);
		List<Cheque> listcheque=chequeservice.search(id);
		for(int i=0;i<=carnetcheque.getNbreCQ();i++) {
	    chequeservice.delete(listcheque.get(i).getId());
		}
	    carnetchequeservice.delete(id);
		return "redirect:/gestionCheque";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@GetMapping("/search")
	public String search(Model model, @Param("keyword") Long keyword) {
	
		List<Compte> listeCpte=carnetchequeservice.search(keyword);
		System.out.print("Taille liste cpte : " + listeCpte.size());
		if (listeCpte.size()==0) {
			
			model.addAttribute("error", "Compte inexistant");
			
			return "redirect:ajoutercarnetcheque";
		} 
		
		model.addAttribute("compte",listeCpte.get(0));
		model.addAttribute("keyword", keyword);
		model.addAttribute("carnetCheque",new CarnetCheque());
		return "ListeCompteCarnetCheque";
	}
	//@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/listcheque")
	public String listecheque(Model model,@RequestParam(name="id") long id,@RequestParam(name = "page",defaultValue = "0") int page) {
		Page<Cheque> listeChq=carnetchequeservice.listecheques(id,page);
		
		
	      int nbrepage = new int[listeChq.getTotalPages()].length;
			
			model.addAttribute("pages",new int[listeChq.getTotalPages()]);
			model.addAttribute("pageactuel",page);
			model.addAttribute("nbrepage",nbrepage);
			model.addAttribute("id",id);
		
		model.addAttribute("cheque",listeChq.getContent());
		return "listeCheque";
	}

	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/imprimerCC/{id}")
	public String imprimer(Model model,@PathVariable(name="id") long id) throws Exception {
	 
		
		/*
		 * reportService.exportreport(id); return "listeCheque";
		 */
		 
		
		
		  String generer=carnetChequeReportService.generateReport(id); List<Cheque>
		  listeChq=carnetchequeservice.listecheque(id);
		  model.addAttribute("cheque",listeChq); model.addAttribute("generer",generer);
		  
		  return "report";
	}
	
	
	@PostMapping("/listcheque/chequeedit")
	public String BVStatus(ChequeForm e) {
		System.out.println(e.getStatut());
		System.out.println(e.getIdcarnet());
		System.out.println(e.getIdcheque());
		Long id =Long.parseLong( e.getIdcheque());
		Cheque c= chequeRepository.findById(id).get();
		c.setStatCQ(e.getStatut());
		chequeRepository.save(c);
		
		return "redirect:/cheques/listecheques";
	}
	@RequestMapping(value = "/listcheque/takedata",method = RequestMethod.GET)
	public String updateEmployer(Model model,@RequestParam(name = "idc") String idcarnet ,@RequestParam(name = "idch")  String idcheque){
		model.addAttribute("id",idcarnet);
		model.addAttribute("idch", idcheque)	;
		model.addAttribute("modal", "modal");
		model.addAttribute("exampleModal", "#exampleModal");
		System.out.println("idCarnet" +idcarnet);

		return "statutchange";
	}
	
	
}
