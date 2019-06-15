package ru.geekbrains.lesson3;

import ru.geekbrains.lesson3.queue.DequeueImpl;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        DequeueImpl<Integer> arr = new DequeueImpl<>(5);

        arr.insert(3);
        arr.push(1);
        arr.insert(2);
        arr.push(4);
        arr.insert(5);

        System.out.println(Arrays.toString(arr.getData()));
        System.out.println(arr.pop());
        System.out.println(Arrays.toString(arr.getData()));
        System.out.println(arr.remove());
        System.out.println(Arrays.toString(arr.getData()));

    }
}
