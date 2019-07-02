package ru.geekbrains.lesson6;

public interface Tree<E> {

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
    }

    boolean add(E value);

    boolean find(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void traverse(TraverseMode mode);

    boolean isBalanced();

    static <T extends Node> boolean isBalanced(T node) {
        return (node == null) || isBalanced(node.getLeftChild()) &&
                isBalanced(node.getRightChild()) &&
                Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    static <T extends Node> int height(T node) {
        return node == null ?
                0 :
                1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
