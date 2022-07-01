package com.accesshqAssessment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;

public class Sides {

    private final WebElement sideElement;

    public Sides(WebElement planetElement) {
        this.sideElement = planetElement;
    }

    public String getName() {
        return sideElement.findElement(By.className("name")).getText();
    }

    public String getDescription() {
        return sideElement.findElement(By.className("description")).getText();
    }

}
