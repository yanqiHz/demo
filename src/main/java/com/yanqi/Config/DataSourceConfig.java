package com.yanqi.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {

	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.one")
	@Primary //设置主数据源
	public DataSource dataSource(){
		return new DruidDataSource();
	}

	@Bean(name = "dataSourceTwo")
	@ConfigurationProperties(prefix = "spring.datasource.druid.two")
	public DataSource DataSourceOne(){
		return new DruidDataSource();
	}
	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean(name = "jdbcTemplate2")
	public JdbcTemplate jdbcTemplate2(@Qualifier("dataSourceTwo") DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
}
