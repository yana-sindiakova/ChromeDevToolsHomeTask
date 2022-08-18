package pages;

import entities.User;
import entities.UserCreation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private User user;
    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginInput;
    @FindBy(css = " input[type='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUser(String role) {
        this.user = new UserCreation(role).getUser();
    }

    public LoginPage inputLogin(String login) {
        waitForPageLoadComplete();
        waitVisibilityOfElement(loginInput);
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        waitVisibilityOfElement(loginInput);
        passwordInput.sendKeys(password);
        return this;
    }

    public MainPage clickOnContinueButton() {
        clickElement(continueButton);
        return new MainPage(driver);
    }

    public MainPage loginToTheSystem(String userName) {
        setUser(userName);
        inputLogin(user.getLogin())
                .inputPassword(user.getPassword())
                .clickOnContinueButton();
        return new MainPage(driver);
    }


}
