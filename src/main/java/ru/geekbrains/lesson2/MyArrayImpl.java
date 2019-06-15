package ru.geekbrains.lesson2;

import java.util.Arrays;

import static java.lang.System.nanoTime;

public class MyArrayImpl<E extends Object & Comparable<? super E>> implements MyArray<E> {

    private static final int SECOND_DELIMITER = 1_000_000_000;
    private static final int MILLI_SECONDS_DELIMITER = 1_000_000;

    private static int DEFAULT_CAPACITY = 16;

    private E[] data;
    private int size;

    public MyArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayImpl(E[] data) {
        this.data = data;
        this.size = data.length;
    }

    @SuppressWarnings("unchecked")
    public MyArrayImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void add(E value) {
        checkCapacity();
        this.data[size++] = value;
    }

    @Override
    public void add(E value, int index) {
        checkCapacity();
        System.arraycopy(data, index, data, index + 1, size + index);
        data[index] = value;
        size++;
    }

    private void checkCapacity() {
        if (size == data.length) {
            data = grow();
        }
    }

    private E[] grow() {
        return Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new MyArrayStateException(index, size);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        System.arraycopy(data, index + 1, data, index, size - index);
        size--;

        return true;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size - 1; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("---------");
    }

    @SuppressWarnings("unchecked")
    @Override
    public MyArray<E> copy() {
        E[] newArr = (E[]) new Object[size];
        System.arraycopy(data, 0, newArr, 0, size);
        return new MyArrayImpl<>(newArr);
    }

    @Override
    public void bubbleSort() {
        long startTime = nanoTime();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
        long resultTime = nanoTime() - startTime;
        printResTime("Bubble", resultTime);
    }

    private void swap(int i1, int i2) {
        E temp = data[i1];
        data[i1] = data[i2];
        data[i2] = temp;
    }


    @Override
    public void selectionSort() {
        long startTime = nanoTime();

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
        long resTime = nanoTime() - startTime;
        printResTime("Selection", resTime);
    }

    @Override
    public void insertSort() {
        long startTime = nanoTime();

        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
        long resTime = nanoTime() - startTime;
        printResTime("Insert", resTime);
    }

    private void printResTime(String sortType, long time) {
        String timeType;
        double resTime;

        if (time > SECOND_DELIMITER) {
            timeType = "sec";
            resTime = (double) time / SECOND_DELIMITER;
        } else if (time > MILLI_SECONDS_DELIMITER) {
            timeType = "ms";
            resTime = (double) time / MILLI_SECONDS_DELIMITER;
        } else {
            timeType = "ns";
            resTime = time;
        }

        System.out.println(String.format("%s sort finished in %.4f %s", sortType, resTime, timeType));
    }
}
