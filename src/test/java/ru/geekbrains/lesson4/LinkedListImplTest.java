package ru.geekbrains.lesson4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListImplTest {
    private static int ARRAY_SIZE = 10;

    private LinkedList<Integer> data;

    @Before
    public void setUp() {
        data = new LinkedListImpl<>();
        for (int i = 1; i <= ARRAY_SIZE; i++) {
            data.insertFirst(i);
        }
    }

    @Test
    public void insertFirst() {
        data.insertFirst(1);
        assertEquals(ARRAY_SIZE + 1, data.size());

        data.insertFirst(1);
        assertEquals(ARRAY_SIZE + 2, data.size());

        data.insertFirst(1);
        assertEquals(ARRAY_SIZE + 3, data.size());
    }

    @Test
    public void removeFirst() {
        assertEquals(ARRAY_SIZE, data.removeFirst().intValue());
        assertEquals(ARRAY_SIZE - 1, data.removeFirst().intValue());
    }

    @Test
    public void remove() {
        assertTrue(data.remove(5));
        assertFalse(data.remove(42));
    }

    @Test
    public void contains() {
        assertFalse(data.contains(ARRAY_SIZE + 42));
        assertTrue(data.contains(ARRAY_SIZE));
    }

    @Test
    public void isEmpty() {
        assertFalse(data.isEmpty());
        clearData();
        assertTrue(data.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(ARRAY_SIZE, data.size());
        data.removeFirst();
        assertEquals(ARRAY_SIZE - 1, data.size());
    }

    @Test
    public void peek() {
        assertEquals(ARRAY_SIZE, data.peek().intValue());
        data.removeFirst();
        assertEquals(ARRAY_SIZE - 1, data.peek().intValue());
    }

    @Test
    public void iterator() {
        int i = ARRAY_SIZE;

        for (int value : data) {
            assertEquals(i--, value);
        }
    }

    private void clearData() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            data.removeFirst();
        }
    }
}