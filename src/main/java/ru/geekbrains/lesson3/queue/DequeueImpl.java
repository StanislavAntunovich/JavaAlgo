package ru.geekbrains.lesson3.queue;

public class DequeueImpl<E> implements Dequeue<E> {
    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;

    private int size;
    private E[] data;

    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public DequeueImpl(int maxSize) {
        data = (E[]) new Object[maxSize];
        head = DEFAULT_HEAD;
        tail = DEFAULT_TAIL;
    }


    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if (head == DEFAULT_HEAD) {
            head = data.length;
        }
        data[--head] = value;
        size++;
        return true;
    }

    private int lastIndex() {
        return data.length - 1;
    }

    @Override
    public boolean insertRight(E value) {
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

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        if (tail < 0)
            tail = lastIndex();

        size--;
        return data[tail--];
    }

    @Override
    public E removeLeft() {
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
