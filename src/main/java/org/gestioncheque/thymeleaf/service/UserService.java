package org.gestioncheque.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.User;
import org.springframework.data.domain.Page;

public interface UserService {
	public Page<User> listeUser(int pageble);
	public void addUser(User user);
	public void delete(long id);
	public Optional<User> get(long id);
	User findByUsernameOrEmail(String usernameOrEmail);
	User findByUserName(String userName);
	
}
