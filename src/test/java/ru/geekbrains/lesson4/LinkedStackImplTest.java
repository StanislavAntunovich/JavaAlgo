package ru.geekbrains.lesson4;

import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.lesson3.stack.Stack;

import static org.junit.Assert.*;

public class LinkedStackImplTest {
    private static int ARRAY_SIZE = 10;

    private Stack<Integer> data;

    @Before
    public void setUp() throws Exception {
        data = new LinkedStackImpl<>();
        for (int i = 1; i <= ARRAY_SIZE; i++) {
            data.push(i);
        }
    }

    @Test
    public void push() {
        assertTrue(data.push(42));
        assertTrue(data.push(42));
        assertTrue(data.push(42));
        assertTrue(data.push(42));
    }

    @Test
    public void peek() {
        assertEquals(ARRAY_SIZE, data.peek().intValue());

        data.pop();
        assertEquals(ARRAY_SIZE - 1, data.peek().intValue());

        data.pop();
        assertEquals(ARRAY_SIZE - 2, data.peek().intValue());

        data.pop();
        assertEquals(ARRAY_SIZE - 3, data.peek().intValue());
    }

    @Test
    public void pop() {
        assertEquals(ARRAY_SIZE, data.pop().intValue());
        assertEquals(ARRAY_SIZE - 1, data.pop().intValue());
        assertEquals(ARRAY_SIZE - 2, data.pop().intValue());
    }

    @Test
    public void size() {
        assertEquals(ARRAY_SIZE, data.size());

        data.pop();
        assertEquals(ARRAY_SIZE - 1, data.size());

        data.pop();
        assertEquals(ARRAY_SIZE - 2, data.size());

        data.pop();
        assertEquals(ARRAY_SIZE - 3, data.size());

    }

    @Test
    public void isEmpty() {
        assertFalse(data.isEmpty());
        data.clear();
        assertTrue(data.isEmpty());
    }

    @Test
    public void isFull() {
        assertFalse(data.isFull());
        data.push(42);
        assertFalse(data.isFull());
    }

    @Test
    public void clear() {
        data.clear();
        assertTrue(data.isEmpty());
    }
}