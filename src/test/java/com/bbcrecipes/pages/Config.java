package com.bbcrecipes.pages;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.bbcrecipes.pages","com.bbcrecipes.utils","com.bbcrecipes.spring","com.bbcrecipes.extensions"})
public class Config {
}
