/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.teachclub.vectors.allvectors;

import com.netcracker.teachclub.vectors.Vector;
import com.netcracker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import com.netcracker.teachclub.vectors.patterns.Observer;
import java.util.Iterator;
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
public class ArrayVectorTest {
        ArrayVector o1;
        ArrayVector o2;
        ArrayVector o3;
    public ArrayVectorTest() {
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

    
   
     @Test
    public void testSum() throws  IncompatibleVectorSizesException {
        System.out.println("Sum");
        Vector o1 = new ArrayVector(1);
        o1.setElement(0,2.2);
        Vector o2 = new ArrayVector(1);
        o2.setElement(0, 3.3);
        Vector instance = new ArrayVector(1);
        o1.setElement(0,1.1);
        instance.Sum(o1);
        assertEquals(o2, instance);
    }

   
    
    @Test
    public void testGetElement() {
        System.out.println("getElement");
        int index = 0;
        ArrayVector instance = new ArrayVector(1);
        double expResult = 2.1;
        double result = instance.getElement(index);
        assertEquals(expResult, result, 2.1);
       
    }

    
    @Test
    public void testSetElement() {
        System.out.println("setElement");
        int index = 0;
        double element = 2.1;
        ArrayVector instance = new ArrayVector(1);
        instance.setElement(index, element);
        double result = instance.getElement(index);
       assertEquals(element, result, 2.1);
    }

   
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ArrayVector instance = new ArrayVector(1);
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(1, result);
      
    }

//    /**
//     * Test of fillElements method, of class ArrayVector.
//     */
//    @Test
//    public void testFillElements() {
//        System.out.println("fillElements");
//        double[] arr = null;
//        ArrayVector instance = new ArrayVector(1);
//        instance.fillElements(arr);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of fillElementsObj method, of class ArrayVector.
//     */
//    @Test
//    public void testFillElementsObj() {
//        System.out.println("fillElementsObj");
//        Vector o1 = null;
//        ArrayVector instance = new ArrayVector(1);
//        instance.fillElementsObj(o1);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of ecualsElementsObj method, of class ArrayVector.
//     */
//    @Test
//    public void testEcualsElementsObj() throws Exception {
//        System.out.println("ecualsElementsObj");
//        Vector o1 = null;
//        ArrayVector instance = new ArrayVector(1);
//        instance.ecualsElementsObj(o1);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Mult method, of class ArrayVector.
//     */
//    @Test
//    public void testMult() {
//        System.out.println("Mult");
//        double x = 0.0;
//        ArrayVector instance = new ArrayVector(1);
//        instance.Mult(x);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Sum method, of class ArrayVector.
//     */
//    @Test
//    public void testSum() throws Exception {
//        System.out.println("Sum");
//        Vector o1 = null;
//        ArrayVector instance = new ArrayVector(1);
//        instance.Sum(o1);
//     
//    }
//
//    /**
//     * Test of toString method, of class ArrayVector.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        ArrayVector instance = new ArrayVector();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//  
//    }
//
//    
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        ArrayVector instance = new ArrayVector();
//        boolean expResult = false;
//        boolean result = instance.equals(obj);
//        assertEquals(expResult, result);
//     
//    }
//
//    
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        ArrayVector instance = new ArrayVector();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//     
//    }
//
//    
//    @Test
//    public void testClone() throws Exception {
//        System.out.println("clone");
//        ArrayVector instance = new ArrayVector();
//        Object expResult = null;
//        Object result = instance.clone();
//        assertEquals(expResult, result);
//        
//    }
//
//   
//    @Test
//    public void testIterator() {
//        System.out.println("iterator");
//        ArrayVector instance = new ArrayVector();
//        Iterator expResult = null;
//        Iterator result = instance.iterator();
//        assertEquals(expResult, result);
//      
//    }
}