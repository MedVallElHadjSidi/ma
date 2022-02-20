package org.gestioncheque.thymeleaf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements  WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {  
		registry.addViewController("/login").setViewName("login");
		//registry.addViewController("/welcome").setViewName("welcome");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/gestionCompte").setViewName("GestionCompteMenu");
		registry.addViewController("/gestionCheque").setViewName("GestionChequeMenu");
		registry.addViewController("/gestionBordereauVirement").setViewName("GestionBordereauVirementMenu");
		registry.addViewController("/gestionUtilisateur").setViewName("gestionUtilisateur");
		registry.addViewController("/gestionRole").setViewName("gestionRole");
		//registry.addViewController("/gestionUser").setViewName("gestionUser");
//        registry.addViewController("/").setViewName("gestionCompte");
        registry.addViewController("/formCompte").setViewName("formCompte");
        registry.addViewController("/gs").setViewName("chequestatus");
        registry.addViewController("/gch").setViewName("chequeslist");
	}
}