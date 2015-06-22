package com.epam.gura;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.epam.gura.pageobject.CreateMailPage;
import com.epam.gura.pageobject.MainPage;
import com.epam.gura.pageobject.SpamPage;
import com.epam.gura.pageobject.StarredPage;
import com.epam.gura.pageobject.StartPage;
import com.epam.gura.pageobject.ThemesPage;

public class Main extends BaseTest {

	public static final String USER_ONE = "serenity3837@gmail.com";
	public static final String PASSWORD_ONE = "guralex3837";
	public static final String USER_TWO = "serenity38372@gmail.com";
	public static final String PASSWORD_TWO = "serenity3837";

	
	@Test
    public void starredLetter() throws InterruptedException{
		StartPage start = new StartPage(setup);
		MainPage main = start.login(USER_ONE, PASSWORD_ONE);
		CreateMailPage mail = main.goToNewMail();
		main = mail.createLetter("Hello!!!", USER_TWO, "Hello, user 2");
		Thread.sleep(2000);
		start = main.logout();

		main = start.loginAfterAnotherUser(USER_TWO, PASSWORD_TWO);
		Thread.sleep(2000);
		main.dragAndDropLatestLetterToStarred();
		System.out.println("drag");
		Thread.sleep(2000);
        StarredPage starredPage = main.goToStarredPage();
        assertTrue(starredPage.getLatestMessageTheme().contains("Hello"));
    }
	
	@Test
    public void selectAnotherTheme() throws InterruptedException{
		StartPage start = new StartPage(setup);
		MainPage main = start.login(USER_ONE, PASSWORD_ONE);
		ThemesPage themesPage = main.goToThemesPage();
        
		int defaultThemeIndex = themesPage.getCurrentThemeIndex();
        themesPage.selectRandomTheme();
        int selectedThemeIndex = themesPage.getCurrentThemeIndex();
        assertTrue(defaultThemeIndex!=selectedThemeIndex);
    }
	
	
	
	@Test
	public void spamTest() throws InterruptedException {

		StartPage start = new StartPage(setup);
		MainPage main = start.login(USER_ONE, PASSWORD_ONE);
		CreateMailPage mail = main.goToNewMail();
		main = mail.createLetter("Hello!!!", USER_TWO, "Hello, user 2");
		Thread.sleep(2000);
		start = main.logout();

		main = start.loginAfterAnotherUser(USER_TWO, PASSWORD_TWO);
		main.markLetterAsSpam();
		main.logout();

		main = start.loginAfterAnotherUser(USER_ONE, PASSWORD_ONE);
		mail = main.goToNewMail();
		main = mail.createLetter("Hello!!!", USER_TWO, "Hello, user 2");
		Thread.sleep(2000);
		start = main.logout();
		
		main = start.loginAfterAnotherUser(USER_TWO, PASSWORD_TWO);
		SpamPage spam = main.goToSpamFolder();

		assertTrue(spam.getLatestMessageTheme().contains("Hello"));
		
	}
}
