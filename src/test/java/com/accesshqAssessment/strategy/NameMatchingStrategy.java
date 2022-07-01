package com.accesshqAssessment.strategy;

import com.accesshqAssessment.model.Sides;

import java.text.ParseException;

public class NameMatchingStrategy implements MatchingStrategy{
    private final String name;

    public NameMatchingStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean match(Sides side) {
        return side.getName().equalsIgnoreCase(name);
    }
}
