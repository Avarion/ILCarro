package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    EventFiringWebDriver wd;
    HelperUser user;
    HelperSearch search;

    Properties properties;

    public ApplicationManager() {
        properties = new Properties();
    }

    public void init() throws IOException {
        properties.load(new FileReader(new File("src/test/resources/config.properties")));
        wd = new EventFiringWebDriver(new ChromeDriver());
//      wd.manage().window().maximize();
        wd.register(new MyListener());
        user = new HelperUser(wd);
        search = new HelperSearch(wd);
//      wd.navigate().to("https://ilcarro.web.app/search");
        wd.navigate().to(properties.getProperty("web.baseURL"));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void stop() {
        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperSearch getSearch() {
        return search;
    }

    public String getEmail() {
        return properties.getProperty("web.email");
    }

    public String getPassword() {
        return properties.getProperty("web.password");
    }

}
