package org.gestioncheque.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.Role;
import org.springframework.data.domain.Page;



public interface RoleService {
	public Page<Role> listeRole(int pageable);
	public void addRole(Role role);
	public void delete(Integer id);
	public Optional<Role> get(Integer id);
	/*
	 * public Role addUser(Role role); public List<Role> listUser();
	 */

}
