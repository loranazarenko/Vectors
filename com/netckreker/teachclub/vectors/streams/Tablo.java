
package com.netckreker.teachclub.vectors.streams;

import com.netckreker.teachclub.vectors.Vector;
import com.netckreker.teachclub.vectors.allvectors.ArrayVector;
import java.awt.Cursor;

public class Tablo {
    
    public Vector vector = new com.netckreker.teachclub.vectors.allvectors.ArrayVector(3);
    private boolean newed = false;
    private int cursor = 0;
    
    synchronized public void putElement(double element)throws InterruptedException {
        while(newed)
            wait();
            vector.setElement(cursor, element);
            newed = true;
            notifyAll();
            }
    
    synchronized public double getElement()throws InterruptedException{
            while(!newed)
            wait();
            newed = false;
            notifyAll();
            return vector.getElement(cursor++);
           
            }

}
