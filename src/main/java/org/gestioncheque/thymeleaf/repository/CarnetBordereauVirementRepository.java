package org.gestioncheque.thymeleaf.repository;

import java.util.List;

import org.gestioncheque.thymeleaf.model.BordereauVirement;
import org.gestioncheque.thymeleaf.model.CarnetBordereauVirement;
import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.model.CompteBordereauVirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CarnetBordereauVirementRepository extends JpaRepository<CarnetBordereauVirement, Long>{
	          @Query("select c from Compte c where c.numCli = :keyword or c.numCpte = :keyword") 
	          public List<Compte> search(@Param("keyword") Long keyword );
			  
			  @Query("select Max(bv.numBV) from  BordereauVirement bv")
			  public Long getMaxId();
			  
			  @Query("select bv from BordereauVirement bv , CarnetBordereauVirement cbv where cbv.numCBV=bv.numCBV and  cbv.numCBV= :keyword")
			  public List<BordereauVirement> listebv(@Param("keyword") Long keyword  );
			  
			  @Query("select Max(bv.id) from CarnetBordereauVirement cbv , Compte cp , BordereauVirement  bv WHERE  cbv.numCli=cp.numCli and cbv.numCBV=bv.numCBV ") 
			  public Long getlastnumcq(@Param("keyword") Long keyword);
			  
			  @Query("select Max(bv.sequence) from CarnetBordereauVirement cbv , Compte cp , BordereauVirement  bv WHERE  cbv.numCli=cp.numCli and cbv.numCBV=bv.numCBV  and cp.numCli= :keyword") 
			  public Long getmaxsequence(@Param("keyword") Long keyword);
			  
			  @Query("select new org.gestioncheque.thymeleaf.model.CompteBordereauVirement(bv.numBV,cp.numCli,cp.nom) FROM CarnetBordereauVirement cbv , Compte cp , BordereauVirement bv  WHERE  cbv.numCli=cp.numCli and bv.numCBV=cbv.numCBV and cbv.numCBV= :keyword")
			  public List<CompteBordereauVirement> listebordereauvirementimp(@Param("keyword") long keyword);
			  
}
