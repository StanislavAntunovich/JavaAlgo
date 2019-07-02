package ru.geekbrains.lesson4;

import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.lesson3.queue.Queue;

import static org.junit.Assert.*;

public class LinkedQueueImplTest {
    private static int ARRAY_SIZE = 10;

    private Queue<Integer> data;

    @Before
    public void setUp() throws Exception {
        data = new LinkedQueueImpl<>();
        for (int i = 1; i <= ARRAY_SIZE ; i++) {
            data.insert(i);
        }
    }

    @Test
    public void insert() {
        assertTrue(data.insert(42));
        assertTrue(data.insert(42));
        assertTrue(data.insert(42));
        assertTrue(data.insert(42));
    }

    @Test
    public void remove() {
        assertEquals(ARRAY_SIZE, data.remove().intValue());
        assertEquals(ARRAY_SIZE - 1, data.remove().intValue());
        assertEquals(ARRAY_SIZE - 2, data.remove().intValue());
    }

    @Test
    public void isFull() {
        assertFalse(data.isFull());
    }

    @Test
    public void isEmpty() {
        assertFalse(data.isEmpty());
    }

    @Test
    public void clear() {
        data.clear();
        System.out.println(data.isEmpty() + " " + data.size());
        assertTrue(data.isEmpty());
    }
}