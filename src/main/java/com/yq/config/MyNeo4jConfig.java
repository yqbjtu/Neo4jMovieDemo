/*
 */


package com.yq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.neo4j.ogm.session.SessionFactory;
/**
 * Simple to Introduction
 * className: MyNeo4jConfig
 *
 * @author yqbjtu
 * @version 2018/4/18 19:21
 */


@Configuration
@EnableNeo4jRepositories(basePackages = "com.yq.repository")
@EnableTransactionManagement
public class MyNeo4jConfig {

    @Bean
    public SessionFactory sessionFactory() {
        // with domain entity base package(s)
        return new SessionFactory("com.yq.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

}