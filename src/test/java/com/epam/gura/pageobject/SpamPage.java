package com.epam.gura.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.gura.Setup;

public class SpamPage extends AbstractPage {

	
	 private static final String LATEST_MESSAGE = "(//*[@role='main']//tr)[1]/td[6]//b";

		@FindBy(xpath = LATEST_MESSAGE)
		private WebElement latestMessage;

	    public String getLatestMessageTheme() {
	        return latestMessage.getText();
	    }

	    public SpamPage(Setup setup) {
	        super(setup);
	    }
    
      }
	


