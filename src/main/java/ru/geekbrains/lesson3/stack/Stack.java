package ru.geekbrains.lesson3.stack;

public interface Stack<E> {
    boolean push(E value);

    E peek();

    E pop();

    int size();

    boolean isEmpty();

    boolean isFull();

    void clear();
}
