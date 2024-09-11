package com.yesko.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {
    /*
    Здесь будет спринг конфигураций
     */
    /**
     * This method defines a Spring bean for RestTemplate, which is used to make RESTful HTTP requests.
     * The RestTemplate object provides convenient methods to interact with external REST services,
     * such as making GET, POST, PUT, and DELETE requests. By marking this method with @Bean,
     * Spring will manage the lifecycle of the RestTemplate and inject it wherever needed.
     *
     * @return a new instance of RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
