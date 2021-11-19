package org.gestioncheque.thymeleaf.repository;

import java.util.List;

import org.gestioncheque.thymeleaf.model.CarnetCheque;
import org.gestioncheque.thymeleaf.model.Cheque;
import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.model.CompteCheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CarnetChequeRepository extends JpaRepository<CarnetCheque, Long>{
	
	@Query("select c from Compte c where c.numCli = :keyword or c.numCpte = :keyword")
	public List<Compte> search(@Param("keyword") Long keyword );
	
	@Query("select Max(c.numCC) from CarnetCheque c")
	public Long getMaxId();
	
	@Query("select c from Cheque c,CarnetCheque cc where cc.numCC=c.numCC and cc.numCC = :keyword")
	public List<Cheque> listecheque(@Param("keyword") Long keyword );
	
	@Query("select Max(cq.id) FROM CarnetCheque cc , Compte cp , Cheque  cq WHERE  cc.numCli=cp.numCli and cq.numCC=cc.numCC and cp.numCli= :keyword")
	public Long getlastnumcq(@Param("keyword") Long keyword);
	
	@Query("select Max(cq.sequence) from CarnetCheque cc , Compte cp , Cheque  cq where  cc.numCli=cp.numCli and cq.numCC=cc.numCC and cp.numCli= :keyword")
	public Long getmaxsequence(@Param("keyword") Long keyword);
	
	
	  @Query("select new org.gestioncheque.thymeleaf.model.CompteCheque(cq.numCQ,cp.numCli,cp.nom) FROM CarnetCheque cc , Compte cp , Cheque  cq WHERE  cc.numCli=cp.numCli and cq.numCC=cc.numCC and cc.numCC= :keyword")
	  public List<CompteCheque> listechequeimp(@Param("keyword") long keyword);
	 
   
}
