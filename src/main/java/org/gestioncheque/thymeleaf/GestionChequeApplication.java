package org.gestioncheque.thymeleaf;
import org.gestioncheque.thymeleaf.model.Role;
import org.gestioncheque.thymeleaf.model.User;
import org.gestioncheque.thymeleaf.repository.RoleRepository;
import org.gestioncheque.thymeleaf.repository.UserRepository;
import org.gestioncheque.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionChequeApplication implements CommandLineRunner {
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userservice;
	
	@Bean
	public BCryptPasswordEncoder getBCrypt() {
		return new BCryptPasswordEncoder();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(GestionChequeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Role role1=new Role("ADMIN"); Role role = roleRepository.save(role1);
		 * 
		 * User user=new
		 * User("Moulaye","Ahmed","Molaye","1234","ma@gmail.com","code",role);
		 * userservice.addUser(user);
		 * 
		 */
	
		 
	}
	
	
	
	 
}
