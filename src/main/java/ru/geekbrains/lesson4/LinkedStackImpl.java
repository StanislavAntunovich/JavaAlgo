package ru.geekbrains.lesson4;

import ru.geekbrains.lesson3.stack.Stack;

public class LinkedStackImpl<E> implements Stack<E> {

    private LinkedList<E> data = new LinkedListImpl<>();

    @Override
    public boolean push(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public E peek() {
        return data.peek();
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void clear() {
        data = new LinkedListImpl<>();
    }
}
