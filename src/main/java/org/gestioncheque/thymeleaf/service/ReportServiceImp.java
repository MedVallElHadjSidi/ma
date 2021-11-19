package org.gestioncheque.thymeleaf.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.gestioncheque.thymeleaf.model.CompteCheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
@Service
public class ReportServiceImp implements ReportService{
	@Autowired
	CarnetChequeService carnetChequeService;

	
	  public String exportreport(long numcc) throws Exception{ 
		
		  List<CompteCheque> listechequeimp=carnetChequeService.listechequeimp(numcc); 
		
			java.io.File file = null;
			
				file = ResourceUtils.getFile("classpath:carnetCheque.jrxml");
			
		
			JasperReport jasperReport = null;
			
				jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			
			
			JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(listechequeimp);
			Map<String,Object> parameters=new HashMap<>();
			parameters.put("createdBy", "Amadou");
			
				JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameters, dataSource);
				JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\Amadou\\Desktop"+"\\carnetCheque.pdf");
			
		
		 
	  return "success"; 
	  }


	
	 

}
