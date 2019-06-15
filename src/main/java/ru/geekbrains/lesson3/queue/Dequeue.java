package ru.geekbrains.lesson3.queue;

import ru.geekbrains.lesson3.stack.Stack;

public interface Dequeue<E> extends Queue<E>, Stack<E> {

    E[] getData();
}
