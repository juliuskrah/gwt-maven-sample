package com.jipasoft.sample.server.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JREmptyDataSource;

@Controller
@RequestMapping("springGwtServices")
public class ReportController {
	private final Logger log = Logger.getLogger(this.getClass());

	@RequestMapping("/rptUserReport")
	public String generateReport(final Model model) {
		model.addAttribute("datasource", new JREmptyDataSource());
		model.addAttribute("format", "pdf");

		log.info("Report Test Executed");
		return "rpt_test";

	}

}
