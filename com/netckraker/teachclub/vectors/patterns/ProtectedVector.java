package com.netckraker.teachclub.vectors.patterns;

import com.netckraker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import com.netckraker.teachclub.vectors.patterns.Observer;
import com.netckraker.teachclub.vectors.Vector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProtectedVector implements com.netckraker.teachclub.vectors.Vector{
    private Vector vector;
    double[] elements ;
    private List<Observer> listeners = new ArrayList<Observer>();    
 
    public void addObserver(Observer observer) {
              listeners.add(observer);
}
      public void notifyObjectModified() {
            for (Observer listener : listeners) {
        }
    }

    public void notifyElementModified(int index){
        for (Observer listener : listeners) {
        }
    }
   
    public ProtectedVector(Vector vec) {
        this.vector = vec;
    }
  
    @Override
    public void fillElements(double[] x) {
      }

    @Override
    public void fillElementsObj(com.netckraker.teachclub.vectors.Vector o1) {
    }

    @Override
    public void ecualsElementsObj(com.netckraker.teachclub.vectors.Vector o1)  throws IncompatibleVectorSizesException {
        vector.ecualsElementsObj(o1);
    }

    @Override
    public void Mult(double x) {
     }

    @Override
    public void Sum(com.netckraker.teachclub.vectors.Vector o1) throws IncompatibleVectorSizesException{
     }

    @Override
    public int getSize() {
      return  vector.getSize();
    }

    @Override
    public void setElement(int index, double element) {

    }

    @Override
    public double getElement(int index) {
        return vector.getElement(index);
    }
    
     @Override
    public void add(double element) {
        vector.add(element);
    }

    @Override
    public Iterator iterator() {
     return vector.iterator();
   }
 }
