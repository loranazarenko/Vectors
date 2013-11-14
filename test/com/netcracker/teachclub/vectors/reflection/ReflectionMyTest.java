/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.teachclub.vectors.reflection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lora
 */
public class ReflectionMyTest {
    
    public ReflectionMyTest() {
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
     * Test of Sum method, of class ReflectionMy.
     */
    @Test
    public void testSum() {
        System.out.println("Sum");
        double i = 4.0;
        double expResult = 8.0;
        double result = ReflectionMy.Sum(i);
        assertEquals(expResult, result, 8.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}