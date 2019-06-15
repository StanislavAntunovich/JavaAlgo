package ru.geekbrains.lesson2;

import java.util.Random;

public class MainClass {
    private static int ARRAY_CAPACITY = 10_000;

    public static void main(String[] args) {

        Random rnd = new Random();

        Integer[] targetArr = new Integer[ARRAY_CAPACITY];

        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            targetArr[i] = rnd.nextInt();
        }

        MyArray<Integer> myArray1 = new MyArrayImpl<>(targetArr); // Варианты заполнения:
        MyArray<Integer> myArray2 = new MyArrayImpl<>(targetArr); // через конструктор
        MyArray<Integer> myArray3 = myArray1.copy();              // через метод copy()

        myArray1.bubbleSort();
        myArray2.selectionSort();
        myArray3.insertSort();

    }
}
