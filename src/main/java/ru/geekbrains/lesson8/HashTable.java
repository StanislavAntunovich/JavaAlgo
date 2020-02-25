package ru.geekbrains.lesson8;

public interface HashTable<I extends Item, V> {

    boolean put(I item, V cost);

    V get(I item);

    boolean remove(I item);

    int size();

    boolean isEmpty();

    void display();
}
