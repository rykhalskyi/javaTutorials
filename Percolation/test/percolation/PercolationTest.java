/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percolation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rykhalskyi
 */
public class PercolationTest {
    
    public PercolationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of open method, of class Percolation.
     */
    @Test
    public void testOpen() {
        System.out.println("open");
        int i = 0;
        int j = 0;
        Percolation instance = null;
        instance.open(i, j);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOpen method, of class Percolation.
     */
    @Test
    public void testIsOpen() {
        System.out.println("isOpen");
        int i = 0;
        int j = 0;
        Percolation instance = null;
        boolean expResult = false;
        boolean result = instance.IsOpen(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFull method, of class Percolation.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        int i = 0;
        int j = 0;
        Percolation instance = null;
        boolean expResult = false;
        boolean result = instance.isFull(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of percolates method, of class Percolation.
     */
    @Test
    public void testPercolates() {
        System.out.println("percolates");
        Percolation instance = null;
        boolean expResult = false;
        boolean result = instance.percolates();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
