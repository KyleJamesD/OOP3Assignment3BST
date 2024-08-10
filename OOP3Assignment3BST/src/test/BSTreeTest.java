package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import treeImplementation.BSTree;
import treeImplementation.BSTreeNode;
import utilities.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BSTreeTest {
    private BSTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BSTree<>();
    }

    @org.junit.jupiter.api.Test
    void getRoot() {
        tree.add(10);
        assertEquals(10, tree.getRoot().data);
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
        assertEquals(-1, tree.getHeight());
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        assertEquals(2, tree.getHeight());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0, tree.size());
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        assertEquals(5, tree.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(tree.isEmpty());
        tree.add(3);
        assertFalse(tree.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        tree.add(3);
        assertFalse(tree.isEmpty());
        tree.clear();
        assertTrue(tree.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        tree.add(3);
        assertTrue(tree.contains(3));
    }

    @org.junit.jupiter.api.Test
    void search() {
        tree.add(3);
        assertEquals(3, tree.search(3).data);
    }

    @org.junit.jupiter.api.Test
    void add() {
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        // Check the structure and height
        System.out.println("Tree height: " + tree.getHeight());
        tree.printTree();
    }

    @org.junit.jupiter.api.Test
    void removeMin() {
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        assertEquals(1, tree.removeMin().data);
    }

    @org.junit.jupiter.api.Test
    void removeMax() {
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        assertEquals(5, tree.removeMax().data);
    }

    @org.junit.jupiter.api.Test
    void inorderIterator() {
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        Iterator<Integer> iterator = tree.inorderIterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(5, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void preorderIterator() {
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        Iterator<Integer> iterator = tree.preorderIterator();
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(5, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void postorderIterator() {
        tree.add(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        Iterator<Integer> iterator = tree.postorderIterator();
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(5, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }
}