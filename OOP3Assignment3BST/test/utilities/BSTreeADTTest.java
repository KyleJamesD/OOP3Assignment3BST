/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utilities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import treeImplementation.BSTree;
import treeImplementation.BSTreeNode;

/**
 *
 * @author kyled
 */
public class BSTreeADTTest {
    
    /**********Global Trees************/
    
    BSTree<Integer> Ibst;
    
    BSTree<Cars> Cbst;
    
    BSTree<StarFighters> Sbst;
    
    BSTree<String> Strbst;
    
    public BSTreeADTTest() {
    }
    
    @Before
    public void setUp() {
        /********************** Integer Tree*********************/
        Ibst = new BSTree<>();
        
        Ibst.add(10);
        Ibst.add(5);
        Ibst.add(15);
        Ibst.add(3);
        Ibst.add(7);
        Ibst.add(12);
        Ibst.add(18);
        
        
        /********************** String Tree*********************/
        Strbst = new BSTree<>();
        
        Strbst.add("Tie interceptor");
        Strbst.add("B-wing");
        Strbst.add("A-wing");
        Strbst.add("Tie fighter");
        Strbst.add("VCX-100 light freighter");
        Strbst.add("Millenium Falcon");
        Strbst.add("X-wing");
        
        
        
        
        
        
        /********************** StarFighter Tree*********************/
        /********************** Not working yet, worth a try*********************/
        StarFighters starfighter1 = new StarFighters("B-wing", 350 );
        StarFighters starfighter2 = new StarFighters("Tie fighter", 150 );
        StarFighters starfighter3 = new StarFighters("VCX-100 light freighter", 50 );
        StarFighters starfighter4 = new StarFighters("A-wing", 250 );
        StarFighters starfighter5 = new StarFighters("x-wing", 450 );
        StarFighters starfighter6 = new StarFighters("Tie interceptor", 400 );
        StarFighters starfighter7 = new StarFighters("Millenium Falcon", 550 );
        
        Sbst = new BSTree<>();
        
        Sbst.add(starfighter1);
        Sbst.add(starfighter2);
        Sbst.add(starfighter3);
        Sbst.add(starfighter4);
        Sbst.add(starfighter5);
        Sbst.add(starfighter6);
        Sbst.add(starfighter7);
        

        /********************** Cars Tree*********************/
        /********************** Not working yet, worth a try*********************/
        Cars car1 = new Cars("ford" , 1987);
        Cars car2 = new Cars("Acura" , 2004);
        Cars car3 = new Cars("Chevy" , 1968);
        Cars car4 = new Cars("toyota" , 1982);
        Cars car5 = new Cars("bugatti" , 2020);
        Cars car6 = new Cars("nissan" , 2002);
        Cars car7 = new Cars("honda" , 1996);
        
        Cbst = new BSTree<>();
        
        Cbst.add(car1);
        Cbst.add(car2);
        Cbst.add(car3);
        Cbst.add(car4);
        Cbst.add(car5);
        Cbst.add(car6);
        Cbst.add(car7);
        
        
        
    }

    /**
     * Test of getRoot method, of class BSTreeADT.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");
        BSTreeNode intresult = Ibst.getRoot();
        BSTreeNode strresult = Strbst.getRoot();

        
        assertEquals(10,intresult.value);
        assertEquals("Tie interceptor",strresult.value);
        
        
        
        

    }

    /**
     * Test of getHeight method, of class BSTreeADT.
     */
    @Test
    public void testGetHeight() {
        int intresult = Ibst.getHeight();
        int strresult = Strbst.getHeight();

        
        assertEquals(3,intresult);
        assertEquals(4,strresult);
        
        
        
    }

    /**
     * Test of size method, of class BSTreeADT.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        fail();

    }

    /**
     * Test of isEmpty method, of class BSTreeADT.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        fail();

    }

    /**
     * Test of clear method, of class BSTreeADT.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        fail();

    }

    /**
     * Test of contains method, of class BSTreeADT.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        fail();
    }

    /**
     * Test of search method, of class BSTreeADT.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        fail();
    }

    /**
     * Test of add method, of class BSTreeADT.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        fail();
    }

    /**
     * Test of removeMin method, of class BSTreeADT.
     */
    @Test
    public void testRemoveMin() {
        System.out.println("removeMin");
        fail();
    }

    /**
     * Test of removeMax method, of class BSTreeADT.
     */
    @Test
    public void testRemoveMax() {
        System.out.println("removeMax");
        fail();
    }

    /**
     * Test of inorderIterator method, of class BSTreeADT.
     */
    @Test
    public void testInorderIterator() {
        System.out.println("inorderIterator");
        fail();
    }

    /**
     * Test of preorderIterator method, of class BSTreeADT.
     */
    @Test
    public void testPreorderIterator() {
        System.out.println("preorderIterator");
        fail();
    }

    /**
     * Test of postorderIterator method, of class BSTreeADT.
     */
    @Test
    public void testPostorderIterator() {
        System.out.println("postorderIterator");
        fail();
    }
    
    
    
    
    /*********************Classes for Testing!!!*************************************/
    
    
    public class StarFighters implements Comparable<StarFighters> {
                    public String name;
                    public int laserpower;

            public StarFighters(String name, int laserpower) {
                this.name = name;
                this.laserpower = laserpower;
            }

            @Override
            public int compareTo(StarFighters other) {
                return Integer.compare(this.laserpower, other.laserpower);
            }
            
        }
    
    
    
    
    
        public class Cars implements Comparable<Cars> {
                    public String name;
                    public int yearbuilt;

            public Cars(String name, int yearbuilt) {
                this.name = name;
                this.yearbuilt = yearbuilt;
            }

            @Override
            public int compareTo(Cars other) {
                return this.name.compareTo(other.name);
            }
            
        }

    
}
