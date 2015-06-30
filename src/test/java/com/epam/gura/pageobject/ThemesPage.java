package com.epam.gura.pageobject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.gura.WebDriverFactory;

public class ThemesPage extends AbstractPage {

    public static final String THEMES_LIST = "//*[@class='J-J5-Ji sj']";
    public static final String THEMES_NAMES = "//*[@class='J-J5-Ji sj']//input";
    public static final String CURRENT_THEME = "//*[@class='sh']//input";

    @FindBy(xpath = THEMES_NAMES)
    private List<WebElement> themesNames;

    @FindBy(xpath = THEMES_LIST)
    private List<WebElement> themesList;

    @FindBy(xpath = CURRENT_THEME)
    private WebElement currentTheme;

    public void selectNewTheme() {

        int i;
        Random r = new Random();
        String name = currentTheme.getAttribute("name");

        while (true) {

            i = r.nextInt(themesNames.size());
            if (!themesNames.get(i).getAttribute("name").equals(name)) {
                themesList.get(i).click();
                break;
            }

        }

    }

    public ThemesPage(WebDriverFactory driver) {
        super(driver);
    }

    public String getCurrentName() {
        return currentTheme.getAttribute("name");
    }
}
