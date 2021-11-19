package org.gestioncheque.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.gestioncheque.thymeleaf.model.User;
import org.gestioncheque.thymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional(readOnly = true)
	public User findByUsernameOrEmail(String usernameOrEmail) {
		User user = null;
		try {
			user = userRepository.findByUsernameOrEmail(usernameOrEmail);
		} catch (Exception e) {
			throw e;
		}
		return user;
	}

	@Override
	public User findByUserName(String userName) {
		User user = null;
		try {
			user = userRepository.findByUsernameOrEmail(userName);
		} catch (Exception e) {
			throw e;
		}
		return user;
	}

	@Override
	public List<User> listeUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void addUser(User user) {
		String pswd = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(pswd);
		
		userRepository.save(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<User> get(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

}
