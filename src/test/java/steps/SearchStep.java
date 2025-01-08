package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.ResultsPage;
import pages.SearchPage;

import java.time.Duration;
import java.util.List;

public class SearchStep {

    WebDriver driver;
    SearchPage searchPage;
    ResultsPage resultsPage;


    @Given("booking search page is opened")
    public void bookingSearchPageIsOpened() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        searchPage = new SearchPage(driver);
        resultsPage = new ResultsPage(driver);

        searchPage.open();
    }

    @When("user searches for {string} hotel")
    public void userSearchesForHotel(String hotel) {
        searchPage.searchForHotel(hotel);
    }

    @Then("{string} hotel is shown")
    public void hotelIsShown(String expectedResult) {
        List<WebElement> titles = resultsPage.getListOfResults();
        Assert.assertTrue(
                resultsPage.isHotelInResults(titles, expectedResult),
                "Hotel is absent.");
    }

    @And("{string} hotel has rating {string}")
    public void hotelHasRating(String hotel, String rating) {
        List<WebElement> hotels = resultsPage.getListOfResults();
        List<WebElement> ratings = resultsPage.getListOfRatings();
        Assert.assertTrue(
                resultsPage.isRatingCorrect(hotels, ratings, hotel, rating),
                "Ratings do not match.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
