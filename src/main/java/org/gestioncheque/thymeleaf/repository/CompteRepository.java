package org.gestioncheque.thymeleaf.repository;

import org.gestioncheque.thymeleaf.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long>{
	
	
	@Query("select c from Compte c where c.numCli = :numCli")
	public Compte getCompteByNumcLi(@Param("numCli") long numCli );
	@Query("select c from Compte c where  c.numCpte = :numCpte")
	public Compte getCompteByNumcpte(@Param("numCpte") long numCpte );
}
