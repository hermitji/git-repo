package com.example.demo.mybatisplus.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;


@Configuration
public class MybatisPlusConfig {

	private static final Logger log = LoggerFactory.getLogger(MybatisPlusConfig.class);
	@Autowired
	private DataSource dataSource;
	@Value("${mybatis-plus.global-config.id-type}")
	private Integer idType;
	@Value("${mybatis-plus.global-config.field-strategy}")
	private int fieldStrategy;
	@Value("${mybatis-plus.global-config.capital-mode}")
	private boolean capitalMode;
	@Value("${mybatis-plus.mapper-locations}")
	private String mapperLocations;
	@Value("${mybatis-plus.type-aliases-package}")
	private String typeAliasesPackage;
	@Value("${mybatis-plus.global-config.refresh-mapper}")
	private boolean refreshMapper;

	// mybatis plus 3  2.0完全不同 全局配置
	@Bean(name = "globalConfig")
	public GlobalConfig globalConfiguration() {
		//log.info("初始化GlobalConfiguration");
		GlobalConfig configuration = new GlobalConfig();
		DbConfig dbConfig = new DbConfig();
		dbConfig.setIdType(IdType.AUTO);
	    dbConfig.setDbType(DbType.MYSQL);
	    dbConfig.setCapitalMode(capitalMode);
	    configuration.setDbConfig(dbConfig);
 		// 主键策略
		configuration.setRefresh(refreshMapper);
		return configuration;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory createSqlSessionFactoryBean(
			@Qualifier(value = "globalConfig") GlobalConfig configuration,PaginationInterceptor paginationInterceptor) throws Exception {
		//log.info("初始化SqlSessionFactory");
		MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setGlobalConfig(configuration);
		Interceptor[] interceptor = { paginationInterceptor };
		sqlSessionFactoryBean.setPlugins(interceptor);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
			sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManager() {
		log.info("初始化transactionManager");
		return new DataSourceTransactionManager(dataSource);
	}
}
