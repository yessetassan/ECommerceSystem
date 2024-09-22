package com.yesko.user.configs;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
/**
 * LiquibaseConfig is a configuration class that sets up Liquibase for database migration in a Spring Boot application.
 * It reads configuration properties from `application.yml` or `application.properties` file and initializes
 * a SpringLiquibase bean.
 *
 * Properties:
 * - `changeLog`: Path to the Liquibase change log file that contains the database changesets.
 * - `dropFirst`: If true, Liquibase will drop the existing database schema before running the changesets.
 * - `enabled`: Flag indicating whether Liquibase should run or not.
 *
 * The `SpringLiquibase` bean is responsible for managing the database migrations based on the provided changelog file
 * and the configuration settings.
 */
@Configuration
public class LiquibaseConfig {

    @Value("${spring.liquibase.change-log}")
    private String changeLog;

    @Value("${spring.liquibase.drop-first}")
    private boolean dropFirst;

    @Value("${spring.liquibase.enabled}")
    private boolean enabled;


    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(changeLog);
        liquibase.setDropFirst(dropFirst);
        liquibase.setShouldRun(enabled);
        return liquibase;
    }
}
