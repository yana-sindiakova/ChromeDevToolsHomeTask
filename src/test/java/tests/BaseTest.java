package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import pages.MainPage;
import pages.SendMessagePage;
import pages.SentPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;
    private static final String UKR_NET_URL = "https://mail.ukr.net/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(UKR_NET_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(getDriver());
    }

    public MainPage getMainPage() {
        return new MainPage(getDriver());
    }

    public SendMessagePage getSendMessagePage() {
        return new SendMessagePage(getDriver());
    }

    public SentPage getSentPage() {
        return new SentPage(getDriver());
    }

}
