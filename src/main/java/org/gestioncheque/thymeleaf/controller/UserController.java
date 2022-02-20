package org.gestioncheque.thymeleaf.controller;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.model.Role;
import org.gestioncheque.thymeleaf.model.User;
import org.gestioncheque.thymeleaf.repository.RoleRepository;
import org.gestioncheque.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	RoleRepository roleRepository;
	//@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/gestionUtilisateur")
	public String getlistuser(Model model,@RequestParam(name = "page",defaultValue = "0") int page){
		
		List<Role> roles = roleRepository.findAll();
		model.addAttribute("roles", roles);
		Page<User> listeUser=userService.listeUser(page);
		int nbrepage = new int[listeUser.getTotalPages()].length;

		model.addAttribute("pages",new int[listeUser.getTotalPages()]);
		model.addAttribute("pageactuel",page);
		model.addAttribute("nbrepage",nbrepage);
		model.addAttribute("users",listeUser.getContent());
		
		
		return "gestionUtilisateur";
	}
	
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/formuser",method=RequestMethod.GET)
	public String formcmp(Model model) {
		model.addAttribute("user",new User());
		return "gestionUtilisateur";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public String saveuser(User user) {
		userService.addUser(user);
		return "redirect:/users/listeusers";
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/editUser/{id}")
	public ModelAndView showEditUserForm(@PathVariable(name="id") long id) {
		ModelAndView mav=new ModelAndView("editUser");
		Optional<User> user=userService.get(id);
		mav.addObject("user",user);
		return mav;
	}
	
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(name="id") long id) {
		userService.delete(id);
		return "redirect:/users/listeusers";
	}
	
	

}
