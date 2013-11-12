
package com.netckraker.teachclub.vectors.streams;

import com.netckraker.teachclub.vectors.Vector;
import static com.netckraker.teachclub.vectors.Vectors.createInstance;


public class TreadRead  extends Thread {
    int size = 3;    
    Vector vec;
    public TreadRead(Vector v1){
       this.vec = v1;}
    
    public void run(){
     readNew(vec);  
     }
 
    
    public void readNew(Vector vec){
     for (int i =0;i <size; i++) {
     System.out.println("Read: + " + vec.getElement(i) + "to position " + i);   
    }
    
   } 
    
}
