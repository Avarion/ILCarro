package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormForCar(){

        type(By.id("city"), "Tel Aviv");


    }

    public void submitSearch(){
        wd.findElement(By.cssSelector("button[type='submit']")).submit();
    }

}
