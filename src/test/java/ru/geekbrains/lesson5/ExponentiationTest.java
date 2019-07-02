package ru.geekbrains.lesson5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExponentiationTest {

    @Test
    public void pow() {
        assertEquals(8, Exponentiation.pow(2, 3), 0.0001);
        assertEquals(9, Exponentiation.pow(3, 2), 0.0001);
        assertEquals(1, Exponentiation.pow(0, 0), 0.0001);
        assertEquals(1, Exponentiation.pow(1, 0), 0.0001);
        assertEquals(1, Exponentiation.pow(2, 0), 0.0001);
    }

    @Test
    public void powMinus() {
        assertEquals(0.5, Exponentiation.pow(2, -1), 0.0001);
        assertEquals(0.25, Exponentiation.pow(2, -2), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void powException() {
        Exponentiation.pow(0, -1);
    }

}