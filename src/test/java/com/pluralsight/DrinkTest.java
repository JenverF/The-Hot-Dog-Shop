package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    public void testSmallDrinkPrice() {
        Drink drink = new Drink("small", "cola");
        assertEquals(2.00, drink.getPrice());
        assertEquals("small cola PRICE: $2.0", drink.getSummary());
    }

    @Test
    public void testMediumDrinkPrice() {
        Drink drink = new Drink("medium", "sprite");
        assertEquals(2.50, drink.getPrice());
        assertEquals("medium sprite PRICE: $2.5", drink.getSummary());
    }

    @Test
    public void testLargeDrinkPrice() {
        Drink drink = new Drink("large", "root beer");
        assertEquals(3.00, drink.getPrice(), 0.001);
        assertEquals("large root beer PRICE: $3.0", drink.getSummary());
    }
}