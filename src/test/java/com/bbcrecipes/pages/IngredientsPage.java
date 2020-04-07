package com.bbcrecipes.pages;

import com.bbcrecipes.pages.component.MainMenuPagePart;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class IngredientsPage extends MainMenuPagePart {

    private String allFeaturedIngredients = ".gel-layout.gel-layout--equal.promo-collection.standard .gel-layout__item";

    public String getIngredientTitle(int ingredientIndex) {
        return webDriver.findElements(By.cssSelector(allFeaturedIngredients + " .promo__title")).get(ingredientIndex).getText();
    }

    public String getIngredientSubTitle(int ingredientIndex) {
        return webDriver.findElements(By.cssSelector(allFeaturedIngredients + " .promo__subtitle")).get(ingredientIndex).getText();
    }

    public RecipesPages clickXFeaturedIngredient(int ingredientIndex) {
        webDriver.findElements(By.cssSelector(allFeaturedIngredients)).get(ingredientIndex).click();
        return new RecipesPages();
    }
}
