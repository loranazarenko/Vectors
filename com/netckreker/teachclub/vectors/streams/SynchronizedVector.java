
package com.netckreker.teachclub.vectors.streams;


import com.netckreker.teachclub.vectors.Vector;
import com.netckreker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import com.netckreker.teachclub.vectors.patterns.Observer;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchronizedVector  implements Vector {
    
    public Vector vector;
    double[] elements ; 
    private List<Observer> listeners = new ArrayList<Observer>();

    public SynchronizedVector(Vector vec){
        this.vector =  vec;
    }

    public synchronized void addObserver(Observer observer) {
          listeners.add(observer);
}

       public synchronized void notifyObjectModified(){
         for (Observer listener : listeners) { 
           listener.objectModified(this);
       }
   }

       public synchronized void notifyElementModified(int index){
       for (Observer listener : listeners) {
           listener.elementModified(index);
      }
  }

      public synchronized void add(double element) {
      vector.add(element);
     }

    public synchronized double getElement(int index) {
       return  (double) vector.getElement(index);
    }

    public synchronized void setElement(int index, double element) {
          vector.setElement(index, element);
     }

    public synchronized int getSize() {
        return vector.getSize();
    }

    @Override
    public synchronized void fillElements(double[] arr)  {
        vector = new SynchronizedVector(vector);
        for (int i = 0; i < arr.length; i++) {
             vector.add(arr[i]);
        }
    }

    @Override
    public synchronized void fillElementsObj(Vector o1) {
          vector = new SynchronizedVector(o1);
          for (int i = 0; i < o1.getSize(); i++) {
          vector.add(o1.getElement(i));
        }
    }

    @Override
    public synchronized void ecualsElementsObj(Vector o1)   throws IncompatibleVectorSizesException{
        vector.ecualsElementsObj(o1);
    }

    @Override
    public synchronized void Mult(double x) {
        vector.Mult(x);
  }

    @Override
    public synchronized void Sum(Vector o1) throws IncompatibleVectorSizesException{
       vector.Sum(o1);
   }

    public synchronized String toString() {
        return vector.toString();
    }

    @Override
    public boolean equals(Object obj) {
         int i = 0;
        if (obj == null)
            return false;
        if (!(obj instanceof Vector))
            return false;
        Vector newvector = (Vector) obj;
        if (newvector.getSize()!= this.vector.getSize()){
            return false;}
        for (Iterator it = vector.iterator(); it.hasNext();) {
           double z = (double)it.next();
           return (z == newvector.getElement(i));
         }i++;
        return false;
    }

    public synchronized int hashCode() {
     return  vector.hashCode();
    }

    public synchronized Object clone()throws CloneNotSupportedException  {
          return super.clone();
    }
    
     @Override
    public synchronized Iterator iterator() {
        return vector.iterator();
    }
    
    
}
