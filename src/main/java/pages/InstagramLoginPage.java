package pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class InstagramLoginPage {

    private WebDriver driver;
    private By email = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//*[@id=\"loginForm\"]/div[1]/div[3]/button");
    private By errorMessage = By.id("slfErrorAlert");

    public InstagramLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String emailString){
        driver.findElement(email).sendKeys(emailString);
    }

    public void setPassword(String passwordString) {
        driver.findElement(password).sendKeys(passwordString);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }
    public void getValidationMessage(){
        WebElement validationMessage = driver.findElement(errorMessage);
        Boolean isElementDisplayed = validationMessage.isDisplayed();
        if (isElementDisplayed){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].style.border='2px solid red'", validationMessage);
            var getScreenShot = (TakesScreenshot) driver;
            File screenShot = getScreenShot.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenShot, new File("src/test/resources/screenShots/validationError.png"));
            } catch (IOException e) {
                e.getStackTrace();
                e.getMessage();
            }
        }
        else{
            System.out.println("Element No Displayed");
        }

    }
}
