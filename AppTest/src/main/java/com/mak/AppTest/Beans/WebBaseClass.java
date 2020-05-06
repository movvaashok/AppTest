package com.mak.AppTest.Beans;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;

@Data
public class WebBaseClass {
	Logger log = LoggerFactory.getLogger(WebBaseClass.class);
	private String webResourcesPath="/resources/webTestResources";
	private WebDriver objWebDriver = null;
	private String axe_filename = "";
	private int brw_count = 0;
	private URL scriptUrl = null;
	private WebElement element = null;
	private WebElement elementParent = null;
	private WebDriver[] multidriver = new WebDriver[100];
	private boolean switchFrame = false;
	private List<WebElementAndIdentifiers> elementsAndIdentifiers;
}
