
package com.netcracker.teachclub.vectors.streams;

import com.netcracker.teachclub.vectors.Vector;
import static com.netcracker.teachclub.vectors.Vectors.createInstance;
import java.util.Random;

public class TreadFill extends Thread {
    int size = 3;    
    Vector vec =  createInstance(size); 
    long numbOfRand = 0;
    double randValue = 0;
    public TreadFill(Vector v1){
       this.vec = v1;}
    
 public void run() {
  
      Random rnd = new Random();
        for (int i = size - 1; i > 0; i--) {
         randValue = rnd.nextDouble();
         vec.setElement(i, randValue);
         System.out.println("Write: + " + randValue + "to position " + i);
      }
   }
     
     
   
 }
 
       
 
 


