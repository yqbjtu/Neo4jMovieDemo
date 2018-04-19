package com.yq;

//import org.neo4j.ogm.config.ClasspathConfigurationSource;
//import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

@org.springframework.context.annotation.Configuration
@EnableNeo4jRepositories("com.yq.repository")
@EntityScan(basePackages = "com.yq.domain")
@EnableTransactionManagement
public class Application {

	private final static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public SessionFactory sessionFactory() {
		// with domain entity base package(s)
		return new SessionFactory(configuration(), "com.yq.domain");
	}

	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		ConfigurationSource properties = new ClasspathConfigurationSource("ogm.properties");
		properties.properties().setProperty("","");
		properties.properties().setProperty("","");
		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder(properties).build();
		return configuration;
	}



	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}

}
