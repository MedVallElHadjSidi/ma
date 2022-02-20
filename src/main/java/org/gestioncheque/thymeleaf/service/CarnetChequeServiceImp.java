package org.gestioncheque.thymeleaf.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.gestioncheque.thymeleaf.model.CarnetCheque;
import org.gestioncheque.thymeleaf.model.Cheque;
import org.gestioncheque.thymeleaf.model.Compte;
import org.gestioncheque.thymeleaf.model.CompteCheque;
import org.gestioncheque.thymeleaf.repository.CarnetChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;



@Service
public class CarnetChequeServiceImp implements CarnetChequeService{
	@Autowired
	CarnetChequeRepository carnetchequerepository;
	@Autowired
	ChequeService chequeService;

	@Autowired
	CompteService compteServie;
	
	@Autowired
	UserService userService;
	
	@Override
	public Page<CarnetCheque> listeCarnetCheque(int page) {
		// TODO Auto-generated method stub
		 return carnetchequerepository.findAll(PageRequest.of(page,5));
	}

	@Override
	public void addCarnetCheque(CarnetCheque ccq) {
		// on recupere l'id du carnet de cheque creé et puis tu crees les cheques associés	
		// iterer selon le nombre de cheques defini dans le carnet
		
		
		//ccq.setDateEmi(null);
		//ccq.setDateImp(null);
		//ccq.setListeCheques(listeCheques);
		// recuperer la personne connectée pour avoir son num employé
		
//		 String usernameCode =userService.findByUserName(getUserCode()).getCodeEmp() ;
//		
//		
//		System.out.print("test user connected : "+ usernameCode);	
		//long IdCarnetCheque = getMaxId()+ccq.getNbreCQ()+1;
		// String lastNumcq=getlastnumcq(ccq.getNumCli());
		 ccq.setStatCC("Cree");
		Date d1 = new Date();
		ccq.setDateCre(d1);
//		 ccq.setCodeEmp(usernameCode);
		
		 carnetchequerepository.save(ccq);
		
		 long lastSec=getmaxsequence(ccq.getNumCli());
		 
		 long nextSec= lastSec+1;
		
		Compte cpteClient=compteServie.getCompteByNumcLi(ccq.getNumCli());
        List<Cheque>  listeCheques=new ArrayList<>();
		for(int i=0;i<ccq.getNbreCQ();i++) {
		Cheque cheque = getNumChek(cpteClient, i, nextSec+Long.valueOf(i));	
		cheque.setNumCC(ccq.getNumCC());
		cheque.setStatCQ("cree");
		cheque.setSequence(nextSec+Long.valueOf(i));
		chequeService.addCheque(cheque);
		
		listeCheques.add(cheque);
		}
	

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
	

	
	private Cheque getNumChek(Compte cpteClient, int i, long lastSec) { 
		Cheque cheque=new Cheque();
		String numchek;
		// verifier si orga ou particulier pour definir le numero de cheque
		if(cpteClient.getTypeCli().equals("Organisme")) { 
			 numchek = "1" + String.valueOf(cpteClient.getNumOrg())+  constzero(lastSec,cpteClient)+ String.valueOf(lastSec);
			cheque.setNumCQ(numchek); 
			
		} 

		else { 
			 
			numchek="1" + String.valueOf(cpteClient.getNumCpte())+  constzero(lastSec,cpteClient)+ String.valueOf(lastSec);
			
		    cheque.setNumCQ(numchek); 

		}

		return cheque;
	}


	@Override
	public CarnetCheque get(long numCCQ) {
		// TODO Auto-generated method stub
		return carnetchequerepository.findById(numCCQ).get();
	}

	@Override
	public void delete(long numCCQ) {
		// TODO Auto-generated method stub
		carnetchequerepository.deleteById(numCCQ);
		
	}

	@Override
	public List<Compte> search(Long keyword) {
		// TODO Auto-generated method stub
		return carnetchequerepository.search(keyword);
	}

	@Override
	public Long getMaxId() {
    if (carnetchequerepository.getMaxId()==null) {
			
			return Long.valueOf(0);
		}
		return  carnetchequerepository.getMaxId();
	}


	@Override
	public List<Cheque> listecheque(long keyword) {
		// TODO Auto-generated method stub
		return carnetchequerepository.listcheque(keyword);
	}
	@Override
	public Page<Cheque> listecheques(long id,int page) {
		// TODO Auto-generated method stub
		return carnetchequerepository.listcheques(id,PageRequest.of(page,7));
	}

	@Override
	public String getlastnumcq(Long keyword) {
		// TODO Auto-generated method stub
		// get cheque by id 
		 Cheque cheque=chequeService.get(carnetchequerepository.getlastnumcq(keyword));
		
		return cheque.getNumCQ();
	}

	
	/*
	 * private Cheque getSequence(String lastNumcq, Compte cpteClient, int i,long
	 * lastSec) {
	 * 
	 * String lastSequence; String nextSequence; Cheque cheque=new Cheque();
	 * 
	 * if (null!=lastNumcq && !lastNumcq.isEmpty()) { // verifier si orga ou
	 * particulier pour definir le numero de cheque
	 * if(cpteClient.getTypeCli().equals("Organisme")) { // on va recuperer la
	 * sequence lastSequence=(String) lastNumcq.subSequence(5, lastNumcq.length());
	 * String numchek = "1" + String.valueOf(cpteClient.getNumOrg())+
	 * constzero(lastSec)+ String.valueOf(i+1); cheque.setNumCQ(numchek);
	 * System.out.print(getMaxId()); } else { String numchek =
	 * String.valueOf(cpteClient.getNumCpte())+String.valueOf(i+1);
	 * cheque.setNumCQ(numchek); System.out.print(getMaxId()); }
	 * 
	 * 
	 * } else { if(cpteClient.getTypeCli().equals("Organisme")) {
	 * nextSequence="0000000000"; String numchek = "1" +
	 * String.valueOf(cpteClient.getNumOrg())+ constzero(lastSec)+
	 * String.valueOf(i+1); cheque.setNumCQ(numchek); } else { String numchek =
	 * String.valueOf(cpteClient.getNumCpte())+String.valueOf(i+1);
	 * cheque.setNumCQ(numchek); System.out.print(getMaxId()); } } return cheque;
	 * 
	 * 
	 * 
	 * }
	 */

	@Override
	public Long getmaxsequence(Long keyword) {
		// TODO Auto-generated method stub
		 if (carnetchequerepository.getmaxsequence(keyword)==null) {
				
				return Long.valueOf(0);
			}
		
		return carnetchequerepository.getmaxsequence(keyword);
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
	public List<CompteCheque> listechequeimp(@Param("keyword") Long keyword) {
		// TODO Auto-generated method stub
		return  carnetchequerepository.listechequeimp(keyword);
	}

}
