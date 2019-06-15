package ru.geekbrains.lesson3.queue;

public class DequeueImpl<E> implements Dequeue<E> {

    private int size;
    private E[] data;

    @SuppressWarnings("unchecked")
    public DequeueImpl(int maxSize) {
        data = (E[]) new Object[maxSize];
    }

    @Override
    public boolean insert(E value) {
        if (!isFull()) {
            size++;
            System.arraycopy(data, 0, data, 1, data.length - 1);
            data[0] = value;
            return true;
        }
        return false;
    }

    @Override
    public E remove() {
        if (!isEmpty()) {
            E targetValue = data[0];
            System.arraycopy(data, 1, data, 0, data.length - 1);
            size--;
            return targetValue;
        }
        return null;
    }

    @Override
    public boolean push(E value) {
        if (!isFull()) {
            data[size++] = value;
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
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public E[] getData() {
        E[] targetArr = (E[]) new Object[size];
        System.arraycopy(data, 0, targetArr, 0, size);
        return targetArr;
    }
}
