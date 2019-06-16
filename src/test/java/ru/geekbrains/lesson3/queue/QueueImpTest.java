package ru.geekbrains.lesson3.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueImpTest {
    private static final int ARRAY_SIZE = 5;
    private Queue<Integer> queue;

    @Before
    public void init() {
        queue = new QueueImpl<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            queue.insert(i);
        }
    }

    @Test
    public void insert() {
        assertFalse(queue.insert(42));
        assertEquals(ARRAY_SIZE, queue.size());
    }

    @Test
    public void remove() {
        assertEquals(java.util.Optional.of(0).get(), queue.remove());
        assertEquals(ARRAY_SIZE - 1, queue.size());
    }

    @Test
    public void peek() {
        assertEquals(java.util.Optional.of(0).get(), queue.peek());
        queue.remove();
        assertEquals(java.util.Optional.of(1).get(), queue.peek());
    }

    @Test
    public void size() {
        assertEquals(ARRAY_SIZE, queue.size());
        queue.remove();
        assertEquals(ARRAY_SIZE - 1, queue.size());
    }

    @Test
    public void isFull() {
        assertTrue(queue.isFull());
        queue.remove();
        assertFalse(queue.isFull());
    }

    @Test
    public void isEmpty() {
        assertFalse(queue.isEmpty());
        queue.clear();
        assertTrue(queue.isEmpty());
    }
}