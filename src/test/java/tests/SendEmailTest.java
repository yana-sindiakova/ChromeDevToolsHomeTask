package tests;

import org.testng.annotations.Test;
import pages.SentPage;

import static org.testng.Assert.assertTrue;

public class SendEmailTest extends BaseTest {
    private static final String RECEIVER_EMAIL = "testyanauser1@ukr.net";
    private static final String EMAIL_TEXT = "Hello, this is test email";
    private static final String USER_NAME = "User";

    @Test(description = "Send an email")
    public void sendAnEmail() {
        SentPage sentPage = getLoginPage()
                .loginToTheSystem(USER_NAME)
                .clickOnWriteLetterButton()
                .sendEmail(RECEIVER_EMAIL, EMAIL_TEXT);
        assertTrue(sentPage.isMessageSent());
    }
}
