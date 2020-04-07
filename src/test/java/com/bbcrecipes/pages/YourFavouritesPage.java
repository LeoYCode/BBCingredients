package com.bbcrecipes.pages;

import com.bbcrecipes.pages.component.MainMenuPagePart;
import com.bbcrecipes.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YourFavouritesPage extends MainMenuPagePart {

    @Autowired
    private WaitHelper waitHelper;

    private String PROMO_TITLE_CONTAINER = ".gel-layout__item.promo__title-container";

    public String getPromoTitle() {
        return webDriver.findElement(By.cssSelector(PROMO_TITLE_CONTAINER + " .promo__title")).getText();
    }

    public String getPromoSubtitle() {
        return webDriver.findElement(By.cssSelector(PROMO_TITLE_CONTAINER + " .promo__subtitle")).getText();
    }

    public YourFavouritesPage removeRecipe() {
        try {
            if (webDriver.findElement(By.cssSelector(PROMO_TITLE_CONTAINER)).isDisplayed()) {
                webDriver.findElement(By.cssSelector(".promo-footer__remove-button")).click();
                waitHelper.waitForPresenceOfElement(".promo-footer__confirm-button");
                webDriver.findElement(By.cssSelector(".promo-footer__confirm-button")).click();
            }
        } catch (NoSuchElementException e) {
           log.info("No recipes saved");
        }
        waitHelper.waitForPresenceOfElement(".no-recipes");
        return new YourFavouritesPage();
    }
}
