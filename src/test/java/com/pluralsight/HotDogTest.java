package com.pluralsight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotDogTest {
    private HotDog smallHotDog;
    private HotDog mediumHotDog;
    private HotDog largeHotDog;

    @BeforeEach
    void setUp() {
        smallHotDog = new HotDog("small", "regular", false);
        mediumHotDog = new HotDog("medium", "spicy", true);
        largeHotDog = new HotDog("large", "cheesy", false);
    }

    @Test
    void addExtraTopping() {
        smallHotDog.addExtraTopping("onions"); // small + 0.30
        assertEquals(4.30, smallHotDog.getPrice());

        largeHotDog.addExtraTopping("jalapenos"); // large + 0.90
        assertEquals(7.90, largeHotDog.getPrice());

        mediumHotDog.addExtraTopping("tomatoes");
        assertEquals(6.35, mediumHotDog.getPrice());
    }

    @Test
    void addPremiumTopping() {
        smallHotDog.addPremiumTopping("chili"); // small + 0.75
        assertEquals(4.75, smallHotDog.getPrice());

        mediumHotDog.addPremiumTopping("bacon"); // medium + 1.0
        assertEquals(6.75, mediumHotDog.getPrice());
    }

    @Test
    void testToastedBun() {
        smallHotDog.addPremiumTopping("chili");
        smallHotDog.addExtraTopping("onions");
        assertEquals(5.05, smallHotDog.getPrice());

        mediumHotDog.addExtraTopping("cheese");
        assertEquals(5.50 + 0.25 + 0.60, mediumHotDog.getPrice());
    }

    @Test
    void testSummaryNotEmpty() {
        smallHotDog.addPremiumTopping("chili");
        smallHotDog.addExtraTopping("onions");
        smallHotDog.addCondiments("mustard");

        String summary = smallHotDog.getSummary();
        assertTrue(summary.contains("small"));
        assertTrue(summary.contains("chili"));
        assertTrue(summary.contains("onions"));
        assertTrue(summary.contains("mustard"));
    }
}