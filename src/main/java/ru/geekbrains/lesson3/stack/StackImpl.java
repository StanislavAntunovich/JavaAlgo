package ru.geekbrains.lesson3.stack;

public class StackImpl<E> implements Stack<E> {

    protected E[] data;
    protected int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxSize) {
        data = (E[]) new Object[maxSize];
    }

    /**
     * @return true if value pushed else false
     */
    @Override
    public boolean push(E value) {
        if (!isFull()) {
            data[size++] = value;
            return true;
        }
        return false;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : data[size - 1];
    }

    @Override
    public E pop() {
        return isEmpty() ? null : data[--size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
