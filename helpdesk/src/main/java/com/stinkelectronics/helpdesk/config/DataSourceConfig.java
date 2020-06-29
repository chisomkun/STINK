package com.stinkelectronics.helpdesk.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.url("jdbc:sqlserver://helpproject.database.windows.net;database=HelpProject")
				.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
				.username("users")
				.password("GroupStink1")
				.build();
	}
}
