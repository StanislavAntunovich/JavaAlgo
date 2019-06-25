package ru.geekbrains.lesson6;


import java.util.Random;

public class MainClass {
    private static int MAX_LEVELS = 4;
    private static int MIN_VALUE = -25;
    private static int MAX_VALUE = 25;
    private static int TREES_COUNT = 20;

    private static final Random rnd = new Random();

    public static void main(String[] args) {
        
        int balancedTrees = 0;

        for (int i = 0; i < TREES_COUNT; i++) {
            Tree<Integer> tree = setUpTree(MAX_LEVELS, MAX_VALUE, MIN_VALUE);
            if (tree.isBalanced()) {
                balancedTrees++;
            }
        }

        System.out.println("PCT of balanced trees is " + calcBalancedTreesPCT(balancedTrees, TREES_COUNT) + "%");

    }

    private static Tree<Integer> setUpTree(int maxLevels, int maxValue, int minValue) {
        int nodeCount = (int) Math.pow(2, maxLevels) - 1;

        Tree<Integer> tree = new TreeImpl<>(maxLevels);

        for (int i = 0; i < nodeCount; i++) {
            tree.add(rnd.nextInt(maxValue - minValue + 1) + minValue);
        }

        return tree;
    }

    private static double calcBalancedTreesPCT(int balancedTreesCount, int totalTrees) {
        return balancedTreesCount / (double) totalTrees * 100;
    }
}
