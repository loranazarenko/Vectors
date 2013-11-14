/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.teachclub.vectors.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
public class GetSumTest {
    
    public GetSumTest() {
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
     * Test of main method, of class GetSum.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
//        GetSum.main(args);
//       if (args.length == 3) {   
      try {
//         Class c = Class.forName(args[0]);
//         Method method = c.getMethod(args[1],new Class [] {Double.TYPE});
//         Double val = Double.valueOf(args[2]); 
          
       Class c = Class.forName("com.netcracker.teachclub.vectors.reflection.ReflectionMy"); 
       Method method = c.getMethod("Sum", new Class [] {Double.TYPE}); 
       Double val = Double.valueOf(7.2);
       Object res = method.invoke(null, new Object [] {val});
        System.out.println(res.toString());
     } catch (ClassNotFoundException e) {
         System.out.println("Класс не найден");
     } catch (NoSuchMethodException e) {
         System.out.println("Метод не найден");
     } catch (IllegalAccessException e) {
         System.out.println("Метод недоступен");
     } catch (
         InvocationTargetException e) {
          System.out.println("При вызове возникло исключение");
      }
//        fail("The test case is a prototype.");
    }
}