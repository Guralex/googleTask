package com.epam.gura.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.epam.gura.Setup;

public class MainPage extends AbstractPage {

	

	public MainPage(Setup setup) {
		super(setup);
		
	}
	
    public static final String CREATE_MAIL_BUTTON = "//*[@gh='cm']";
    
    public static final String USER_ICON = "//a[contains(@href,'SignOut')]";
    public static final String LOGOUT_BUTTON = "//a[contains(@href,'logout')]";
    
    public static final String CHECKBOX_SPAM = "(//div[@aria-checked][@role='checkbox']/div)[1]";
    public static final String SEND_TO_SPAM_BUTTON = "//div[@act='9']";
    public static final String SEARCH_INPUT_FIELD = "//input[@aria-label='Поиск']";
    public static final String SEARCH_BUTTON = "//button[@aria-label='Поиск Gmail']";

    public static final String LATEST_INBOX_LETTER = "(//*[@role='main']//tr)[3]/td[6]"; //костыль
    public static final String STARRED_BUTTON = "//a[contains(text(),'Помеченные')]";
    
    
    public static final String SETTINGS_BUTTON = "//*[contains(@role,'button') and @title='Настройки']";
    public static final String THEMES_OPTION = "//div[text()='Темы']";
    /*
    @FindBy(xpath = )
    private WebElement ;*/
    
    @FindBy(xpath = SETTINGS_BUTTON)
    private WebElement settingsButton;
    
    @FindBy(xpath = THEMES_OPTION)
    private WebElement themesOption;
    
    @FindBy(xpath = LATEST_INBOX_LETTER)
    private WebElement latestInboxLetter;
    
    @FindBy(xpath = STARRED_BUTTON)
    private WebElement starredButton;
    
    @FindBy(xpath = CREATE_MAIL_BUTTON)
    private WebElement CreateMailButton;
    
    @FindBy(xpath = USER_ICON)
    private WebElement userIcon;
    
    @FindBy(xpath = LOGOUT_BUTTON)
    private WebElement logoutButton;
    
    @FindBy(xpath = CHECKBOX_SPAM)
    private WebElement checkboxSpam;
    
    @FindBy(xpath = SEND_TO_SPAM_BUTTON)
    private WebElement sendToSpamButton;
    
    @FindBy(xpath = SEARCH_INPUT_FIELD)
    private WebElement searchField;

    @FindBy(xpath = SEARCH_BUTTON)
    private WebElement searchButton;

   

    public CreateMailPage goToNewMail() {
       
    	CreateMailButton.click();
    	
    	return new CreateMailPage(setup);
    }
    
    public StartPage logout(){
    	userIcon.click();
    	logoutButton.click();
    	
    	return new StartPage(setup);
    }
    

    public void markLetterAsSpam() throws InterruptedException{
        checkboxSpam.click();
        Thread.sleep(5000);
        sendToSpamButton.click();
        Thread.sleep(5000);
     }

    public SpamPage goToSpam() throws InterruptedException{
        searchField.sendKeys("in:spam");
        searchButton.click();
        Thread.sleep(5000);
        return new SpamPage(setup);
    }
    

    public void dragNDrop() throws InterruptedException{
    	  Actions actionDragAndDrop = new Actions(setup.getDriver());
          Thread.sleep(5000);
          actionDragAndDrop.dragAndDrop(latestInboxLetter, starredButton).perform();
    }
    
    public StarredPage goToStarred(){
        starredButton.click();
        return new StarredPage(setup);
    }

    public ThemesPage goToThemes() throws InterruptedException{
        Thread.sleep(2000);
        settingsButton.click();
        Thread.sleep(2000);
        themesOption.click();
        return new ThemesPage(setup);
    }
      }
	


