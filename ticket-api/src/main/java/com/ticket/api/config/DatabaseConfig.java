package com.ticket.api.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(value="com.ticket.api.mapper")
public class DatabaseConfig {
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setTypeAliasesPackage("com.ticket.api.domain");
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/*Mapper.xml"));
        sessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        sessionFactory.setVfs(SpringBootVFS.class);
        return sessionFactory.getObject();
    }
}