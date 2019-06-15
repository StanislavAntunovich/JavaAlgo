package ru.geekbrains.lesson3.queue;

public class QueueImp<E> implements Queue<E> {

    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;

    protected E[] data;

    protected int size;

    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public QueueImp(int maxSize) {
        data = (E[]) new Object[maxSize];
        head = DEFAULT_HEAD;
        tail = DEFAULT_TAIL;
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
}
