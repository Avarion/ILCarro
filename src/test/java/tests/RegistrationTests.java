package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void registrationPositiveTest() {

        app.getUser().openRegistrationForm();

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().fillRegistrationForm("Dmitriy", "Peshkov", "avarion87" + i + "@gmail.com", "Illumiel1!");

        app.getUser().clickCheckBox();

        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLogged());

    }

    @Test
    public void registrationNegativeTestEmail() {

        app.getUser().openRegistrationForm();

        app.getUser().fillRegistrationForm("Dmitriy", "Peshkov", "avarion87gmail.com", "Illumiel1!");

        app.getUser().clickCheckBox();

        app.getUser().submitForm();

        app.getUser().closeWindowWithOk();

        Assert.assertFalse(app.getUser().isLogged());

    }

    @Test
    public void registrationNegativeTestPassword() {

        app.getUser().openRegistrationForm();

        app.getUser().fillRegistrationForm("Dmitriy", "Peshkov", "avarion87@gmail.com", "Illumiel1");

        app.getUser().clickCheckBox();

        app.getUser().submitForm();

        app.getUser().closeWindowWithOk();

        Assert.assertFalse(app.getUser().isLogged());

    }

    @AfterMethod
    public void postCondition() {
        app.getUser().clickOkButton();
    }

}
