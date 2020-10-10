package com.ITP.IFKFbackend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ITP.IFKFbackend.model.Session;
import com.ITP.IFKFbackend.repository.SessionRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class SessionReportService {

	@Autowired
	private SessionRepository sessionRepository;
	
	
	public String getSessionReport(String instructorId) throws FileNotFoundException, JRException {
		
	 String path = "D:\\IFKF - Reports";
     List<Session> session = sessionRepository.searchQuery(instructorId);

	//	Load file and compile it
	
	File file = ResourceUtils.getFile("classpath:sessions.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(session);
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("createdBy", "IFKF - Sri Lanka");
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
    
    JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Instructor_Session.pdf");
    
    return "Instructor Session Report Downloaded Successfully in path "+path;
    
	}
    
	
}
