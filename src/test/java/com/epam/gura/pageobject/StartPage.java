package com.epam.gura.pageobject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.gura.WebDriverFactory;

public class StartPage extends AbstractPage {

    public static final String LOGIN = ".//input[@id='Email']";
    public static final String NEXT_BUTTON = ".//input[@id='next']";
    public static final String PASSWORD = ".//*[@id='Passwd']";
    public static final String LOGIN_BUTTON = ".//*[@id='signIn']";
    public static final String CURRENT_ACCOUNT_TEXT = ".//*[@id='gb']//a[contains(@class,'gb_ga') and contains(@title,'Аккаунт')]";
    public static final String LOGIN_AFTER_ANOTHER_USER_LINK = "//a[@id='account-chooser-link']";
    public static final String ADD_ACCOUNT = "//a[@id='account-chooser-add-account']";

    @FindBy(xpath = LOGIN)
    private WebElement loginField;

    @FindBy(xpath = CURRENT_ACCOUNT_TEXT)
    private WebElement currentAccountText;

    @FindBy(xpath = NEXT_BUTTON)
    private WebElement nextButton;

    @FindBy(xpath = PASSWORD)
    private WebElement passwordField;

    @FindBy(xpath = LOGIN_BUTTON)
    private WebElement loginButton;

    @FindBy(xpath = LOGIN_AFTER_ANOTHER_USER_LINK)
    private WebElement loginAfterAnotherUserLink;

    @FindBy(xpath = ADD_ACCOUNT)
    private WebElement addAccount;

    public StartPage(WebDriverFactory driver) {
        super(driver);
        driver.getDriver().get("http:\\mail.google.com");
    }

    public MainPage login(String userName, String password) throws InterruptedException {
        Thread.sleep(2000);
        loginField.sendKeys(userName);
        nextButton.click();
        Thread.sleep(2000);
        passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);
    }

    public MainPage loginSecondTime(String userName, String password)
            throws InterruptedException {

        loginAfterAnotherUserLink.click();
        Thread.sleep(5000);
        addAccount.click();
        loginField.sendKeys(userName);
        nextButton.click();
        passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);

    }

}
