package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormForCar(){

        type(By.xpath("//input[@id='city']"), "Tel Aviv");
        wd.findElement(By.cssSelector(".pac-item")).click();
        wd.findElement(By.id("dates")).click();
        wd.findElement(By.xpath("//div[@class='mat-calendar-arrow']")).click();
        wd.findElement(By.xpath("//div[text()= 2023 ]")).click();
        wd.findElement(By.xpath("//div[text()=' MAR ']")).click();
        wd.findElement(By.xpath("//div[contains(text(),'27')]")).click();
        wd.findElement(By.xpath("//div[contains(text(),'30')]")).click();

    }

    public void submitSearch(){
        wd.findElement(By.cssSelector("button[type='submit']")).submit();
    }

}
