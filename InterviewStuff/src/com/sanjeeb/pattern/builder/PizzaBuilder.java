package com.sanjeeb.pattern.builder;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class PizzaBuilder {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder(12)
                .addAnchovies(true)
                .addPepperoni(true)
                .addCheese(false)
                .build();
        System.out.println(pizza.toString());
    }
}

class Pizza {
    private int size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean anchovies;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static class Builder {
        private int size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean anchovies;

        public Builder(int size) {
            this.size = size;
        }

        public Builder addCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder addPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public Builder addAnchovies(boolean anchovies) {
            this.anchovies = anchovies;
            return this;
        }

        public Pizza build() {
            Pizza pizza = new Pizza();
            pizza.size = this.size;
            pizza.anchovies = this.anchovies;
            pizza.cheese = this.cheese;
            pizza.pepperoni = this.pepperoni;
            return pizza;
        }
    }

}

