package tests;

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
    public void searchCar(){

//        User data = new User().withEmail("bogoborec87@gmail.com").withPassword("Illumiel1!");
//
//        app.getUser().openLoginRegistrationForm();
//
//        app.getUser().fillLoginRegistrationForm(data);
//
//        app.getUser().submitForm();

        app.getSearch().fillSearchFormForCar();

//        app.getSearch().submitSearch();

    }

    @AfterMethod
    public void postCondition() {
        app.getUser().clickOkButton();
    }



}


