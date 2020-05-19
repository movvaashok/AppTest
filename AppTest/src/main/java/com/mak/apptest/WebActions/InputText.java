package com.mak.apptest.WebActions;

import com.mak.apptest.Beans.WebBaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputText {
    Logger log = LoggerFactory.getLogger(WebBaseClass.class);
    @Autowired
    WebBaseClass webBaseClass;

    public Boolean inputText(String Keyword, String objName, String value) {

        try {
            if (webBaseClass.getElement().isDisplayed()) {
                log.info("Object is visible: " + objName);
                if (webBaseClass.getElement().isEnabled() == true) {
                    ((JavascriptExecutor) webBaseClass.getObjWebDriver()).executeScript("window.focus();");
                    try {
                        wait(1000);
                        webBaseClass.getElement().click();
                        wait(500);
                        webBaseClass.getElement().clear();
                        wait(500);
                        webBaseClass.getElement().sendKeys(value);
                        wait(500);
                        if (webBaseClass.getElement().getText().equals(value)) {
                            log.info("Text Entered: " + value);
                        }
                    } catch (Exception e) {
                        log.info("Text Verification Exception");
                        return false;
                    }
                    return true;
                } else {
                    log.info("Web object is not enabled : " + objName);
                    return false;
                }

            } else {
                log.info("Web object is not visible : " + objName);
                return false;
            }
        } catch (Exception e) {
            log.error("Input Action Failed ", e);
            return false;
        }
    }

    private void wait(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
            log.error("Exception in Thread Sleep of " + this.getClass().getName(), e);
        }
    }

}
