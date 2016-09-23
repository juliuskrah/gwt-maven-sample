package com.jipasoft.sample.shared;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataConfig {
	private final Logger log = Logger.getLogger(this.getClass());

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(final DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	public DataSource getDataSource() {
		final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		// @formatter:off
		final EmbeddedDatabase db = builder
				.setName("testdb")
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/sql/create-db.sql")
				.addScript("db/sql/insert-data.sql")
				.build();
		// @formatter:on
		log.info("database created");
		return db;
	}

	@PostConstruct
	public void startDBManager() {}
}
