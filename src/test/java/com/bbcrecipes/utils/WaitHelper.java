package com.bbcrecipes.utils;

import com.bbcrecipes.pages.component.MainMenuPagePart;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class WaitHelper extends MainMenuPagePart {

    public void waitForPresenceOfElement(String element) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
    }

    public boolean urlMatches(String url) {
        return webDriverWait.until(ExpectedConditions.urlMatches(url));
    }
}
