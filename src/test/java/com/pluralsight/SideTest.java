package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SideTest {

    @Test
    public void testSidePrice() {
        Side side = new Side("fries");
        assertEquals(1.50, side.getPrice());
    }

    @Test
    public void testSideNameIsSetCorrectly() {
        Side side = new Side("chips");
        assertEquals("chips", side.getName());
    }

    @Test
    public void testSideSummaryFormatting() {
        Side side = new Side("coleslaw");
        assertEquals("coleslaw PRICE: $1.5", side.getSummary());
    }
}