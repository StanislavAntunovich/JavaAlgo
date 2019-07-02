package ru.geekbrains.lesson3.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueImplTest {
    private static int ARRAY_SIZE = 5;
    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new PriorityQueueImpl<>(ARRAY_SIZE);
        for (int i = ARRAY_SIZE; i > 0; i--) {
            queue.insert(i);
        }
    }

    @Test
    public void insertFalse() {
        assertFalse(queue.insert(42));
    }

    @Test
    public void insertTrue() {
        queue.remove();
        assertTrue(queue.insert(42));
    }

    @Test
    public void remove() {
        assertEquals(java.util.Optional.of(1).get(), queue.remove());
        assertEquals(java.util.Optional.of(2).get(), queue.remove());
        assertEquals(ARRAY_SIZE-2, queue.size());
    }

    @Test
    public void removeNull() {
        queue.clear();
        assertEquals(null, queue.remove());
    }

    @Test
    public void peek() {
        assertEquals(java.util.Optional.of(1).get(), queue.peek());
        assertEquals(ARRAY_SIZE, queue.size());
    }

    @Test
    public void peekNull() {
        queue.clear();
        assertEquals(null, queue.peek());
    }

    @Test
    public void clear() {
        queue.clear();
        assertTrue(queue.isEmpty());
    }


}