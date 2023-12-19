package com.qa.magneto.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.magneto.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority =1)
	public void loginPageTitleTest() {
		String title = loginpage.getLPTitle();
		AssertJUnit.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
	}
	@Test(priority=2)
	public void headerTitleTest() {
		String headerTitle = loginpage.isHeaderTitlePresent();
		AssertJUnit.assertEquals(headerTitle, Constants.LOGIN_PAGE_HEADER_TITLE);
	}
	@Test(priority=3)
	public void createAccountBtnTest() {
		String btnText = loginpage.isCreateAccBtnPresent();
		AssertJUnit.assertEquals(btnText, Constants.LOGIN_PAGE_CREATE_ACCOUNT_BUTTON);
	}
	@Test(priority=4)
	public void doLoginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		AssertJUnit.assertEquals(accountPage.getAccPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
		
	}
	

}
