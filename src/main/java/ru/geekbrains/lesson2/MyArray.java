package ru.geekbrains.lesson2;

public interface MyArray<E> {
    void add(E value);
    void add(E value, int index);

    E get(int index);

    int size();

    boolean remove(E value);

    default boolean contains(E value) {
        return indexOf(value) != -1;
    }

    int indexOf(E value);

    boolean isEmpty();

    void display();

    MyArray<E> copy();

    void bubbleSort();

    void selectionSort();

    void insertSort();
}
