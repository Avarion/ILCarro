package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void searchCar() {

        User data5 = new User().withEmail("bogoborec87@gmail.com").withPassword("Illumiel1!");

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(data5);

        app.getUser().submitForm();

        app.getUser().closeWindowWithOk();

        app.getSearch().fillSearchFormForCar();

        app.getSearch().submitSearch();

        Assert.assertTrue(app.getSearch().isElementPresent(By.xpath("//div[@class='search-results']")));

    }

    @AfterMethod
    public void postCondition() {
        app.getUser().clickOkButton();
    }


}


