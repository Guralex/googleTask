package com.epam.gura.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.gura.WebDriverFactory;

public class StarredPage extends AbstractPage {
    public StarredPage(WebDriverFactory driver) {
        super(driver);
    }

    private static final String MESSAGE = "(//*[@role='main']//tr)[1]/td[6]//b";

    @FindBy(xpath = MESSAGE)
    private WebElement latestMessage;

    public WebElement getLatestMessage() {
        return latestMessage;
    }

    public String getMessageTheme() {
        return latestMessage.getText();
    }

}
