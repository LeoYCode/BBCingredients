package com.bbcrecipes.utils;

import com.bbcrecipes.spring.PropertiesContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ContextConfiguration(classes = {PropertiesContext.class})
public class DriverFactory {

    @Autowired
    private String browser;

    @Bean(name = "webDriver", destroyMethod = "quit")
    public WebDriver webDriver() {
        WebDriver driver = null;
        switch(browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser.toLowerCase());
        }
        return driver;
    }

    @Bean(name = "webDriverWait")
    public WebDriverWait webDriverWait() {
        WebDriverWait wait;
        wait = new WebDriverWait(webDriver(), 10);
        return wait;
    }
}
