package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void LoginPositiveTest() {

        User data = new User().withEmail("bogoborec87@gmail.com").withPassword("Illumiel1!");

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(data);
//      app.getUser().fillLoginRegistrationForm("bogoborec87@gmail.com", "Illumiel1!");

        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLogged());

    }

    @Test
    public void loginNegativeTestEmail() {

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm("bogoborec87gmail.com", "Illumiel1!");

        app.getUser().submitForm();

        Assert.assertFalse(app.getUser().isLogged());

    }

    @Test
    public void loginNegativeTestPassword() {

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm("bogoborec@gmail.com", "Illumiel1");

        app.getUser().submitForm();

        Assert.assertFalse(app.getUser().isLogged());

    }

    @AfterMethod
    public void postCondition() {
        app.getUser().clickOkButton();
    }


}
