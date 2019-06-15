package ru.geekbrains.lesson2;

public class MyArrayStateException extends RuntimeException {

    public MyArrayStateException(int index, int size) {
        super(String.format("Index %d out of bounds; Array size is %d", index, size));
    }
}
