package org.gestioncheque.thymeleaf.repository;
import java.util.List;

import org.gestioncheque.thymeleaf.model.BordereauVirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BordereauVirementRepository extends JpaRepository<BordereauVirement, Long>{
	 @Query("select bv from BordereauVirement bv where bv.numCBV = :keyword ") 
     public List<BordereauVirement > search(@Param("keyword") Long keyword );
	

}
