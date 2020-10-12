package com.ITP.IFKFbackend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ITP.IFKFbackend.model.Student;
import com.ITP.IFKFbackend.repository.StudentRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class StudentDetailsReport {

	@Autowired
	private StudentRepository repository;
	
	public String getReport(String sessionId) throws FileNotFoundException, JRException {
		
		   List<Student> students = repository.findBysessionId(sessionId);
		//Load a file
		
			String path = "C:\\Users\\Acer\\Desktop\\Reports";
		
	
			 File file = ResourceUtils.getFile("classpath:students.jrxml");
			 JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			 JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);
			 Map<String, Object> parameters = new HashMap<>();
		     parameters.put("createdBy", "IFKF - Sri Lanka");
			 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			 JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\ Students_Report.pdf");
			
			 return "Students Details Report Downloaded Successfully in path "+path;
			
		
	}
}
