package com.ITP.IFKFbackend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ITP.IFKFbackend.model.Payment;
import com.ITP.IFKFbackend.repository.paymentRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class PaymentReport {
	
	@Autowired
	private paymentRepository repository;
	
	public String exportReport(String studentID)throws FileNotFoundException, JRException {
		
		
			List<Payment> payments = repository.findBystudentID(studentID);
		
			String path = "D:\\IFKF - Reports";
			
		
	
			 File file = ResourceUtils.getFile("classpath:Payments.jrxml");
			 JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			 JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(payments);
			 Map<String, Object> parameters = new HashMap<>();
		     parameters.put("createdBy", "IFKF - Sri Lanka");
			 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			 JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\"+studentID+"_Payments_Report.pdf");
			
			 return "Monthly payments Report generated in path "+path;
			
		
	}

}
