package ru.geekbrains.lesson4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSidesLinkedListImplTest {
    private static int ARRAY_SIZE = 10;

    private TwoSidesLinkedList<Integer> data;

    @Before
    public void setUp() {
        data = new TwoSidesLinkedListImpl<>();
        for (int i = 1; i <= ARRAY_SIZE; i++) {
            data.insertFirst(i);
        }
    }

    @Test
    public void insertLast() {
        data.insertLast(42);
        assertEquals(ARRAY_SIZE + 1, data.size());
        for (int i = 0; i < ARRAY_SIZE; i++) {
            data.removeFirst();
        }
        assertEquals(42, data.removeFirst().intValue());
    }

    @Test
    public void insertFirst() {
        data.insertFirst(42);
        assertEquals(42, data.removeFirst().intValue());
    }

    @Test
    public void removeFirst() {
        assertEquals(ARRAY_SIZE, data.removeFirst().intValue());
    }

    @Test
    public void remove() {
        assertTrue(data.remove(ARRAY_SIZE));
        assertFalse(data.remove(ARRAY_SIZE + 42));
    }
}