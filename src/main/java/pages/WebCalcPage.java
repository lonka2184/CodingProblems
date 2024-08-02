package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebCalcPage extends BasePage{

    //Locators
    private final By openParenthesesBtn = new By.ById("BtnParanL");
    private final By closeParenthesesBtn = new By.ById("BtnParanR");

    private final By calcDisplay = new By.ByClassName("disable1d");
    private final By zeroBtn = new By.ById("Btn0");
    private final By oneBtn = new By.ById("Btn1");
    private final By twoBtn = new By.ById("Btn2");
    private final By threeBtn = new By.ById("Btn3");
    private final By fourBtn = new By.ById("Btn4");
    private final By fiveBtn = new By.ById("Btn5");
    private final By sixBtn = new By.ById("Btn6");
    private final By sevenBtn = new By.ById("Btn7");
    private final By eightBtn = new By.ById("Btn8");
    private final By nineBtn = new By.ById("Btn9");

    private final By equalsBtn = new By.ById("BtnCalc");
    private final By clearBtn = new By.ById("BtnClear");

    private final By plusBtn = new By.ById("BtnPlus");
    private final By minusBtn = new By.ById("BtnMinus");
    private final By multiplyBtn = new By.ById("BtnMult");
    private final By divideBtn = new By.ById("BtnDiv");

    private final By sineBtn = new By.ById("BtnSin");

    private final By expandHistoryBtn =
            new By.ByCssSelector("#hist > button.btn.dropdown-toggle.pull-right > span.glyphicon.glyphicon-chevron-down");

    private final By collapseHistoryBtn =
            new By.ByCssSelector("#hist > button.btn.dropdown-toggle.pull-right > span.glyphicon.glyphicon-chevron-up");

    private final By clearHistoryBtn = new By.ById("clearhistory");

    private final By genericHistoryLineItemLeft = new By.ByClassName("l");
    private final By genericHistoryLineItemRight = new By.ByClassName("r");

    public WebCalcPage()
    {

    }


    public void loadPage()
    {
        //page url
        String pageUrl = "https://web2.0calc.com/";
        System.out.println("Navigating to 'Web Calc' page: " + pageUrl);
        navigateToUrl(pageUrl);
        waitForElementToBeVisible(equalsBtn, 10000);
    }

    public String getCalculatorResult()
    {
        System.out.println("Retrieving calculator display value");
        String val = getElementValueAttribute(calcDisplay);
        System.out.println("Displayed calculator value is: " + val);
        return val;
    }

    public void clickClearBtn()
    {
        System.out.println("Clicking 'Clear' button");
        findElement(clearBtn, 1000).click();
        //Allow time calc to clear
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickEqualsBtn()
    {
        System.out.println("Clicking '=' button");
        findElement(equalsBtn, 1000).click();
        //Allow time calc to compute result and update displayed value
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickPlusBtn()
    {
        System.out.println("Clicking '+' button");
        findElement(plusBtn, 1000).click();
    }

    public void clickMinusBtn()
    {
        System.out.println("Clicking '-' button");
        findElement(minusBtn, 1000).click();
    }

    public void clickMultiplyBtn()
    {
        System.out.println("Clicking 'x' (multiply) button");
        findElement(multiplyBtn, 1000).click();
    }

    public void clickDivideBtn()
    {
        System.out.println("Clicking '/' (divide) button");
        findElement(divideBtn, 1000).click();
    }

    public void click1Btn()
    {
        System.out.println("Clicking '1' button");
        findElement(oneBtn, 1000).click();
    }

    public void click2Btn()
    {
        System.out.println("Clicking '2' button");
        findElement(twoBtn, 1000).click();
    }

    public void click3Btn()
    {
        System.out.println("Clicking '3' button");
        findElement(threeBtn, 1000).click();
    }

    public void click4Btn()
    {
        System.out.println("Clicking '4' button");
        findElement(fourBtn, 1000).click();
    }

    public void click5Btn()
    {
        System.out.println("Clicking '5' button");
        findElement(fiveBtn, 1000).click();
    }

    public void click6Btn()
    {
        System.out.println("Clicking '6' button");
        findElement(sixBtn, 1000).click();
    }

    public void click7Btn()
    {
        System.out.println("Clicking '7' button");
        findElement(sevenBtn, 1000).click();
    }

    public void click8Btn()
    {
        System.out.println("Clicking '8' button");
        findElement(eightBtn, 1000).click();
    }

    public void click9Btn()
    {
        System.out.println("Clicking '9' button");
        findElement(nineBtn, 1000).click();
    }

    public void click0Btn()
    {
        System.out.println("Clicking '0' button");
        findElement(zeroBtn, 1000).click();
    }

    public void clickOpenParenthesesBtn()
    {
        System.out.println("Clicking '(' button");
        findElement(openParenthesesBtn, 1000).click();
    }

    public void clickCloseParenthesesBtn()
    {
        System.out.println("Clicking ')' button");
        findElement(closeParenthesesBtn, 1000).click();
    }

    public void clickSinBtn()
    {
        System.out.println("Clicking 'sin' button");
        findElement(sineBtn, 1000).click();
    }

    public void clickExpandHistoryBtn()
    {
        System.out.println("Clicking 'Expand History' button");
        findElement(expandHistoryBtn, 1000).click();
        waitForElementToBeVisible(clearHistoryBtn, 3000);
    }

    public void clickCollapseHistoryBtn()
    {
        System.out.println("Clicking 'Collapse History' button");
        findElement(collapseHistoryBtn, 1000).click();
        waitForElementToBeInvisible(clearHistoryBtn, 3000);
    }

    public String getHistoryItemByIndex(int index)
    {
        String genericHistItemCssStr = "#histframe > ul > li:nth-child(#index) > p.l";
        String cssStr = genericHistItemCssStr.replace("#index", String.valueOf(index));
        WebElement el = findElement(new By.ByCssSelector(cssStr), 1000);
        return el.getText();
    }

    public List<String> getAllHistoryItemsOnLeft()
    {
        System.out.println("Retrieving items displayed on the left side (equations) in calculator history");
        List<String> items = getTextOfMatchingElements(genericHistoryLineItemLeft);
        System.out.println(items);
        return items;

    }

}
