/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utilities;

import java.util.NoSuchElementException;
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
        int intresult = Ibst.size();
        int strresult = Strbst.size();

        
        assertEquals(7,intresult);
        assertEquals(7,strresult);

    }

    /**
     * Test of isEmpty method, of class BSTreeADT.
     */
    @Test
    public void testIsEmpty() {
        boolean intresult = Ibst.isEmpty();
        boolean strresult = Strbst.isEmpty();

        assertEquals(false,intresult);
        assertEquals(false,strresult);
        
        Ibst.clear();
        Strbst.clear();
        
        
        boolean intresult2 = Ibst.isEmpty();
        boolean strresult2 = Strbst.isEmpty();

        assertEquals(true,intresult2);
        assertEquals(true,strresult2);

    }

    /**
     * Test of clear method, of class BSTreeADT.
     */
    @Test
    public void testClear() {
        boolean intresult = Ibst.isEmpty();
        boolean strresult = Strbst.isEmpty();

        assertEquals(false,intresult);
        assertEquals(false,strresult);
        
        Ibst.clear();
        Strbst.clear();
        
        
        boolean intresult2 = Ibst.isEmpty();
        boolean strresult2 = Strbst.isEmpty();

        assertEquals(true,intresult2);
        assertEquals(true,strresult2);

    }

    /**
     * Test of contains method, of class BSTreeADT.
     */
    @Test
    public void testContains() {
        
        boolean intresult = Ibst.contains(3);
        boolean strresult = Strbst.contains("Tie interceptor");
        assertEquals(true,intresult);
        assertEquals(true,strresult);
        
        
        boolean intresult2 = Ibst.contains(311);
        boolean strresult2 = Strbst.contains("Tie interceptordsaddwadw");
        assertEquals(false,intresult2);
        assertEquals(false,strresult2);

        
    }

    /**
     * Test of search method, of class BSTreeADT.
     */
    @Test
    public void testSearch() {
        
        
        BSTreeNode<Integer> nodeintresult = Ibst.search(3);
        int intresult = nodeintresult.value;
        
        BSTreeNode<String> nodestrresult = Strbst.search("Tie interceptor");
        String strresult = nodestrresult.value;
        assertEquals(3,intresult);
        assertEquals("Tie interceptor",strresult);
        
        
        boolean intresult2 = Ibst.contains(311);
        boolean strresult2 = Strbst.contains("Tie interceptordsaddwadw");
        assertEquals(false,intresult2);
        assertEquals(false,strresult2);
    }

    /**
     * Test of add method, of class BSTreeADT.
     */
    @Test
    public void testAdd() {
        
        assertEquals(7,Ibst.size());
        Ibst.add(19);
        assertEquals(8,Ibst.size());
        Ibst.add(2);
        assertEquals(9,Ibst.size());
        
        
        
        BSTreeNode<Integer> checkmax = Ibst.removeMax();
        assertEquals((Integer)19,checkmax.value);
        
        BSTreeNode<Integer> checkmax2 = Ibst.removeMax();
        assertEquals((Integer)18,checkmax2.value);
        
        assertEquals(7,Ibst.size());
        
        
        BSTreeNode<Integer> checkmin = Ibst.removeMin();
        assertEquals((Integer)2,checkmin.value);
        
        BSTreeNode<Integer> checkmin2 = Ibst.removeMin();
        assertEquals((Integer)3,checkmin2.value);
        
        assertEquals(5,Ibst.size());
        
        
        
        Ibst.clear();
        
        assertEquals(true,Ibst.isEmpty());
        
        Ibst.add(3403);
        
        assertEquals((Integer)3403,Ibst.root.value);
        
        
    }

    /**
     * Test of removeMin method, of class BSTreeADT.
     */
    @Test
    public void testRemoveMin() {

        int checksize0 = Ibst.size(); 
        assertEquals(7,checksize0);
        
        
        BSTreeNode<Integer> nodeintresult = Ibst.removeMin();
        int intresult = nodeintresult.value;
        
        assertEquals (3,intresult);
        
        int checksize = Ibst.size(); 
        assertEquals(6,checksize); 
        
        BSTreeNode<Integer> nodeintresult2 = Ibst.removeMin();
        int intresult2 = nodeintresult2.value;
        
        assertEquals (5,intresult2);
        
        int checksize2 = Ibst.size(); 
        assertEquals(5,checksize2);
        
        
        
        int checkleft = Ibst.root.left.value;
        assertEquals(7,checkleft);
        
        
        
        
    }

    /**
     * Test of removeMax method, of class BSTreeADT.
     */
    @Test
    public void testRemoveMax() {
        
        BSTreeNode<Integer> nodeintresult = Ibst.removeMax();
        int intresult = nodeintresult.value;
        
        assertEquals(18,intresult);
        
        
        BSTreeNode<String> nodestrresult = Strbst.removeMax();
        String strresult = nodestrresult.value;
        
        assertEquals("X-wing",strresult);
        
        
        boolean intresult2 = Ibst.contains(18);
        boolean strresult2 = Strbst.contains("X-wing");
        assertEquals(false,intresult2);
        assertEquals(false,strresult2);
        
        
        BSTreeNode<Integer> nodeintresult3 = Ibst.removeMax();
        int intresult3 = nodeintresult3.value;
        
        assertEquals(15,intresult3);
        
        BSTreeNode<Integer> nodeintresult4 = Ibst.removeMax();
        int intresult4 = nodeintresult4.value;
        
        assertEquals(12,intresult4);
        
        BSTreeNode<Integer> nodeintresult5 = Ibst.removeMax();
        int intresult5 = nodeintresult5.value;
        
        assertEquals(10,intresult5);
        
        
        
        int checksize = Ibst.size(); 
        assertEquals(3,checksize);  
        
        
        //check the root
        assertEquals((Integer)5,Ibst.root.value);  
        assertNotEquals((Integer)7,Ibst.root.value);
        
        
    }

    /**
     * Test of inorderIterator method, of class BSTreeADT.
     */
    @Test
    public void testInorderIterator() {
        
        Iterator<Integer> iterator = Ibst.inorderIterator();
        assertTrue(iterator.hasNext());
        assertEquals((Integer)3, iterator.next());
        assertEquals((Integer)5, iterator.next());
        assertEquals((Integer)7, iterator.next());
        assertEquals((Integer)10, iterator.next());
        assertEquals((Integer)12, iterator.next());
        assertEquals((Integer)15, iterator.next());
        assertEquals((Integer)18, iterator.next());
        
        assertThrows(NoSuchElementException.class,() -> iterator.next());
        
        assertFalse(iterator.hasNext());
        
        Iterator<Integer> iterator2 = Ibst.inorderIterator();
        assertNotEquals((Integer)33, iterator2.next());
        
        
        
        
        Iterator<String> iterator3 = Strbst.inorderIterator();
        assertTrue(iterator3.hasNext());
        assertEquals("A-wing", iterator3.next());
        assertEquals("B-wing", iterator3.next());
        assertEquals("Millenium Falcon", iterator3.next());
        assertEquals("Tie fighter", iterator3.next());
        assertEquals("Tie interceptor", iterator3.next());
        assertEquals("VCX-100 light freighter", iterator3.next());
        assertEquals("X-wing", iterator3.next());
        
        assertThrows(NoSuchElementException.class,() -> iterator3.next());
        
        assertFalse(iterator3.hasNext());
        
        Iterator<String> iterator4 = Strbst.inorderIterator();
        assertNotEquals((String)"33", iterator4.next());

        
      
        
    }

    /**
     * Test of preorderIterator method, of class BSTreeADT.
     */
    @Test
    public void testPreorderIterator() {
        Iterator<Integer> iterator = Ibst.preorderIterator();
        assertTrue(iterator.hasNext());
        assertEquals((Integer)10, iterator.next());
        assertEquals((Integer)5, iterator.next());
        assertEquals((Integer)3, iterator.next());
        assertEquals((Integer)7, iterator.next());
        assertEquals((Integer)15, iterator.next());
        assertEquals((Integer)12, iterator.next());
        assertEquals((Integer)18, iterator.next());
        
        assertThrows(NoSuchElementException.class,() -> iterator.next());
        
        assertFalse(iterator.hasNext());
        
        Iterator<Integer> iterator2 = Ibst.preorderIterator();
        assertNotEquals((Integer)33, iterator2.next());
        
        
        //"Tie interceptor"
       // A-wing
            //  "Millenium Falcon"  
               // "Tie fighter"
               // "Tie interceptor"
              //  "VCX-100 light freighter"
              //  "X-wing"
               
                
        Iterator<String> iterator3 = Strbst.preorderIterator();
        assertTrue(iterator3.hasNext());
        assertEquals("Tie interceptor", iterator3.next());
        assertEquals("B-wing", iterator3.next());
        assertEquals("A-wing", iterator3.next());
        assertEquals("Tie fighter", iterator3.next());
        assertEquals("Millenium Falcon", iterator3.next());
        assertEquals("VCX-100 light freighter", iterator3.next());
        assertEquals("X-wing", iterator3.next());
        
        assertThrows(NoSuchElementException.class,() -> iterator3.next());
        
        assertFalse(iterator3.hasNext());
        
        Iterator<String> iterator4 = Strbst.preorderIterator();
        assertNotEquals((String)"33", iterator4.next());
    }

    /**
     * Test of postorderIterator method, of class BSTreeADT.
     */
    @Test
    public void testPostorderIterator() {
        
        Iterator<Integer> iterator = Ibst.postorderIterator();
        assertTrue(iterator.hasNext());
        assertEquals((Integer)3, iterator.next());
        assertEquals((Integer)7, iterator.next());
        assertEquals((Integer)5, iterator.next());
        assertEquals((Integer)12, iterator.next());
        assertEquals((Integer)18, iterator.next());
        assertEquals((Integer)15, iterator.next());
        assertEquals((Integer)10, iterator.next());
       
        
        /*
        assertThrows(NoSuchElementException.class,() -> iterator.next());
        
        assertFalse(iterator.hasNext());
        
        Iterator<Integer> iterator2 = Ibst.postorderIterator();
        assertNotEquals((Integer)33, iterator2.next());
        
        
        //"Tie interceptor"
       // A-wing
            //  "Millenium Falcon"  
               // "Tie fighter"
               // "Tie interceptor"
              //  "VCX-100 light freighter"
              //  "X-wing"
               
                
        Iterator<String> iterator3 = Strbst.postorderIterator();
        assertTrue(iterator3.hasNext());
        assertEquals("A-wing", iterator3.next());
        assertEquals("B-wing", iterator3.next());
        assertEquals("A-wing", iterator3.next());
        assertEquals("Tie fighter", iterator3.next());
        assertEquals("Millenium Falcon", iterator3.next());
        assertEquals("VCX-100 light freighter", iterator3.next());
        assertEquals("X-wing", iterator3.next());
        
        assertThrows(NoSuchElementException.class,() -> iterator3.next());
        
        assertFalse(iterator3.hasNext());
        
        Iterator<String> iterator4 = Strbst.postorderIterator();
        assertNotEquals((String)"33", iterator4.next());
        */
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
