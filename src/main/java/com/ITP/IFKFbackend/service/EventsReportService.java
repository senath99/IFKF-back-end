package com.ITP.IFKFbackend.service;

import com.ITP.IFKFbackend.model.Events;
import com.ITP.IFKFbackend.repository.EventsRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventsReportService {

	@Autowired
    private EventsRepository eventsRepository;

    public String getEventReport() throws FileNotFoundException, JRException {

        //file path
        String path = "D:\\IFKF-Reports";

        List<Events> events = eventsRepository.findAll();

        //Load file and compile
        File file = ResourceUtils.getFile("classpath:events.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(events);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "IFKF - Sri Lanka");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        //export as pdf
        JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\Events_Report.pdf");

        return "report generated in path : " + path;

    }

}
