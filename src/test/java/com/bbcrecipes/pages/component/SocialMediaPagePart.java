package com.bbcrecipes.pages.component;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class SocialMediaPagePart extends MainMenuPagePart {

    public void clickTwitterLink() {
        webDriver.findElement(By.cssSelector(".social-promo-twitter__wrapper")).click();
    }

    public void clickFacebookLink() {
        webDriver.findElement(By.cssSelector(".social-promo-facebook__wrapper")).click();
    }

    public void clickPinterestLink() {
        webDriver.findElement(By.cssSelector(".social-promo-pinterest__wrapper")).click();
    }
}
