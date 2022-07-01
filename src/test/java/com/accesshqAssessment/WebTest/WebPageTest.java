package com.accesshqAssessment.WebTest;

import com.accesshqAssessment.model.Form;
import com.accesshqAssessment.model.MenuPage;
import com.accesshqAssessment.model.Sides;
import com.accesshqAssessment.strategy.MatchingStrategy;
import com.accesshqAssessment.strategy.NameMatchingStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d2tjwct0w5ff76.cloudfront.net/");
    }

    @Test
    public void VerifyLogin() {
        driver.findElement(By.className("nav-login-signup")).click();

        var form = new Form(driver);
        form.clickLogin();
        form.clickDismiss();

        Assertions.assertFalse(driver.findElement(
                By.className("alertMessage")).isDisplayed());
    }

    @Test
    public void SwitchToSide() {
        //unable to find the sides
        driver.findElement(By.cssSelector("[aria-label=menu]")).click();
//        driver.findElement(By.cssSelector("SIDES")).click();
        for (WebElement currentElement : driver.findElements(By.className("v-slide-group__content v-tabs-bar__content"))) {
            if (currentElement.getText().equalsIgnoreCase("Sides")) {
                currentElement.click();
                break;
            }
        }
    }

    @Test
    public void VerifyNewSideDish() {
        //unable to locate the side with NEW flag;
        driver.findElement(By.cssSelector("[aria-label=menu]")).click();
        driver.findElement(By.className("ribbon"));

        var menuPage = new MenuPage(driver);

        // Did not separate the strategy and the return text method, tried to
        // make them into the same method for saving time but failed.
        // Need to Create more matching strategies, not only by String value.

        Assertions.assertEquals("Korean Sticky Wings",
                menuPage.getSideName(new NameMatchingStrategy("Korean Sticky Wings")));
    }
}
