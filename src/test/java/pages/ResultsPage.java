package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends BasePage {

    private static final String TITLE = "//*[@data-testid='title']";
    private static final String RATING = "//div[contains(text(), 'Scored')]";

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfResults() {
        List<WebElement> titles = driver.findElements(By.xpath(TITLE));
        return titles;
    }

    public List<WebElement> getListOfRatings() {
        List<WebElement> ratings = driver.findElements(By.xpath(RATING));
        return ratings;
    }

    public boolean isHotelInResults(List<WebElement> titles, String hotel) {
        boolean isHotelFound = false;
        for (WebElement title : titles) {
            if (title.getText().equals(hotel)) {
                isHotelFound = true;
                break;
            }
        }
        return isHotelFound;
    }

    public boolean isRatingCorrect(List<WebElement> hotels, List<WebElement> ratings, String hotel, String rating) {
        boolean isRatingCorrect = false;
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getText().equals(hotel) && ratings.get(i).getText().equals(rating)) {
                isRatingCorrect = true;
                break;
            }
        }
        return isRatingCorrect;
    }
}
