import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTests extends BaseCalcTest {

    @Test()
    public void test1_TwoPlusThree()
    {
        webCalcPage.click2Btn();
        webCalcPage.clickPlusBtn();
        webCalcPage.click3Btn();
        webCalcPage.clickEqualsBtn();

        String result = webCalcPage.getCalculatorResult();
        String expectedResult = "5";
        Assert.assertEquals(result, expectedResult,
                "Verifying that calculator is displaying " + expectedResult);
    }

    @Test()
    public void test2_TenMinusTwo()
    {
        webCalcPage.click1Btn();
        webCalcPage.click0Btn();
        webCalcPage.clickMinusBtn();
        webCalcPage.click2Btn();
        webCalcPage.clickEqualsBtn();

        String result = webCalcPage.getCalculatorResult();
        String expectedResult = "8";
        Assert.assertEquals(result, expectedResult,
                "Verifying that calculator is displaying " + expectedResult);
    }

    @Test()
    public void test3_TenMinusTwoTimesTwo()
    {
        webCalcPage.clickOpenParenthesesBtn();
        webCalcPage.click1Btn();
        webCalcPage.click0Btn();
        webCalcPage.clickMinusBtn();
        webCalcPage.click2Btn();
        webCalcPage.clickCloseParenthesesBtn();
        webCalcPage.clickMultiplyBtn();
        webCalcPage.click2Btn();
        webCalcPage.clickEqualsBtn();

        String result = webCalcPage.getCalculatorResult();
        String expectedResult = "20";
        Assert.assertNotEquals(result, expectedResult,
                "Verifying that calculator is NOT displaying " + expectedResult);
    }

    @Test()
    public void test4_SineThirtyDegrees()
    {
        webCalcPage.clickSinBtn();
        webCalcPage.click3Btn();
        webCalcPage.click0Btn();
        webCalcPage.clickCloseParenthesesBtn();
        webCalcPage.clickEqualsBtn();

        String result = webCalcPage.getCalculatorResult();
        String expectedResult = "0.5";
        Assert.assertEquals(result, expectedResult,
                "Verifying that calculator is displaying " + expectedResult);
    }

    @Test()
    public void test5_CalcHistory() {

        webCalcPage.clickExpandHistoryBtn();

        List<String> historyItems = webCalcPage.getAllHistoryItemsOnLeft();
        int numItems = historyItems.size();

        String expectedEq0 = "sin(30)";
        String expectedEq1 = "(10-2)*2";
        String expectedEq2 = "10-2";
        String expectedEq3 = "2+3";

        Assert.assertEquals(historyItems.get(0), expectedEq0, "Verifying top / first equation in history");
        Assert.assertEquals(historyItems.get(1), expectedEq1, "Verifying second equation (from the top) in history");
        Assert.assertEquals(historyItems.get(2), expectedEq2, "Verifying third equation (from the top) in history");
        Assert.assertEquals(historyItems.get(3), expectedEq3, "Verifying fourth equation (from the top) in history");
        Assert.assertEquals(numItems, 4, "Verifying there are 4 items in history");
        webCalcPage.clickCollapseHistoryBtn();

    }

}
