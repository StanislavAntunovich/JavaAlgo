package ru.geekbrains.lesson5.bagpack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BackPackTest {
    private BackPack backPack;

    private List<Item> set1;
    private List<Item> set2;


    @Before
    public void setUp() {
        set1 = new ArrayList<>(Arrays.asList(
                new Item("Ножницы", 1, 300),
                new Item("Ножницы", 1, 300),
                new Item("Степлер", 2, 200),
                new Item("Пачка бумаги", 10, 1000),
                new Item("Пачка бумаги", 7, 1000),
                new Item("Дырокол", 15, 100),
                new Item("Набор ручек", 7, 2500),
                new Item("Степлер", 2, 200),
                new Item("Клей", 6, 800)
        ));

        set2 = new ArrayList<>(Arrays.asList(
                new Item("Ром", 2, 600),
                new Item("Тыкила", 4, 1200),
                new Item("Пиво", 6, 600),
                new Item("Самбука", 4, 1400),
                new Item("Виски", 4, 500),
                new Item("Вино", 2, 300),
                new Item("Шампанское", 2, 700)
        ));
    }

    @Test
    public void calc1() {
        backPack = new BackPack(31);
        backPack.calc(set1);
        assertEquals(5600, backPack.getBestPrice(), 0.0001);
        assertEquals(31, backPack.getFilledWeight(), 0.0001);

    }

    @Test
    public void calc2() {
        backPack = new BackPack(21);
        backPack.calc(set2);
        assertEquals(4800, backPack.getBestPrice(), 0.0001);
        assertEquals(20, backPack.getFilledWeight(), 0.0001);
    }

}