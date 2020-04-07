package com.bbcrecipes.pages.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class LoginPagePart extends MainMenuPagePart {

    public LoginPagePart enterEmail() {
        webDriver.findElement(By.cssSelector("#user-identifier-input")).sendKeys("testtest12345@gmail.com");
        return this;
    }

    public LoginPagePart enterPassword() {
        WebElement passwordInputField = webDriver.findElement(By.cssSelector("#password-input"));
        passwordInputField.click();
        passwordInputField.sendKeys("Testing123");
        return this;
    }

    public void clickSubmit() {
        webDriver.findElement(By.cssSelector("button#submit-button")).click();
    }
}
