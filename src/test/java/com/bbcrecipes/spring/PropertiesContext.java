package com.bbcrecipes.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesContext {

    @Value("${selenium.webBrowser}")
    private String seleniumWebBrowser;

    @Bean("browser")
    public String getWebBrowser() {
        return seleniumWebBrowser;
    }
}
