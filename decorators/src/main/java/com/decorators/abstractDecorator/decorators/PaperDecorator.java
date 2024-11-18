package com.decorators.abstractDecorator.decorators;

public class PaperDecorator extends ItemDecorator {
    
    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", paper";
    }

    @Override
    public double getPrice() {
        return item.getPrice() + 13.0;
    }
}