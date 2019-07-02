package ru.geekbrains.lesson6;

public class Node<L extends Comparable<? super L>> {

    private final L value;

    private int level;

    private Node<L> leftChild;
    private Node<L> rightChild;


    public Node(L value) {
        this.value = value;
    }

    public L getValue() {
        return value;
    }

    public Node<L> getLeftChild() {
        return leftChild;
    }

    public Node<L> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node<L> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<L> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean shouldBeLeft(L value) {
        return value.compareTo(getValue()) < 0;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
