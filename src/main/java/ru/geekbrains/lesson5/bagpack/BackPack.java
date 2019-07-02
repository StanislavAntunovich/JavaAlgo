package ru.geekbrains.lesson5.bagpack;

import java.util.ArrayList;
import java.util.List;

public class BackPack {
    private final int maxWeight;

    private List<Item> bestSet;
    private double bestPrice;

    public BackPack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private  int calcWeight(List<Item> items) {
        int sumWeight = 0;
        for (Item item : items) {
            sumWeight += item.getWeight();
        }
        return sumWeight;
    }

    public void calc(List<Item> items) {
        if (items.size() > 0) {
            bestSet(items);
        }

        for (int i = 0; i < items.size(); i++) {
            List<Item> list = new ArrayList<>(items);
            list.remove(i);
            calc(list);
        }
    }

    private int calcPrice(List<Item> items) {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    private void bestSet(List<Item> items) {
        if (bestSet == null) {
            if (calcWeight(items) <= maxWeight) {
                bestSet = items;
                bestPrice = calcPrice(items);
            }
        } else {
            if (calcWeight(items) <= maxWeight && calcPrice(items) > bestPrice) {
                bestSet = items;
                bestPrice = calcPrice(items);
            }
        }
    }

    public List<Item> getBestSet() {
        return bestSet;
    }

    public double getBestPrice() {
        return bestPrice;
    }

    public double getFilledWeight() {
        return bestSet.stream().mapToDouble(Item::getWeight).sum();
    }
}
