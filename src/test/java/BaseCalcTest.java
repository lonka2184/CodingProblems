
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.WebCalcPage;

public class BaseCalcTest {

    WebCalcPage webCalcPage = new WebCalcPage();

    @BeforeClass
    public void beforeClass()
    {
        webCalcPage.loadPage();
    }

    @BeforeMethod
    public void beforeMethod()
    {
        webCalcPage.clickClearBtn();
    }


    @AfterClass
    public void afterClass()
    {
        BasePage.driver.quit();
    }

}
