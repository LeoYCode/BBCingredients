package com.bbcrecipes.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {DriverFactory.class})
public class Drivers {

    public static final Logger log = LoggerFactory.getLogger(Drivers.class);

    @Autowired
    public WebDriver webDriver;

    @Autowired
    public WebDriverWait webDriverWait;
}
