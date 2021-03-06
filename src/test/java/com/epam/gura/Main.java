package com.epam.gura;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.gura.pageobject.*;

public class Main extends BaseTest {

    
    public static final String USER_ONE = "serenity3837@gmail.com";
    public static final String PASSWORD_ONE = "guralex3837";
    public static final String USER_TWO = "serenity38372@gmail.com";
    public static final String PASSWORD_TWO = "serenity3837";
    public static final String MAIL_SUBJECT = "Hello";
    public static final String MAIL_TEXT = "Hello, user 2";

   /* @Test
    public void starredLetter() throws InterruptedException {
      
        StartPage start = new StartPage(driver);
        MainPage main = start.login(USER_ONE, PASSWORD_ONE);
        CreateMailPage mail = main.goToNewMail();
        main = mail.createLetter(MAIL_SUBJECT, USER_TWO, MAIL_TEXT);
        Thread.sleep(2000);
        start = main.logout();

        main = start.loginSecondTime(USER_TWO, PASSWORD_TWO);
        Thread.sleep(2000);
        main.dragNDrop();
        Thread.sleep(2000);
        StarredPage starredPage = main.goToStarred();
        Assert.assertTrue(starredPage.getMessageTheme().contains(
                MAIL_SUBJECT),"Element is not in starred folder");
    }*/

    @Test
    public void selectAnotherTheme() throws InterruptedException {
      
        String oldTheme;
        StartPage start = new StartPage(driver);
        MainPage main = start.login(USER_ONE, PASSWORD_ONE);
        Thread.sleep(2000);
        ThemesPage themesPage = main.goToThemes();
        oldTheme=themesPage.getCurrentName();
        themesPage.selectNewTheme();
        Assert.assertTrue(themesPage.getCurrentName().equals(oldTheme),"Theme was not changed");
    }

  /*  @Test
    public void spamTest() throws InterruptedException {

        StartPage start = new StartPage(driver);
        MainPage main = start.login(USER_ONE, PASSWORD_ONE);
        CreateMailPage mail = main.goToNewMail();
        main = mail.createLetter(MAIL_SUBJECT, USER_TWO, MAIL_TEXT);
        Thread.sleep(2000);
        start = main.logout();

        main = start.loginSecondTime(USER_TWO, PASSWORD_TWO);
        main.markLetterAsSpam();
        main.logout();

        main = start.loginSecondTime(USER_ONE, PASSWORD_ONE);
        mail = main.goToNewMail();
        main = mail.createLetter(MAIL_SUBJECT, USER_TWO, MAIL_TEXT);
        Thread.sleep(2000);
        start = main.logout();

        main = start.loginSecondTime(USER_TWO, PASSWORD_TWO);
        SpamPage spam = main.goToSpam();

        Assert.assertTrue(spam.getMessageTheme().contains(MAIL_SUBJECT),"Element is not in spam folder");

    }*/
}
