package org.gestioncheque.thymeleaf.repository;

import org.gestioncheque.thymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
   @Query("SELECT u FROM User u WHERE u.username=:usernameOrEmail OR u.email=:usernameOrEmail")
   User findByUsernameOrEmail(String usernameOrEmail);
   
   @Query("SELECT u FROM User u WHERE u.username=:userName")
   User findByUserName(String userName);
}

