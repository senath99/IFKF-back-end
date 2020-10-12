package com.ITP.IFKFbackend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ITP.IFKFbackend.model.Attendance;
import com.ITP.IFKFbackend.model.Payment;
import com.ITP.IFKFbackend.repository.attendanceRepository;
import com.ITP.IFKFbackend.repository.paymentRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class AttendanceReport {

		
		@Autowired
		private attendanceRepository repository;
		
		public String exportReport()throws FileNotFoundException, JRException {
			
			
				List<Attendance> attendance = repository.findAll();
			
				String path = "D:\\IFKF - Reports";
				
			
		
				 File file = ResourceUtils.getFile("classpath:Attendance.jrxml");
				 JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
				 JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(attendance);
				 Map<String, Object> parameters = new HashMap<>();
			     parameters.put("createdBy", "IFKF - Sri Lanka");
				 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
				 JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\Monthly_Attendance_Report.pdf");
				
				 return "Monthly attendance Report generated in path "+path;
				
			
		}

}
