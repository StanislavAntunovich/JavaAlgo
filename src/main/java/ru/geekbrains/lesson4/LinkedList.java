package ru.geekbrains.lesson4;

public interface LinkedList<E> extends Iterable<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    boolean isEmpty();

    int size();

    void display();

    E peek();

    Entry getFirst();

    class Entry<E> {
        protected final E value;
        protected Entry<E> next;

        public Entry(E value) {
            this.value = value;
        }
    }
}
