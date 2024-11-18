package com.decorators.abstractDecorator.decorators;

public class BasicItem extends Item {
    @Override
    public String getDescription() {
        return "Basic item";
    }

    @Override
    public double getPrice() {
        return 20.0;
    }
}