package com.bbcrecipes;

import com.bbcrecipes.extensions.JunitTestRule;
import com.bbcrecipes.pages.Config;
import com.bbcrecipes.pages.IngredientsPage;
import com.bbcrecipes.pages.RecipesPages;
import com.bbcrecipes.pages.YourFavouritesPage;
import com.bbcrecipes.pages.component.LoginPagePart;
import com.bbcrecipes.pages.component.SocialMediaPagePart;
import com.bbcrecipes.utils.Drivers;
import com.bbcrecipes.extensions.JunitTestWatcher;
import com.bbcrecipes.utils.WaitHelper;
import org.junit.ClassRule;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@Tag("recipes")
@SpringJUnitConfig(Config.class)
@ExtendWith({JunitTestWatcher.class, SpringExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecipesPageTest extends Drivers {

    @Autowired
    private IngredientsPage ingredientsPage;

    @Autowired
    private RecipesPages recipesPages;

    @Autowired
    private SocialMediaPagePart socialMediaPagePart;

    @Autowired
    private YourFavouritesPage yourFavouritesPage;

    @Autowired
    private WaitHelper waitHelper;

    @Autowired
    private LoginPagePart loginPagePart;

    @ClassRule
    public static final JunitTestRule junitTestRule = new JunitTestRule();

    @BeforeAll
    public void setupAll() {
        webDriver.get("https://account.bbc.com/signin");
        loginPagePart
                .enterEmail()
                .enterPassword()
                .clickSubmit();
    }

    @BeforeEach()
    public void setup() {
        webDriver.get("https://www.bbc.co.uk/food/halloumi_cheese");
    }

    @Test
    @DisplayName("Ingredients added to favourites are displayed")
    public void addToFavouritesDisplayed() {
        int indexOfIngredient = 1; //Chunky halloumi chips
        String ingredientTitle = ingredientsPage.getIngredientTitle(indexOfIngredient);
        String ingredientSubTitle = ingredientsPage.getIngredientSubTitle(indexOfIngredient);

        ingredientsPage.clickXFeaturedIngredient(indexOfIngredient);
        recipesPages.clickAddToFavouritesButton();
        ingredientsPage.clickYourFavouritesButton();

        assertEquals(ingredientTitle, yourFavouritesPage.getPromoTitle());
        assertEquals(ingredientSubTitle, yourFavouritesPage.getPromoSubtitle());
    }

    @Test
    @DisplayName("Twitter link directs user to twitter page")
    public void followBBCFoodTwitterLink() {
        int indexOfIngredient = 1; //Chunky halloumi chips
        ingredientsPage.clickXFeaturedIngredient(indexOfIngredient);

        socialMediaPagePart.clickTwitterLink();
        assertTrue(waitHelper.urlMatches("https://twitter.com/BBCFood"));
    }

    @Test
    @DisplayName("Facebook link directs user to facebook page")
    public void followBBCFoodFacebookLink() {
        int indexOfIngredient = 1; //Chunky halloumi chips
        ingredientsPage.clickXFeaturedIngredient(indexOfIngredient);

        socialMediaPagePart.clickFacebookLink();
        assertTrue(waitHelper.urlMatches("https://www.facebook.com/bbcfood"));
    }

    @Test
    @DisplayName("Pinterest link directs user to Pinterest page")
    public void followBBCFoodPinterestLink() {
        int indexOfIngredient = 1; //Chunky halloumi chips
        ingredientsPage.clickXFeaturedIngredient(indexOfIngredient);

        socialMediaPagePart.clickPinterestLink();
        assertTrue(waitHelper.urlMatches("https://www.pinterest.co.uk/bbcfood"));
    }
}
