
package com.netckreker.teachclub.vectors.web;

import com.netckreker.teachclub.vectors.streams.*;
import com.netckreker.teachclub.vectors.Vector;
import com.netckreker.teachclub.vectors.allvectors.ArrayVector;
import java.awt.Cursor;
import java.io.EOFException;
import java.io.FileReader;
import java.util.Scanner;

public class TabloWeb  {
    
    public Vector vector = new com.netckreker.teachclub.vectors.allvectors.ArrayVector();
    private boolean newed = false;
    private int cursor = 0;
       
    public TabloWeb(int size) {
        vector = new com.netckreker.teachclub.vectors.allvectors.ArrayVector(size);
    }
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
