package com.adi.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Value("${cw_url}")
	//private String url="jdbc:mysql://3.6.53.159:3306/uat_erpdb?useUnicode=yes&characterEncoding=UTF-8";
	private String url;

	//@Value("${cw_username}")
	private String username="devuser";

	//@Value("${cw_password}")
	private String password="smarte#dev";

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		System.out.println("**************  this.getUrl() ::"+this.getUrl());
		dataSourceBuilder.url(this.getUrl());
		dataSourceBuilder.username(this.getUsername());
		dataSourceBuilder.password(this.getPassword());
		return dataSourceBuilder.build();
	}
}