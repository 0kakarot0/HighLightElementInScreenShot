package test;

import base.BaseClass;
import org.testng.annotations.Test;

public class CaptureScreenShotWithHighlightedArea extends BaseClass {

    @Test
    public void highlightElementInScreenShot(){
        loginPage.setEmail("dummy@test.com");
        loginPage.setPassword("123456");
        loginPage.clickLoginBtn();
        loginPage.getValidationMessage();
    }
}
