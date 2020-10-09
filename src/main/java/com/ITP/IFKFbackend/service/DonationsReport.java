package com.ITP.IFKFbackend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ITP.IFKFbackend.model.Donations;
import com.ITP.IFKFbackend.repository.DonationsRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class DonationsReport {
	
	@Autowired
	private DonationsRepository donationsrepository;
	
	public String getReport() throws FileNotFoundException, JRException {
		
		   List<Donations> donations = donationsrepository.findAll();
		//Load a file
		
			String path = "C:\\Users\\Senath\\Desktop\\Reports";
		
	
			 File file = ResourceUtils.getFile("classpath:Donations.jrxml");
			 JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			 JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(donations);
			 Map<String, Object> parameters = new HashMap<>();
		     parameters.put("createdBy", "IFKF - Sri Lanka");
			 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			 JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\ Donations_Report.pdf");
			
			 return "Donations Report Downloaded Successfully in path "+path;
			
		
	}

}
