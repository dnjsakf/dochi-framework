package com.dochi.labs.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DatabaseConfig.class);

//    private Environment env = (Environment) SpringContext.getBean(StandardEnvironment.class);
    @Autowired
    Environment env;

    @Bean(name="sqlSessionFactory")
    @Autowired
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dbcon1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sb = new SqlSessionFactoryBean();
        String dbProduct = env.getProperty("db.product", "mysql");
        String resourcePath =String.format("classpath*:mapper/%s/*.xml", dbProduct);
        sb.setDataSource(dataSource);
        sb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(resourcePath));
        sb.setConfigLocation(new DefaultResourceLoader().getResource("classpath:conf/mybatis-config.xml"));
        return sb.getObject();
    }

}
