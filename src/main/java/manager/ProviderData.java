package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> loginModelDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("bogoborec87@gmail.com").withPassword("Illumiel1!")});
        list.add(new Object[]{new User().withEmail("bogoborec87@gmail.com").withPassword("Illumiel1!")});
        list.add(new Object[]{new User().withEmail("bogoborec87@gmail.com").withPassword("Illumiel1!")});
        return list.iterator();
    }

}
