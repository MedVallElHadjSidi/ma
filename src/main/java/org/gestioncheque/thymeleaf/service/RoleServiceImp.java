package org.gestioncheque.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.Role;
import org.gestioncheque.thymeleaf.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImp implements RoleService{
	
	  @Autowired RoleRepository roleRepository;

	@Override
	public List<Role> listeRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public void addRole(Role role) {
		roleRepository.save(role);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		roleRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Role> get(Integer id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

	

	
	  
	 
	 
}
