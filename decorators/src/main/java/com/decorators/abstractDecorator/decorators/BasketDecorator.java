package com.decorators.abstractDecorator.decorators;

public class BasketDecorator extends ItemDecorator {

    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", basket";
    }

    @Override
    public double getPrice() {
        return item.getPrice() + 4.0;
    }
}