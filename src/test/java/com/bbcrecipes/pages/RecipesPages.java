package com.bbcrecipes.pages;

import com.bbcrecipes.pages.component.MainMenuPagePart;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class RecipesPages extends MainMenuPagePart {

    public void clickAddToFavouritesButton() {
        webDriver.findElement(By.cssSelector("button#add-to-favourites-button")).click();
    }
}
