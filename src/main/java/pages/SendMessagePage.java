package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendMessagePage extends BasePage {
    @FindBy(xpath = "//input[@name='toFieldInput']")
    private WebElement receiverInput;

    @FindBy(id = "tinymce")
    private WebElement messageInput;

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    @FindBy(xpath = "//div[contains(@class, 'bottom')]/button[@class='button primary send']")
    private WebElement sendMessageButton;

    public SendMessagePage(WebDriver driver) {
        super(driver);
    }

    public void switchToIframe() {
        waitVisibilityOfElement(iframe);
        driver.switchTo().frame(iframe);
    }

    public SendMessagePage inputReceiver(String receiverMail) {
        waitForPageLoadComplete();
        waitVisibilityOfElement(receiverInput);
        receiverInput.sendKeys(receiverMail);
        return this;
    }

    public SendMessagePage inputMessage(String message) {
        switchToIframe();
        messageInput.sendKeys(message);
        driver.switchTo().defaultContent();
        return this;
    }

    public SentPage clickOnSendMessageButton() {
        clickElement(sendMessageButton);
        return new SentPage(driver);
    }

    public SentPage sendEmail(String receiver, String message) {
        return inputReceiver(receiver)
                .inputMessage(message)
                .clickOnSendMessageButton();
    }


}
