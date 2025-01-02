package org.example.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage {

    WebDriver driver = null;
    WebDriverWait wait = null;
    private static final Logger log = Logger.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    // element bulma
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // element kaybolana kadar bekleme ve tıklama
    public void waitUntilElementInvisibleAndClick(By invisibleLocator, By visibleLocator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(invisibleLocator));
        click(visibleLocator);
    }

    // tıklama
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).click();
    }

    // veri gönderme
    public void sendKeys(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).sendKeys(text);
    }

    // klavye tuşları kullanabilecek şekilde veri gönderme
    public void sendKeysCharSequence(By locator, CharSequence keysToSend) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).sendKeys(keysToSend);
    }

    // element üzerine hover
    public void hoverElement(By locator) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(locator)).build().perform();
    }

    // text alma
    public String getText(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return findElement(locator).getText();
    }

    // text normalize işlemi
    public String normalizeText(String text) {
        return text.replaceAll("\\s+", " ");
    }

    // text karşılaştırma
    public void assertTextEquals(By locator, String expectedText) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        String actualText = findElement(locator).getText().trim();

        String normalizedExpectedText = normalizeText(expectedText);
        String normalizedActualText = normalizeText(actualText);
        Assert.assertEquals(normalizedExpectedText, normalizedActualText);
    }

    // attribute ile assertion
    public void assertWithAttribute(By locator, String attribute, String expectedValue) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        String actualText = findElement(locator).getAttribute(attribute).trim();

        String normalizedExpectedText = normalizeText(expectedValue);
        String normalizedActualText = normalizeText(actualText);
        Assert.assertEquals(normalizedExpectedText, normalizedActualText);
    }

    // title karşılaştırma
    public void assertTitleEquals(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    // içerik temizleme
    public void clearInput(By locator) {
        findElement(locator).clear();
    }
}
