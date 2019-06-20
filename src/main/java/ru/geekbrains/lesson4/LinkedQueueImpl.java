package ru.geekbrains.lesson4;

import ru.geekbrains.lesson3.queue.Queue;

public class LinkedQueueImpl<E> extends LinkedListImpl<E> implements Queue<E> {

    @Override
    public boolean insert(E value) {
        super.insertFirst(value);
        return true;
    }

    @Override
    public E remove() {
        return super.removeFirst();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        firstElement = null;
    }

}
