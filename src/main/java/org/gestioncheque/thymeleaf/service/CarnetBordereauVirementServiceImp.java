package org.gestioncheque.thymeleaf.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.gestioncheque.thymeleaf.model.BordereauVirement;
import org.gestioncheque.thymeleaf.model.CarnetBordereauVirement;
import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.model.CompteBordereauVirement;
import org.gestioncheque.thymeleaf.repository.CarnetBordereauVirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CarnetBordereauVirementServiceImp implements CarnetBordereauVirementService{
	@Autowired
	CarnetBordereauVirementRepository carnetbordereauvirementrepository;
	@Autowired
	CompteService compteServie;
	@Autowired
	BordereauVirementService bordereauvirementservice;
	@Autowired
	UserService userService;

	@Override
	public List<CarnetBordereauVirement> listeCarnetBordereauVirement() {
		// TODO Auto-generated method stub
		return carnetbordereauvirementrepository.findAll();
	}

	@Override
	public void addCarnetBordereauVirement(CarnetBordereauVirement cbv) {
		// TODO Auto-generated method stub
		String usernameCode =userService.findByUserName(getUserCode()).getCodeEmp() ;
		cbv.setStatCBV("Crée");
		cbv.setCodeEmp(usernameCode);
		 carnetbordereauvirementrepository.save(cbv);
		
		 long lastSec=getmaxsequence(cbv.getNumCli());
		 
		 long nextSec= lastSec+1;
		
		Compte cpteClient=compteServie.getCompteByNumcLi(cbv.getNumCli());
       List<BordereauVirement>  listeBordereauVirement=new ArrayList<>();
		for(int i=0;i<cbv.getNbreBV();i++) {
		BordereauVirement bordereauvirement = getNumBV(cpteClient, i, nextSec+Long.valueOf(i));	
		bordereauvirement.setNumCBV(cbv.getNumCBV());;
		bordereauvirement.setStatBV("cree");
		bordereauvirement.setSequence(nextSec+Long.valueOf(i));
		bordereauvirementservice.addBordereauVirement(bordereauvirement);
		
		listeBordereauVirement.add(bordereauvirement);
		}
	

	}
	

	@Override
	public CarnetBordereauVirement get(long numCBV) {
		// TODO Auto-generated method stub
		return carnetbordereauvirementrepository.findById(numCBV).get();
	}

	@Override
	public void delete(long numCBV) {
		// TODO Auto-generated method stub
		carnetbordereauvirementrepository.deleteById(numCBV);
	}

	@Override
	public List<Compte> search(Long keyword) {
		// TODO Auto-generated method stub
		return carnetbordereauvirementrepository.search(keyword);
	}

	@Override
	public Long getMaxId() {
if (carnetbordereauvirementrepository.getMaxId()==null) {
			
			return Long.valueOf(0);
		}
		return carnetbordereauvirementrepository.getMaxId();
		// TODO Auto-generated method stub
	}

	@Override
	public List<BordereauVirement> listebv(long keyword) {
		// TODO Auto-generated method stub
		return carnetbordereauvirementrepository.listebv(keyword);
	}

	@Override
	public String getlastnumbv(Long keyword) {
		// TODO Auto-generated method stub
		 BordereauVirement bordereauvirement=bordereauvirementservice.get(carnetbordereauvirementrepository.getlastnumcq(keyword));
		
			return bordereauvirement.getNumBV();
	}

	@Override
	public Long getmaxsequence(Long keyword) {
		 if (carnetbordereauvirementrepository.getmaxsequence(keyword)==null) {
				
				return Long.valueOf(0);
			}
		
		return carnetbordereauvirementrepository.getmaxsequence(keyword);
       
	}
	private String getUserCode() {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		   username =loggedInUser.getUsername();
		} else {
		   username = principal.toString();
		}
		return username;
	}
	private BordereauVirement getNumBV(Compte cpteClient, int i, long lastSec) { 
		BordereauVirement BordereauVirement=new BordereauVirement();
		String numbv;
		// verifier si orga ou particulier pour definir le numero de cheque
		if(cpteClient.getTypeCli().equals("Organisme")) { 
			 numbv = "1" + String.valueOf(cpteClient.getNumOrg())+constzero(lastSec,cpteClient)+ String.valueOf(lastSec);
			 BordereauVirement.setNumBV(numbv); 
			
		} 


		return  BordereauVirement;
	}
	public String constzero(long par, Compte cpteClient) {

		int cpt;
		String parcnvt= String.valueOf(par);

		if(cpteClient.getTypeCli().equals("Organisme")) {
			

			cpt = 11-parcnvt.length();
		

			return StringUtils.leftPad("",cpt, "0");
		} else {

			cpt = 7-parcnvt.length();

			return StringUtils.leftPad("",cpt, "0");


		}



	}

	@Override
	public List<CompteBordereauVirement> listebordereauvirementimp(Long keyword) {
		// TODO Auto-generated method stub
		return carnetbordereauvirementrepository.listebordereauvirementimp(keyword);
	}


}
