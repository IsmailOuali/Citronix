package com.example.demo.service.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DetailRecolteServiceImplTest {

    private final DetailRecolteServiceImpl detailRecolteService = new DetailRecolteServiceImpl(null, null, null, null);

    @Test
    void testCalculateMaxQuantityForYoungArbre() {
        int age = 2;

        double maxQuantity = detailRecolteService.calculateMaxQuantity(age);

        assertEquals(2.5, maxQuantity, "Max quantity for age < 3 should be 2.5");
    }

    @Test
    void testCalculateMaxQuantityForMiddleAgedArbre() {
        int age = 8;

        double maxQuantity = detailRecolteService.calculateMaxQuantity(age);

        assertEquals(12.0, maxQuantity, "Max quantity for 3 <= age <= 10 should be 12.0");
    }

    @Test
    void testCalculateMaxQuantityForOlderArbre() {
        int age = 15;

        double maxQuantity = detailRecolteService.calculateMaxQuantity(age);

        assertEquals(20.0, maxQuantity, "Max quantity for 10 < age <= 20 should be 20.0");
    }

    @Test
    void testCalculateMaxQuantityForVeryOldArbre() {
        int age = 25;

        double maxQuantity = detailRecolteService.calculateMaxQuantity(age);

        assertEquals(0, maxQuantity, "Max quantity for age > 20 should be 0");
    }
}
