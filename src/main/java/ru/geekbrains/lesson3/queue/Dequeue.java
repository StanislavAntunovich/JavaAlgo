package ru.geekbrains.lesson3.queue;

public interface Dequeue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeRight();
    E removeLeft();

    int size();

    boolean isFull();

    boolean isEmpty();

    void clear();
}
