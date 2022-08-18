package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(css = "button.button.primary.compose")
    private WebElement writeLetterButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SendMessagePage clickOnWriteLetterButton() {
        clickElement(writeLetterButton);
        return new SendMessagePage(driver);
    }
}
