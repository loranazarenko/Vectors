package com.netcracker.teachclub.vectors.reflection;

import java.lang.reflect.*;
import java.io.*;

public class GetSum { 
 
    public static void main(String[] args) throws Exception { 
     if (args.length == 3) {   
      try {
         Class c = Class.forName(args[0]);
         Method method = c.getMethod(args[1],new Class [] {Double.TYPE});
         Double val = Double.valueOf(args[2]); 
          
//       Class c = Class.forName("com.netcracker.teachclub.vectors.reflection.ReflectionMy"); 
//       Method method = c.getMethod("Sum", new Class [] {Double.TYPE}); 
//       Double val = Double.valueOf(7.2);
       Object res = method.invoke(null, new Object [] {val});
        System.out.println(res.toString());
     } catch (ClassNotFoundException e) {
         System.out.println("Класс не найден");
     } catch (NoSuchMethodException e) {
         System.out.println("Метод не найден");
     } catch (IllegalAccessException e) {
         System.out.println("Метод недоступен");
     } catch (InvocationTargetException e) {
          System.out.println("При вызове возникло исключение");
      }
    } 
  } 

}
