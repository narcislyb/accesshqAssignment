package com.accesshqAssessment.model;

import com.accesshqAssessment.strategy.MatchingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MenuPage {

    private final WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<Sides> getSides() {
        ArrayList<Sides> sides = new ArrayList<>();
        for (WebElement side : driver.findElements(By.className("sides"))) {
            sides.add(new Sides(side));
        }
        return sides;
    }

    public String getSideName(MatchingStrategy strategy) {
        for (Sides side : getSides()) {
            if (strategy.match(side)) {
                return side.getName();
            }
        }
        return null;
    }

    public String getTextByName(MatchingStrategy strategy) {
        //TODO get the return text by found element
        return null;
    }

}
