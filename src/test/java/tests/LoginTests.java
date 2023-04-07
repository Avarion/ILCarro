package tests;

import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(NGListener.class)
public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test(dataProvider = "loginModelDto", dataProviderClass = ProviderData.class)
    public void LoginPositiveTest(User data) {

//      User data = new User().withEmail("bogoborec87@gmail.com").withPassword("Illumiel1!");

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(data);

        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLogged());

    }
    @Test
    public void LoginPositiveTestPast() {

       User data = new User().withEmail("bogoborec87@gmail.com").withPassword("Illumiel1!");

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(data);

        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLogged());

    }

    @Test
    public void loginNegativeTestEmail() {

        User data1 = new User().withEmail("bogoborec87gmail.com").withPassword("Illumiel1!");

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(data1);

        app.getUser().submitForm();

        Assert.assertFalse(app.getUser().isLogged());

    }

    @Test
    public void loginNegativeTestPassword() {

        User data2 = new User().withEmail("bogoborec87@gmail.com").withPassword("Illumiel1");

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(data2);

        app.getUser().submitForm();

        Assert.assertFalse(app.getUser().isLogged());

    }

    @AfterMethod
    public void postCondition() {
        app.getUser().clickOkButton();
    }


}
