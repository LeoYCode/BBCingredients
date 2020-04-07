package com.bbcrecipes.pages.component;

import com.bbcrecipes.pages.YourFavouritesPage;
import com.bbcrecipes.utils.Drivers;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class MainMenuPagePart extends Drivers {

    public YourFavouritesPage clickYourFavouritesButton() {
        webDriver.findElement(By.cssSelector(".main-menu__item.main-menu__item--favorites")).click();
        return new YourFavouritesPage();
    }
}
