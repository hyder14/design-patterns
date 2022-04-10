package com.hyders.designpatterns.builder;

import java.util.Objects;

public class NYPizza extends Pizza {
    public enum Size {Medium, Large, Small}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder (Size size) {
            this.size = Objects.requireNonNull(size);
        }


        @Override
        public Builder self() {
            return this;
        }

        @Override
        public NYPizza build() {
            return new NYPizza(this);
        }
    }

    private NYPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    };

    @Override
    public String toString() {
//        return super.toString();

        return String.format("Size: %1$s, Topping: %2$s",this.size,this.toppings.toString());
    }
}
