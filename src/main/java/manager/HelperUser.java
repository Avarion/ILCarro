package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void submitRegistration() {
        click((By.xpath("//button[2]")));
    }

    public void submitLogin() {
        click((By.xpath("//button[@type='submit']")));
    }

    public void openLoginRegistrationForm() {
        click(By.xpath("//a[text()='Log in']"));
    }

    public void logout() {
        click(By.xpath("//a[normalize-space()='Logout']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
    }

}
