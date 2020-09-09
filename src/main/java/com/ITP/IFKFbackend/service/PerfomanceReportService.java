package com.ITP.IFKFbackend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ITP.IFKFbackend.model.Rankings;
import com.ITP.IFKFbackend.model.Results;
import com.ITP.IFKFbackend.repository.RankingsRepository;
import com.ITP.IFKFbackend.repository.ResultsRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PerfomanceReportService {
	
	@Autowired
	private RankingsRepository rankingsRepository;
	
	@Autowired
	private ResultsRepository resultsRepository;
	
	
	public String getRankingReport(String studentId) throws FileNotFoundException, JRException {
		
		String path = "D:\\IFKF - Reports";
		
		List<Rankings> rankings = rankingsRepository.findBystudentId(studentId);
		
//		Load file and compile it
		
		File file = ResourceUtils.getFile("classpath:rankings.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(rankings);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "IFKF - Sri Lanka");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\"+studentId+"_Ranking_Report.pdf");
		
		return "Rankings Report Downloaded Successfully in path "+path;
		
	}
	
	
	
	
	public String getResultsReport(String studentId) throws FileNotFoundException, JRException {
		
		String path = "D:\\IFKF - Reports";
		
		List<Results> results = resultsRepository.findBystudentId(studentId);
		
//		Load file and compile it
		
		File file = ResourceUtils.getFile("classpath:results.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "IFKF - Sri Lanka");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\"+studentId+"_Performance_Report.pdf");
		
		return "Performance Report Downloaded Successfully in path "+path;
		
	}
	
	
	
	public String getExamReport(String examCode) throws FileNotFoundException, JRException {
		
		String path = "D:\\IFKF - Reports";
		
		List<Results> results = resultsRepository.findByexamCode(examCode);
		
//		Load file and compile it
		
		File file = ResourceUtils.getFile("classpath:gradingExam.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "IFKF - Sri Lanka");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\"+examCode+"_Certification_Report.pdf");
		
		return "Certification Report Downloaded Successfully in path "+path;
		
	}
	
	
	
	
	
	

}
