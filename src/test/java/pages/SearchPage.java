package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    private static final String SEARCH_FIELD = "//input[@placeholder='Where are you going?']";
    private static final String SUBMIT = "button[type=submit]";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void searchForHotel(String hotel) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_FIELD))).sendKeys(hotel);
        } catch (StaleElementReferenceException e) {
            driver.navigate().refresh();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_FIELD))).sendKeys(hotel);
        }
        driver.findElement(By.cssSelector(SUBMIT)).click();
    }
}
