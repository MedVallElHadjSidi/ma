package org.gestioncheque.thymeleaf.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gestioncheque.thymeleaf.model.CompteCheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service

public class CarnetChequeReportService {
	@Autowired
	CarnetChequeService carnetChequeService;
	
	

	public String generateReport(long keyword) {
		try {
			List<CompteCheque> compteChequeList = carnetChequeService.listechequeimp(keyword);

			/*
			 * String reportPath = "C:\\Users\\Amadou\\Desktop"; C:\Users\MOULAYE
			 * AHMED\Desktop
			 */
			String reportPath =  "C:\\Users\\MOULAYE AHMED\\Desktop";
			
			
			// Compile the Jasper report from .jrxml to .japser 
			//JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Dev\\Gestion-Cheque\\src\\main\\resources\\carnetCheque.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport("D:\\Projet\\Gestion-Cheque-copie\\Gestion-Cheque-copie\\src\\main\\resources\\carnetCheque.jrxml");
             System.out.println(jasperReport);
			// Get your data source
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(compteChequeList);

			// Add parameters
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "Websparrow.org");

			// Fill the report
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					jrBeanCollectionDataSource);

			// Export the report to a PDF file
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "//CC-Rpt.pdf");

			System.out.println("Done");

			return "Report successfully generated @path= " + reportPath;

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
