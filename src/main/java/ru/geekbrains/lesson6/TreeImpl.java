package ru.geekbrains.lesson6;

public class TreeImpl<N extends Comparable<? super N>> implements Tree<N> {

    private Node<N> root;
    private int size;

    private int maxLevel;

    public TreeImpl() {
        this(-1);
    }

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public boolean add(N value) {
        Node<N> newNode = new Node<>(value);
        if (isEmpty()) {
            this.root = newNode;
            return true;
        }

        NodeAndParent nodeAndParent = doFind(value);
        if (nodeAndParent.current != null) {
            return false;
        }


        Node<N> parent = nodeAndParent.parent;
        if (maxLevel != -1 && ((parent.getLevel() + 1) > maxLevel)) {
            return false;
        }

        newNode.setLevel(parent.getLevel() + 1);

        if (parent.shouldBeLeft(value)) {
            parent.setLeftChild(newNode);
        } else {
            parent.setRightChild(newNode);
        }

        size++;
        return true;
    }

    @Override
    public boolean find(N value) {
        return doFind(value).current != null;
    }

    private NodeAndParent doFind(N value) {
        Node<N> parent = null;
        Node<N> current = this.root;

        current.setLevel(1);

        while (current != null) {

            if (parent != null) {
                current.setLevel(parent.getLevel() + 1);
            }

            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent);
            }

            parent = current;

            current = current.shouldBeLeft(value) ?
                    current.getLeftChild() :
                    current.getRightChild();
        }

        return new NodeAndParent(null, parent);
    }

    private Node<N> getSuccessor(Node<N> removedNode) {
        Node<N> successor = removedNode;
        Node<N> successorParent = null;
        Node<N> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    @Override
    public boolean remove(N value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<N> parent = nodeAndParent.parent;
        Node<N> removedNode = nodeAndParent.current;

        if (removedNode == null) {
            return false;
        }

        if (removedNode.isLeaf()) {
            removeLeafNode(parent, removedNode);
        } else if (hasOnlySingleChildNode(removedNode)) {
            removeNodeWithSingleChild(parent, removedNode);
        } else {
            removeCommonNode(parent, removedNode);
        }

        size--;
        return true;
    }

    private void removeLeafNode(Node<N> parent, Node<N> removedNode) {
        if (removedNode == root) {
            root = null;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    private void removeNodeWithSingleChild(Node<N> parent, Node<N> removedNode) {
        Node<N> childNode = removedNode.getLeftChild() != null ?
                removedNode.getLeftChild() :
                removedNode.getRightChild();

        if (removedNode == root) {
            root = childNode;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeftChild(childNode);
        } else {
            parent.setRightChild(childNode);
        }

        fixLevels(childNode, removedNode.getLevel());
    }

    private void fixLevels(Node<N> startNode, int startLevel) {
        startNode.setLevel(startLevel);
        if (startNode.getRightChild() != null) {
            fixLevels(startNode.getRightChild(), startLevel + 1);
        }

        if (startNode.getLeftChild() != null) {
            fixLevels(startNode.getLeftChild(), startLevel + 1);
        }
    }

    private void removeCommonNode(Node<N> parent, Node<N> removedNode) {
        Node<N> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
        fixLevels(successor, removedNode.getLevel());
    }

    private boolean hasOnlySingleChildNode(Node<N> removedNode) {
        return removedNode.getLeftChild() != null ^ removedNode.getRightChild() != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown value: " + mode);
        }
    }

    private void postOrder(Node<N> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
        System.out.println(current);
    }

    private void preOrder(Node<N> current) {
        if (current == null) {
            return;
        }

        System.out.println(current);
        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
    }

    private void inOrder(Node<N> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.println(current);
        inOrder(current.getRightChild());
    }

    @Override
    public boolean isBalanced() {
        return Tree.isBalanced(root);
    }

    private class NodeAndParent {
        Node<N> current;
        Node<N> parent;

        NodeAndParent(Node<N> current, Node<N> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

}
