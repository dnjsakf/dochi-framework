package com.dochi.labs.common.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig implements TransactionManagementConfigurer {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DatabaseConfig.class);

    @Autowired
    Environment env;

    @Bean(name="dbcon1")
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        try{
            ds.setDriverClassName(env.getProperty("db.driverClassName"));
            ds.setUrl(env.getProperty("db.url"));
            ds.setUsername(env.getProperty("db.username"));
            ds.setPassword(env.getProperty("db.password"));
            ds.setMaxTotal(Integer.parseInt(env.getProperty("db.maxTotal")));
            ds.setInitialSize(Integer.parseInt(env.getProperty("db.initialSize")));
            ds.setMaxIdle(Integer.parseInt(env.getProperty("db.maxIdle")));
            ds.setMaxWaitMillis(Long.parseLong(env.getProperty("db.maxWaitMillis")));
            ds.setNumTestsPerEvictionRun(Integer.parseInt(env.getProperty("db.numTestsPerEvictionRun")));
            ds.setMinEvictableIdleTimeMillis(Long.parseLong(env.getProperty("db.minEvictableIdleTimeMillis")));
            ds.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getProperty("db.timeBetweenEvictionRunsMillis")));
            ds.setTestOnBorrow(Boolean.parseBoolean(env.getProperty("db.testOnBorrow")));
            ds.setTestWhileIdle(Boolean.parseBoolean(env.getProperty("db.testWhileIdle")));
            ds.setValidationQuery(env.getProperty("db.validationQuery"));
            ds.setValidationQueryTimeout(Integer.parseInt(env.getProperty("db.timeout")));
            ds.setDefaultAutoCommit(Boolean.parseBoolean(env.getProperty("db.defaultAutoCommit")));
            ds.setConnectionProperties("SetBigStringTryClob=true;");

        } catch(Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Bean(name="txManager")
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

//    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }
}

