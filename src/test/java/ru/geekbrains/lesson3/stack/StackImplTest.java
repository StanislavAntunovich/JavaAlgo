package ru.geekbrains.lesson3.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackImplTest {
    private static final int ARRAY_SIZE = 5;
    private Stack<Integer> stack;

    @Before
    public void init() {
        stack = new StackImpl<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            stack.push(i);
        }
    }

    @Test
    public void push() {
        assertFalse(stack.push(42));
        stack.pop();
        assertTrue(stack.push(42));
    }

    @Test
    public void peek() {
        assertEquals(java.util.Optional.of(ARRAY_SIZE - 1).get(), stack.peek());
        stack.clear();
        assertEquals(null, stack.peek());
    }

    @Test
    public void pop() {
        assertEquals(java.util.Optional.of(ARRAY_SIZE - 1).get(), stack.pop());
        stack.clear();
        assertEquals(null, stack.pop());
    }

    @Test
    public void size() {
        assertEquals(ARRAY_SIZE, stack.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isFull() {
        assertTrue(stack.isFull());
        stack.pop();
        assertFalse(stack.isFull());
    }
}