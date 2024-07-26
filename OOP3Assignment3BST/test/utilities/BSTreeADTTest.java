/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utilities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import treeImplementation.BSTreeNode;

/**
 *
 * @author kyled
 */
public class BSTreeADTTest {
    
    public BSTreeADTTest() {
    }
    
    @Before
    public void setUp() {
        
        
        
        
        
    }

    /**
     * Test of getRoot method, of class BSTreeADT.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");

    }

    /**
     * Test of getHeight method, of class BSTreeADT.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");

    }

    /**
     * Test of size method, of class BSTreeADT.
     */
    @Test
    public void testSize() {
        System.out.println("size");

    }

    /**
     * Test of isEmpty method, of class BSTreeADT.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");

    }

    /**
     * Test of clear method, of class BSTreeADT.
     */
    @Test
    public void testClear() {
        System.out.println("clear");

    }

    /**
     * Test of contains method, of class BSTreeADT.
     */
    @Test
    public void testContains() {
        System.out.println("contains");

    }

    /**
     * Test of search method, of class BSTreeADT.
     */
    @Test
    public void testSearch() {
        System.out.println("search");

    }

    /**
     * Test of add method, of class BSTreeADT.
     */
    @Test
    public void testAdd() {
        System.out.println("add");

    }

    /**
     * Test of removeMin method, of class BSTreeADT.
     */
    @Test
    public void testRemoveMin() {
        System.out.println("removeMin");

    }

    /**
     * Test of removeMax method, of class BSTreeADT.
     */
    @Test
    public void testRemoveMax() {
        System.out.println("removeMax");

    }

    /**
     * Test of inorderIterator method, of class BSTreeADT.
     */
    @Test
    public void testInorderIterator() {
        System.out.println("inorderIterator");

    }

    /**
     * Test of preorderIterator method, of class BSTreeADT.
     */
    @Test
    public void testPreorderIterator() {
        System.out.println("preorderIterator");

    }

    /**
     * Test of postorderIterator method, of class BSTreeADT.
     */
    @Test
    public void testPostorderIterator() {
        System.out.println("postorderIterator");

    }
    
    
    
    
    /*********************Classes for Testing!!!*************************************/
    
    
    public class StarFighters implements Comparable<StarFighters> {
                    String name;
                    int yearbuilt;

            public StarFighters(String name, int age) {
                this.name = name;
                this.yearbuilt = age;
            }

            @Override
            public int compareTo(StarFighters other) {
                return Integer.compare(this.yearbuilt, other.yearbuilt);
            }
            
        }
    
    
        public class Cars implements Comparable<Cars> {
                    String name;
                    int yearbuilt;

            public Cars(String name, int age) {
                this.name = name;
                this.yearbuilt = age;
            }

            @Override
            public int compareTo(Cars other) {
                return this.name.compareTo(other.name);
            }
            
        }

    
}
