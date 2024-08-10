/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import treeImplementation.BSTreeNode;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 *
 * @author Will
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
    private BSTreeNode<E> root;
    private int size;

    public BSTree() {
        root = null;
        size = 0;
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
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
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
    public boolean contains(E entry) {
        if (entry == null) throw new NullPointerException();
        return contains(root, entry);
    }

    private boolean contains(BSTreeNode<E> node, E entry) {
        if (node == null) return false;
        int cmp = entry.compareTo(node.getElement());
        if (cmp < 0) return contains(node.getLeft(), entry);
        else if (cmp > 0) return contains(node.getRight(), entry);
        else return true;
    }

    @Override
    public BSTreeNode<E> search(E entry) {
        if (entry == null) throw new NullPointerException();
        return search(root, entry);
    }

    private BSTreeNode<E> search(BSTreeNode<E> node, E entry) {
        if (node == null) return null;
        int cmp = entry.compareTo(node.getElement());
        if (cmp < 0) return search(node.getLeft(), entry);
        else if (cmp > 0) return search(node.getRight(), entry);
        else return node;
    }

    @Override
    public boolean add(E newEntry) {
        if (newEntry == null) throw new NullPointerException();
        if (root == null) {
            root = new BSTreeNode<>(newEntry);
            size++;
            return true;
        }
        return add(root, newEntry);
    }

    private boolean add(BSTreeNode<E> node, E newEntry) {
        int cmp = newEntry.compareTo(node.getElement());
        if (cmp < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BSTreeNode<>(newEntry));
                size++;
                return true;
            } else {
                return add(node.getLeft(), newEntry);
            }
        } else if (cmp > 0) {
            if (node.getRight() == null) {
                node.setRight(new BSTreeNode<>(newEntry));
                size++;
                return true;
            } else {
                return add(node.getRight(), newEntry);
            }
        } else {
            return false; // Duplicate entry
        }
    }

    @Override
    public BSTreeNode<E> removeMin() {
        if (root == null) return null;
        return removeMin(root, null);
    }

    private BSTreeNode<E> removeMin(BSTreeNode<E> node, BSTreeNode<E> parent) {
        if (node.getLeft() == null) {
            if (parent != null) {
                parent.setLeft(node.getRight());
            } else {
                root = node.getRight();
            }
            size--;
            return node;
        }
        return removeMin(node.getLeft(), node);
    }

    @Override
    public BSTreeNode<E> removeMax() {
        if (root == null) return null;
        return removeMax(root, null);
    }

    private BSTreeNode<E> removeMax(BSTreeNode<E> node, BSTreeNode<E> parent) {
        if (node.getRight() == null) {
            if (parent != null) {
                parent.setRight(node.getLeft());
            } else {
                root = node.getLeft();
            }
            size--;
            return node;
        }
        return removeMax(node.getRight(), node);
    }

    @Override
    public Iterator<E> inorderIterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> stack = new Stack<>();

        public InOrderIterator() {
            pushLeft(root);
        }

        private void pushLeft(BSTreeNode<E> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            BSTreeNode<E> node = stack.pop();
            E result = node.getElement();
            pushLeft(node.getRight());
            return result;
        }
    }

    @Override
    public Iterator<E> preorderIterator() {
        return new PreOrderIterator();
    }

    private class PreOrderIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> stack = new Stack<>();

        public PreOrderIterator() {
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            BSTreeNode<E> node = stack.pop();
            E result = node.getElement();
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            return result;
        }
    }

    @Override
    public Iterator<E> postorderIterator() {
        return new PostOrderIterator();
    }

    private class PostOrderIterator implements Iterator<E> {
        private Stack<BSTreeNode<E>> stack = new Stack<>();
        private BSTreeNode<E> lastVisited = null;

        public PostOrderIterator() {
            pushLeft(root);
        }

        private void pushLeft(BSTreeNode<E> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            while (true) {
                BSTreeNode<E> node = stack.peek();
                if (node.getRight() != null && lastVisited != node.getRight()) {
                    pushLeft(node.getRight());
                } else {
                    lastVisited = stack.pop();
                    return lastVisited.getElement();
                }
            }
        }
    }
}