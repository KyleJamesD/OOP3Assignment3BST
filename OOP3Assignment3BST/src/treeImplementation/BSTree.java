package treeImplementation;

import utilities.BSTreeADT;
import utilities.Iterator;

import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {

    BSTreeNode<E> root;
    int size;

    public BSTree() {
        this.root = null;
        this.size = 0;
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(BSTreeNode<E> node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(node.getData());
            printTree(node.getLeft(), indent, false);
            printTree(node.getRight(), indent, true);
        }
    }

    @Override
    public BSTreeNode<E> getRoot() {
        return root;
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BSTreeNode<E> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(E entry) throws NullPointerException {
        if (entry == null) {
            throw new NullPointerException();
        }
        return contains(root, entry);
    }

    private boolean contains(BSTreeNode<E> node, E entry) {
        if (node == null) {
            return false;
        }
        int val = entry.compareTo(node.getData());
        if (val < 0) {
            return contains(node.getLeft(), entry);
        }
        else if (val > 0) {
            return contains(node.getRight(), entry);
        }
        else {
            return true;
        }
    }

    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException {
        if (entry == null) {
            throw new NullPointerException();
        }
        return search(root, entry);
    }

    private BSTreeNode<E> search(BSTreeNode<E> node, E entry){
        if (node == null) {
            return null;
        }
        int val = entry.compareTo(node.getData());
        if (val < 0) {
            return search(node.getLeft(), entry);
        }
        else if (val > 0) {
            return search(node.getRight(), entry);
        }
        else {
            return node;
        }
    }

    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if (newEntry == null) {
            throw new NullPointerException();
        }
        if (root == null) {
            root = new BSTreeNode<>(newEntry);
            size++;
            return true;
        }
        else {
            return add(root, newEntry);
        }
    }

    private boolean add(BSTreeNode<E> node, E newEntry) {
        if (node == null) {
            return false;
        }
        int val = newEntry.compareTo(node.getData());
        if (val < 0) {
            if(node.getLeft() == null) {
                node.setLeft(new BSTreeNode<>(newEntry));
                size++;
                return true;
            }
            else {
                return add(node.getLeft(), newEntry);
            }
        }
        else if (val > 0) {
            if(node.getRight() == null) {
                node.setRight(new BSTreeNode<>(newEntry));
                size++;
                return true;
            }
            else {
                return add(node.getRight(), newEntry);
            }
        }
        else {
            return false;   //Duplicate element, not added
        }
    }

    @Override
    public BSTreeNode<E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        BSTreeNode<E> min = findMin(root);
        root = removeMin(root);
        size--;
        return min;
    }

    private BSTreeNode<E> findMin(BSTreeNode<E> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private BSTreeNode<E> removeMin(BSTreeNode<E> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node = node.getLeft();
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    @Override
    public BSTreeNode<E> removeMax() {
        if (isEmpty()) {
            return null;
        }
        BSTreeNode<E> max = findMax(root);
        root = removeMax(root);
        size--;
        return max;
    }

    private BSTreeNode<E> findMax(BSTreeNode<E> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    private BSTreeNode<E> removeMax(BSTreeNode<E> node) {
        if (node.getRight() == null) {
            return node.getLeft();
        }
        node = node.getRight();
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public Iterator<E> inorderIterator() {
        return new InorderIterator();
    }

    @Override
    public Iterator<E> preorderIterator() {
        return new PreorderIterator();
    }

    @Override
    public Iterator<E> postorderIterator() {
        return new PostorderIterator();
    }

    private class InorderIterator implements Iterator<E> {
        private BSTreeNode<E> current = root;
        private Stack<BSTreeNode<E>> stack = new Stack<>();

        public InorderIterator() {
            while (current != null){
                stack.push(current);
                current = current.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BSTreeNode<E> node = stack.pop();
            current = node.getRight();
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            return node.getData();
        }
    }

    private class PreorderIterator implements Iterator<E> {
        private BSTreeNode<E> current = root;
        private Stack<BSTreeNode<E>> stack = new Stack<>();

        public PreorderIterator() {
            if (current != null) {
                stack.push(current);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BSTreeNode<E> node = stack.pop();
            if (node.getRight() != null){
                stack.push(node.getRight());
            }
            if (node.getLeft() != null){
                stack.push(node.getLeft());
            }
            return node.getData();
        }
    }

    private class PostorderIterator implements Iterator<E> {
        private BSTreeNode<E> current = root;
        private BSTreeNode<E> previous = null;
        private Stack<BSTreeNode<E>> stack = new Stack<>();

        public PostorderIterator() {
            if (current != null){
                stack.push(current);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            while (hasNext()){
                BSTreeNode<E> node = stack.peek();
                if ((node.getLeft() == null && node.getRight() == null) ||
                (previous != null && (previous == node.getLeft() || previous == node.getRight()))){
                    stack.pop();
                    previous = node;
                    return node.data;
                }
                else {
                    if (node.getRight() != null){
                        stack.push(node.getRight());
                    }
                    if (node.getLeft() != null){
                        stack.push(node.getLeft());
                    }
                }
            }
            throw new NoSuchElementException("Unexpected state in PostorderIterator");
        }
    }
}
