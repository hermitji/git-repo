package com.example.demo.mybatisplus.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;


@Configuration
@MapperScan(basePackages = "com.example.demo.mybatisplus.dao")
public class DataSourceConfiguration {
	
	@Bean(name="dataSource")
    @ConfigurationProperties(prefix="spring.datasource1")
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
