package com.mak.AppTest.WebActions;

import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mak.AppTest.Beans.WebBaseClass;

public class LaunchWeb {
	Logger log = LoggerFactory.getLogger(WebBaseClass.class);
	@Autowired
	WebBaseClass webBaseClass;

	public boolean launchWebBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", webBaseClass.getWebResourcesPath() + "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("disable-infobars");
		webBaseClass.setObjWebDriver(new ChromeDriver(options));
		webBaseClass.getObjWebDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		webBaseClass.getObjWebDriver().get(url);
		BiFunction<WebDriver, String, Boolean> waitForLoad = (driver, webPageState) -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").equals(webPageState);
		if (waitForLoad.apply(webBaseClass.getObjWebDriver(), "complete")) {
			log.info("Browser Launched Successfully");
			return true;
		} else if (waitForLoad.apply(webBaseClass.getObjWebDriver(), "Interactive")) {
			log.info("Failed to load web page.");
			return false;
		} else {
			return false;
		}
	}

	public void threadSleep(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
			log.error("Exception in Thread Sleep of " + this.getClass().getName(), e);
		}
	}
}
