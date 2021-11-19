package org.gestioncheque.thymeleaf.repository;

import java.util.List;

import org.gestioncheque.thymeleaf.model.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Long>{
	 @Query("select cq from Cheque cq where cq.numCC = :keyword ") 
     public List<Cheque> search(@Param("keyword") Long keyword );

}
