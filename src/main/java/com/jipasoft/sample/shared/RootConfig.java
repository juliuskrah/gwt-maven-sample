package com.jipasoft.sample.shared;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
@ComponentScan(basePackages = { "com.jipasoft.sample" })
public class RootConfig {
	private final Logger log = Logger.getLogger(this.getClass());

	@Bean
	public JasperReportsViewResolver getJasperReportsViewResolver() {
		JasperReportsViewResolver reportResolver = new JasperReportsViewResolver();
		reportResolver.setPrefix("classpath:/reports/");
		reportResolver.setSuffix(".jasper");
		reportResolver.setReportDataKey("datasource");
		reportResolver.setViewNames(new String[] { "rpt_*" });
		reportResolver.setViewClass(JasperReportsMultiFormatView.class);
		reportResolver.setOrder(0);

		log.info("JasperReportsViewResolver initialized");
		return reportResolver;
	}
}
