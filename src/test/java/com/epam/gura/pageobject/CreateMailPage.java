package com.epam.gura.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.gura.Setup;

public class CreateMailPage extends AbstractPage {

	

	public CreateMailPage(Setup setup) {
		super(setup);
		
	}
	

    public static final String TITLE_INPUT = "//input[@name='subjectbox']";
    public static final String RECIPIENT_INPUT = "//textarea[@aria-label='Кому']";

    public static final String TEXT_INPUT = "//div[@aria-label='Тело письма']";
    
    public static final String SEND_LETTER_BUTTON = "//div[text()='Отправить']";



    @FindBy(xpath = TITLE_INPUT)
    private WebElement titleInput;

    @FindBy(xpath = RECIPIENT_INPUT)
    private WebElement recipientInput;


    @FindBy(xpath = TEXT_INPUT)
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
        return new MainPage(setup);
    }

    

   
	    }
	


