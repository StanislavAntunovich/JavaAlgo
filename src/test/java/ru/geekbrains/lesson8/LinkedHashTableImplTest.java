package ru.geekbrains.lesson8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedHashTableImplTest {
    HashTable<Item, Integer> table;

    @Before
    public void setUp() {
        table = new LinkedHashTableImpl<>(6);

    }

    @Test
    public void put() {
        fillTable();
        assertFalse(table.put(new Item(42, "Qiwi"), 78));
        table.remove(new Item(23, "Tomato"));
        assertEquals(5, table.size());
        assertTrue(table.put(new Item(44, "Butter"), 44));
        assertEquals(6, table.size());
    }

    @Test
    public void get() {
        fillTable();
        assertEquals(new Integer(228), table.get(new Item(77, "Banana")));
        assertNull(table.get(new Item(42, "exotic")));
    }

    @Test
    public void remove() {
        assertNull(table.get(new Item(77, "Banana")));
        fillTable();
        assertEquals(new Integer(228), table.get(new Item(77, "Banana")));
        assertEquals(6, table.size());
        table.remove(new Item(77, "Banana"));
        assertEquals(5, table.size());
        assertNull(table.get(new Item(77, "Banana")));

    }

    private void fillTable() {
        table.put(new Item(1, "Orange"), 150);
        table.put(new Item(77, "Banana"), 100);
        table.put(new Item(77, "Banana"), 228);
        table.put(new Item(60, "Lemon"), 250);
        table.put(new Item(61, "Milk"), 120);
        table.put(new Item(21, "Potato"), 67);
        table.put(new Item(23, "Tomato"), 37);
    }
}