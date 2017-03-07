package base;

import com.epam.mariia_lavrova.driver.ChromeDriverManager;
import com.epam.mariia_lavrova.property.PropertyFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    @BeforeTest
    public void setUp() throws Exception {
        ChromeDriverManager.getDriver().get(PropertyFactory.getProperty("googleMailUrl"));
    }

    @AfterTest
    public void tearDown() throws Exception {
        ChromeDriverManager.closeDriver();
    }
}
