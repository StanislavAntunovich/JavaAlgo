package ru.geekbrains.lesson4;

public class MainClass {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedListImpl<>();

        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertFirst(4);
        ll.insertFirst(5);
        ll.insertFirst(6);
        ll.insertFirst(7);
        ll.insertFirst(8);
        ll.insertFirst(9);
        ll.insertFirst(10);

        for (Integer s : ll) {
            System.out.print(s + " ");
        }

        System.out.println();
        System.out.println(ll.removeFirst());
    }
}
