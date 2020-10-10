package com.ITP.IFKFbackend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ITP.IFKFbackend.model.Instructor;
import com.ITP.IFKFbackend.repository.InstructorRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class InstructorDetailsReport {
	
	@Autowired
	private InstructorRepository repository;
	
	public String getReport() throws FileNotFoundException, JRException {
		
		   List<Instructor> instructors = repository.findAll();
		//Load a file
		
			String path = "C:\\Users\\Acer\\Desktop\\Reports";
		
	
			 File file = ResourceUtils.getFile("classpath:instructors.jrxml");
			 JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			 JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(instructors);
			 Map<String, Object> parameters = new HashMap<>();
		     parameters.put("createdBy", "IFKF - Sri Lanka");
			 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			 JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\ Instructors_Report.pdf");
			
			 return "Instructors Details Report Downloaded Successfully in path "+path;
			
		
	}

}
