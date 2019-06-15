package ru.geekbrains.lesson3.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DequeueImplTest {
    private static int ARRAY_SIZE = 5;

    private Dequeue<Integer> dequeue;

    @Before
    public void init() {
        this.dequeue = new DequeueImpl<>(ARRAY_SIZE);
        for (int i = 0; i <= ARRAY_SIZE; i++) {
            dequeue.push(i);
        }
    }

    @Test
    public void insert() {
        assertFalse(dequeue.insert(42));
        assertEquals(ARRAY_SIZE, dequeue.size());
    }

    @Test
    public void remove() {
        assertEquals(java.util.Optional.of(0).get(), dequeue.remove());
        clearDequeue();
        assertEquals(null, dequeue.remove());
    }

    private void clearDequeue() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            dequeue.remove();
        }
    }

    @Test
    public void push() {
        assertFalse(dequeue.push(42));
        assertEquals(5, dequeue.size());
    }

    @Test
    public void peek() {
        assertEquals(java.util.Optional.of(ARRAY_SIZE - 1).get(), dequeue.peek());
    }

    @Test
    public void peekNull() {
        clearDequeue();
        assertEquals(null, dequeue.peek());
    }

    @Test
    public void pop() {
        assertEquals(java.util.Optional.of(4).get(), dequeue.pop());
        assertEquals(java.util.Optional.of(3).get(), dequeue.pop());
    }

    @Test
    public void popNull() {
        clearDequeue();
        assertEquals(null, dequeue.pop());
    }

    @Test
    public void size() {
        assertEquals(ARRAY_SIZE, dequeue.size());
    }

    @Test
    public void isFull() {
        assertTrue(dequeue.isFull());
    }

    @Test
    public void isFullFalse() {
        dequeue.remove();
        assertFalse(dequeue.isFull());
    }

    @Test
    public void isEmpty() {
        assertFalse(dequeue.isEmpty());
    }

    @Test
    public void isEmptyTrue() {
        clearDequeue();
        assertTrue(dequeue.isEmpty());
    }

}