package ru.geekbrains.lesson3;

import ru.geekbrains.lesson3.stack.Stack;
import ru.geekbrains.lesson3.stack.StackImpl;

public class MainClass {

    public static void main(String[] args) {
        printReversedString("Hello World");
    }

    public static void printReversedString(String string) {
        Stack<Character> stack = new StackImpl<>(string.length());
        for (Character ch : string.toCharArray()) {
            stack.push(ch);
        }

        System.out.println();

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        System.out.println();
    }
}
