package org.gestioncheque.thymeleaf.controller;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.Role;
import org.gestioncheque.thymeleaf.model.User;
import org.gestioncheque.thymeleaf.service.RoleService;
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
public class RoleController {
	@Autowired
	RoleService roleService;
	
	//@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/gestionRole")
	public String getlistuser(Model model){
		List<Role> listerole=roleService.listeRole();
		model.addAttribute("roles",listerole);
		return "gestionRole";
	}

	//@Secured(value={"ROLE_ADMIN"})
	/*
	 * @RequestMapping(value="/formrole",method=RequestMethod.GET) public String
	 * formcmp(Model model) { model.addAttribute("role",new Role()); return
	 * "gestionRole"; }
	 */
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/saveRole",method=RequestMethod.POST)
	public String saverole(Role role) {
		roleService.addRole(role);
		return "redirect:/roles/listeroles";
	}
	
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/editRole/{id}")
	public ModelAndView showEditRoleForm(@PathVariable(name="id") Integer id) {
		ModelAndView mav=new ModelAndView("editRole");
		Optional<Role> role=roleService.get(id);
		mav.addObject("role",role);
		return mav;
	}
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping("/deleteRole/{id}")
	public String deleteRole(@PathVariable(name="id") Integer id) {
		roleService.delete(id);
		return "redirect:/roles/listeroles";
	}
	

}
