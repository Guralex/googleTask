package com.epam.gura;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static WebDriverFactory driver;

    @BeforeClass
    public static void preconditions() {
        driver = new WebDriverFactory("Chrome");
    }

    @AfterClass
    public static void postconditions() {
        driver.getDriver().quit();
    }
}
