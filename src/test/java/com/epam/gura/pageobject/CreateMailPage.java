package com.epam.gura.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.gura.WebDriverFactory;

public class CreateMailPage extends AbstractPage {

    public CreateMailPage(WebDriverFactory driver) {
        super(driver);

    }

    public static final String TITLE = "//input[@name='subjectbox']";
    public static final String TO = "//textarea[@aria-label='Кому']";

    public static final String TEXT = "//div[@aria-label='Тело письма']";

    public static final String SEND_LETTER_BUTTON = "//div[text()='Отправить']";

    @FindBy(xpath = TITLE)
    private WebElement titleInput;

    @FindBy(xpath = TO)
    private WebElement recipientInput;

    @FindBy(xpath = TEXT)
    private WebElement textInput;

    @FindBy(xpath = SEND_LETTER_BUTTON)
    private WebElement sendLetterButton;

    public String getLetterText() {
        return textInput.getText();
    }

    public MainPage createLetter(String title, String recipient, String text) {

        recipientInput.sendKeys(recipient);
        titleInput.sendKeys(title);
        textInput.sendKeys(text);
        sendLetterButton.click();
        return new MainPage(driver);
    }

}
