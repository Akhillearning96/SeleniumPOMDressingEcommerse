package com.qa.magneto.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	public  static final String LOGIN_PAGE_TITLE = "Customer Login";
	public static final String LOGIN_PAGE_HEADER_TITLE="Customer Login";
	public static final String LOGIN_PAGE_CREATE_ACCOUNT_BUTTON = "Create an Account";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String LOGIN_CONFIRM_MESSAGE = "Welcome, Akhil Chennuru!";
	
	
	public static final List<String> actHeaderDropDown() {
		List<String> actHDDList = new ArrayList<String>();
		actHDDList.add("What's New");
		actHDDList.add("Women");
		actHDDList.add("Men");
		actHDDList.add("Gear");
		actHDDList.add("Training");
		actHDDList.add("Sale");
		
		return actHDDList;
		
	}
	public static final List<String> accPageLinksCheck() {
		List<String> accLinkCheck = new ArrayList<String>();
		accLinkCheck.add("My Orders");
		accLinkCheck.add("My Downloadable Products");
		accLinkCheck.add("My Wish List");
		accLinkCheck.add("Address Book");
		accLinkCheck.add("Account Information");
		accLinkCheck.add("Stored Payment Methods");
		accLinkCheck.add("My Product Reviews");
		return accLinkCheck;
	}
}
