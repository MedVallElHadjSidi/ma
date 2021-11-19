package org.gestioncheque.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.User;

public interface UserService {
	public List<User> listeUser();
	public void addUser(User user);
	public void delete(long id);
	public Optional<User> get(long id);
	User findByUsernameOrEmail(String usernameOrEmail);
	User findByUserName(String userName);
	
}
