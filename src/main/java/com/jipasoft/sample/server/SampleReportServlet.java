package com.jipasoft.sample.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;

public class SampleReportServlet extends HttpServlet {
	private final Logger log = Logger.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) {

		String sourceFileName = this.getClass().getResource("/reports/rpt_test.jasper").getFile();
		InputStream resourceStream = this.getClass().getResourceAsStream("/reports/rpt_test.jasper");
		InputStream pdfStream = this.getClass().getResourceAsStream("/reports/rpt_test.jasper");
		File xlsFile = null;
		String output = null;
		JRDataSource jrDataSource = new JREmptyDataSource();
		ServletOutputStream servletOutputStream;
		JasperPrint jasperPrint = null;
		JRXlsExporter exporter = new JRXlsExporter();

		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			xlsFile = new File(this.getClass().getResource("/reports/").toURI());
			if (!xlsFile.exists()) {
				xlsFile.mkdirs();
			}
			String reportDestination = xlsFile.getAbsolutePath() + "/excel.xls";
			xlsFile = new File(reportDestination);

			resp.setContentType("application/pdf");
			servletOutputStream = resp.getOutputStream();
			JasperRunManager.runReportToPdfStream(pdfStream, servletOutputStream, parameters, jrDataSource);
			log.info("PDF report streamed");

			jasperPrint = JasperFillManager.fillReport(resourceStream, parameters);

			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, xlsFile);
			exporter.exportReport();
			log.info(reportDestination + " exported");

			output = JasperFillManager.fillReportToFile(sourceFileName, parameters, jrDataSource);
			log.info("report filled");

			output = JasperExportManager.exportReportToPdfFile(output);
			log.info(output + " exported");

			FileInputStream fis = new FileInputStream(new File(reportDestination));
			resp.setContentType("application/vnd.ms-excel");
			resp.setHeader("Content-Disposition", "attachment; filename=" + "excel.xls");
			IOUtils.copy(fis, resp.getOutputStream());
			log.info("download successful");

			fis.close();
			resp.flushBuffer();
			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (JRException | IOException | URISyntaxException e) {
			log.error(e.getMessage());
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

}
