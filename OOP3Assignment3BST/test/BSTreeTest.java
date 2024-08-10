
import org.junit.Before;
import org.junit.Test;
import utilities.BSTree;
import utilities.Iterator;
import static org.junit.Assert.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Will
 */
public class BSTreeTest {
    private BSTree<Integer> tree;

    @Before
    public void setUp() {
        tree = new BSTree<>();
    }

    @Test
    public void testAddAndContains() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(15));
        assertFalse(tree.contains(20));
    }

    @Test
    public void testGetHeight() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        assertEquals(2, tree.getHeight());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
        tree.add(10);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, tree.size());
        tree.add(10);
        tree.add(5);
        assertEquals(2, tree.size());
    }

    @Test
    public void testClear() {
        tree.add(10);
        tree.add(5);
        tree.clear();
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testRemoveMin() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        assertEquals(5, (int) tree.removeMin().getElement());
        assertFalse(tree.contains(5));
    }

    @Test
    public void testRemoveMax() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        assertEquals(15, (int) tree.removeMax().getElement());
        assertFalse(tree.contains(15));
    }

    @Test
    public void testInOrderTraversal() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);

        Iterator<Integer> iterator = tree.inorderIterator();
        assertEquals((int) iterator.next(), 2);
        assertEquals((int) iterator.next(), 5);
        assertEquals((int) iterator.next(), 7);
        assertEquals((int) iterator.next(), 10);
        assertEquals((int) iterator.next(), 15);
    }

    @Test
    public void testPreOrderTraversal() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);

        Iterator<Integer> iterator = tree.preorderIterator();
        assertEquals((int) iterator.next(), 10);
        assertEquals((int) iterator.next(), 5);
        assertEquals((int) iterator.next(), 2);
        assertEquals((int) iterator.next(), 7);
        assertEquals((int) iterator.next(), 15);
    }

    @Test
    public void testPostOrderTraversal() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);

        Iterator<Integer> iterator = tree.postorderIterator();
        assertEquals((int) iterator.next(), 2);
        assertEquals((int) iterator.next(), 7);
        assertEquals((int) iterator.next(), 5);
        assertEquals((int) iterator.next(), 15);
        assertEquals((int) iterator.next(), 10);
    }
}