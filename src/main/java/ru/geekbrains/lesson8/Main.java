package ru.geekbrains.lesson8;

public class Main {
    public static void main(String[] args) {
        HashTable<Item, Integer> hashTable = new LinkedHashTableImpl<>(10);

        hashTable.put(new Item(1, "Orange"), 150);
        hashTable.put(new Item(77, "Banana"), 100);
        hashTable.put(new Item(77, "Banana"), 228);
        hashTable.put(new Item(60, "Lemon"), 250);
        hashTable.put(new Item(61, "Milk"), 120);
        hashTable.put(new Item(21, "Potato"), 67);
        hashTable.put(new Item(63, "SMTH"), 67);
        hashTable.put(new Item(64, "SMTH1"), 67);
        hashTable.put(new Item(65, "SMTH2"), 67);
        hashTable.put(new Item(66, "SMTH3"), 67);
        hashTable.put(new Item(66, "SMTH3"), 67);

        System.out.println("Size is " + hashTable.size());
        hashTable.display();

        System.out.println("Cost potato is " + hashTable.get(new Item(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Item(77, "Banana")));

        hashTable.remove(new Item(21, "Potato"));
        hashTable.remove(new Item(77, "Banana"));

        System.out.println("Cost potato is " + hashTable.get(new Item(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Item(77, "Banana")));
        System.out.println("Cost smth3 is " + hashTable.get(new Item(66, "SMTH3")));


        hashTable.display();
    }
}
