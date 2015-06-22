package com.epam.gura.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.gura.Setup;

public class StartPage extends AbstractPage {

	public static final String LOGIN = ".//input[@id='Email']";
	public static final String NEXT_BUTTON = ".//input[@id='next']";
	public static final String PASSWORD = ".//*[@id='Passwd']";
	public static final String LOGIN_BUTTON = ".//*[@id='signIn']";
	public static final String CURRENT_ACCOUNT_TEXT = ".//*[@id='gb']//a[contains(@class,'gb_ga') and contains(@title,'Аккаунт')]";
	public static final String LOGIN_AFTER_ANOTHER_USER_LINK = "//a[@id='account-chooser-link']";
	public static final String ADD_ACCOUNT = "//a[@id='account-chooser-add-account']";

	@FindBy(xpath = LOGIN)
	private WebElement userNameLocator;

	@FindBy(xpath = CURRENT_ACCOUNT_TEXT)
	private WebElement currentAccountText;

	@FindBy(xpath = NEXT_BUTTON)
	private WebElement nextButton;

	@FindBy(xpath = PASSWORD)
	private WebElement passwordLocator;

	@FindBy(xpath = LOGIN_BUTTON)
	private WebElement loginButtonLocator;

	@FindBy(xpath = LOGIN_AFTER_ANOTHER_USER_LINK)
	private WebElement loginAfterAnotherUserLink;

	@FindBy(xpath = ADD_ACCOUNT)
	private WebElement addAccount;

	public StartPage(Setup setup) {
		super(setup);
		setup.getDriver().get("http:\\mail.google.com");
	}

	public MainPage login(String userName, String password) {
		userNameLocator.sendKeys(userName);
		nextButton.click();
		passwordLocator.sendKeys(password);
		loginButtonLocator.click();
		return new MainPage(setup);
	}

	public MainPage loginAfterAnotherUser(String userName, String password) {
		try {
			loginAfterAnotherUserLink.click();
			setup.getDriver().switchTo().alert().accept();
		} finally {
			wait.waitVisibilityOf(setup, addAccount);
			addAccount.click();
			userNameLocator.sendKeys(userName);
			nextButton.click();
			passwordLocator.sendKeys(password);
			loginButtonLocator.click();
			return new MainPage(setup);
		}
	}

}
