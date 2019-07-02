package ru.geekbrains.lesson3.queue;

public class QueueImpl<E> implements Queue<E> {

    protected static final int DEFAULT_HEAD = 0;
    protected static final int DEFAULT_TAIL = -1;

    protected E[] data;

    protected int size;

    protected int head;
    protected int tail;

    private int maxSize;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        data = (E[]) new Object[maxSize];
        head = DEFAULT_HEAD;
        tail = DEFAULT_TAIL;
        this.maxSize = maxSize;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == lastIndex()) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    private int lastIndex() {
        return data.length - 1;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        size--;
        return data[head++];
    }

    @Override
    public E peek() {
        return isEmpty() ? null : data[head];
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
    @Override
    public void clear() {
        tail = DEFAULT_TAIL;
        head = DEFAULT_HEAD;
        size = 0;
        data = (E[]) new Object[maxSize];
    }
}
