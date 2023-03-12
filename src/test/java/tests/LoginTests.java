package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

//   @BeforeMethod
//   public void preCondition() {
//        if (app.getUser().isLogged()) {
//            app.getUser().logout();
//        }
//    }

    @Test
    public void LoginPositiveTest(){

        app.getUser().openLoginRegistrationForm();

        String email = "bogoborec87@gmail.com";
        String password = "Illumiel1!";

        app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isLogged());

    }

    @AfterMethod
    public void tearDown() {
//        // wd.quit();
    }


}
