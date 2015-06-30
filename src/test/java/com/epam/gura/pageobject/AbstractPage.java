package com.epam.gura.pageobject;

import com.epam.gura.WebDriverFactory;

import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    WebDriverFactory driver;

    public AbstractPage(WebDriverFactory driver) {
        this.driver = driver;
        PageFactory.initElements(driver.getDriver(), this);
    }
}
