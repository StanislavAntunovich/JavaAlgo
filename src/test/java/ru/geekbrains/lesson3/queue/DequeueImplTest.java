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
            dequeue.insertRight(i);
        }
    }

    @Test
    public void insertRight() {
        assertFalse(dequeue.insertRight(42));
        assertEquals(ARRAY_SIZE, dequeue.size());
    }

    @Test
    public void removeLeft() {
        assertEquals(java.util.Optional.of(0).get(), dequeue.removeLeft());
        assertEquals(java.util.Optional.of(1).get(), dequeue.removeLeft());
        dequeue.clear();
        assertEquals(null, dequeue.removeLeft());
    }

    @Test
    public void insertLeft() {
        assertFalse(dequeue.insertLeft(42));
        assertEquals(5, dequeue.size());
    }

    @Test
    public void removeRight() {
        assertEquals(java.util.Optional.of(ARRAY_SIZE - 1).get(), dequeue.removeRight());
        assertEquals(java.util.Optional.of(ARRAY_SIZE - 2).get(), dequeue.removeRight());
    }

    @Test
    public void removeRightNull() {
        dequeue.clear();
        assertEquals(null, dequeue.removeRight());
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
        dequeue.removeRight();
        assertFalse(dequeue.isFull());
    }

    @Test
    public void isEmptyFalse() {
        assertFalse(dequeue.isEmpty());
    }

    @Test
    public void isEmptyTrue() {
        dequeue.clear();
        assertTrue(dequeue.isEmpty());
    }

    @Test
    public void mixedTest() {
        dequeue.clear();
        dequeue.insertLeft(0);
        assertEquals(java.util.Optional.of(0).get(), dequeue.removeRight());
        dequeue.insertLeft(1);
        dequeue.insertLeft(2);
        dequeue.insertRight(3);
        assertEquals(java.util.Optional.of(2).get(), dequeue.removeLeft());
        assertEquals(java.util.Optional.of(3).get(), dequeue.removeRight());

    }

}