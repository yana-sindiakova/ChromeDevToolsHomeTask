package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentPage extends BasePage {

    @FindBy(className = "sendmsg__ads-ready")
    private WebElement sentMessageTab;

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMessageSent() {
        waitForPageLoadComplete();
        waitVisibilityOfElement(sentMessageTab);
        return sentMessageTab.isDisplayed();
    }
}
