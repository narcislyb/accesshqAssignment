package com.accesshqAssessment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Form {
    private final WebDriver driver;

    public Form(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        for (WebElement currentElement : driver.findElements(By.tagName("button"))) {
            if (currentElement.getText().equalsIgnoreCase("login")) {
                currentElement.click();
                break;
            }
        }
    }

    public void clickDismiss() {
        this.waitForPopupMessage();
        for (WebElement currentElement : driver.findElements(By.tagName("button"))) {
            if (currentElement.getText().equalsIgnoreCase("cancel")) {
                currentElement.click();
                break;
            }
        }
    }

    public void waitForPopupMessage() {
        var popupElement = driver.findElement(By.className("alertMessage"));
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(popupElement));
    }
}
