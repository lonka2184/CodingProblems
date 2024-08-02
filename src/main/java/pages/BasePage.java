package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {


    public static WebDriver driver = new ChromeDriver();

    public BasePage() {
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url){
        driver.get(url);
    }

    public String getElementText(By locator) {
        String text = "";
        WebElement element = findElement(locator, 1000);
        if (element != null) {
            text = element.getText();
        }
        return text;
    }

    public String getElementValueAttribute(By locator) {
        String valAttribute = "";
        WebElement element = findElement(locator, 1000);
        if (element != null) {
            valAttribute = element.getAttribute("value");
        }
        return valAttribute;
    }

    public WebElement findElement(By locator, int maxWaitTimeMs) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(maxWaitTimeMs));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public List<WebElement> findElements(By locator, int maxWaitTimeMs) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(maxWaitTimeMs));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public List<String> getTextOfMatchingElements(By locator) {
        List<WebElement> elements = findElements(locator, 1000);
        List<String> listOfElementText = new ArrayList<>();
        if (elements != null && !elements.isEmpty()) {
            for (WebElement element : elements) {
                listOfElementText.add(element.getText());
            }
        }
        return listOfElementText;
    }


    public boolean waitForElementToBeVisible(By locator, int maxWaitTimeMs) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(maxWaitTimeMs));
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return el != null;
    }

    public boolean waitForElementToBeInvisible(By locator, int maxWaitTimeMs) {
        WebElement element;
        boolean isElementVisible;
        long startTimeMs = System.currentTimeMillis() % 1000;
        long currTimeMs;
        do {
            try {
                element = driver.findElement(locator);
                isElementVisible = element.isDisplayed();
            } catch (Exception e) {
                // Unable to retrieve element, therefore it is not visible
                isElementVisible = false;
            }
            // Get current time
            currTimeMs = System.currentTimeMillis() % 1000;

        } while (((currTimeMs - startTimeMs) <= maxWaitTimeMs) && (isElementVisible));

        return isElementVisible;
    }

}
