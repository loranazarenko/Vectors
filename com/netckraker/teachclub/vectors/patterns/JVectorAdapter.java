package com.netckraker.teachclub.vectors.patterns;

import com.netckraker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import com.netckraker.teachclub.vectors.Vector;
import com.netckraker.teachclub.vectors.patterns.Observer;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

 public class JVectorAdapter  implements Vector {  
     
 private java.util.Vector vector = null;    
 private List<Observer> listeners = new ArrayList<Observer>();
    public void addObserver(Observer observer) {
              listeners.add(observer);
}
       
           public void notifyObjectModified(){
             for (Observer listener : listeners) { 
               listener.objectModified(this);
           }
       }
       
           public void notifyElementModified(int index){
           for (Observer listener : listeners) {
               listener.elementModified(index);
          }
      }
         
     public JVectorAdapter(java.util.Vector vec){
          this.vector =  vec;
     }

    public JVectorAdapter() {
        vector = new java.util.Vector();
    }
      
     public void add(int index, double element) {
          vector.add(index, element);
       }

    public void add(double element) {
          vector.add(element);
      }
  
    public double getElement(int index) {
       return  (double) vector.get(index);
    }

    public void setElement(int index, double element) {
          vector.set(index, element);
     }

    public int getSize() {
        return vector.size();
    }

    @Override
    public void fillElements(double[] arr)  {
        vector = new java.util.Vector(arr.length);
        for (int i = 0; i < arr.length; i++) {
             vector.add(arr[i]);
        }
    }

    @Override
    public void fillElementsObj(Vector o1) {
          vector = new java.util.Vector(o1.getSize());
          for (int i = 0; i < o1.getSize(); i++) {
          vector.add(o1.getElement(i));
        }
    }

    @Override
    public void ecualsElementsObj(Vector o1) throws IncompatibleVectorSizesException {
        int i = 0;
        if (getSize() != o1.getSize()){
             throw new IncompatibleVectorSizesException("The vectors are of different sizes");
        } else
            for (Iterator it = vector.iterator(); it.hasNext();) {
            double z = (double) it.next();
            if (!(z == o1.getElement(i))) {  
                System.out.println("False");
                break;
            } else
                i++;
            System.out.println("True");
        }
    }

    @Override
    public void Mult(double x) {
        double newVar;
        int i = 0;
        for (Iterator it = vector.iterator(); it.hasNext();) {
            double z = (double) it.next();  
            newVar = z * x;
            setElement(i, newVar);
            System.out.println(getElement(i));
            i++;
        }
  }

    @Override
    public void Sum(Vector o1) throws IncompatibleVectorSizesException {
        double newVar = 0.0;
        if (getSize() != o1.getSize()){
             throw new IncompatibleVectorSizesException("The vectors are of different sizes");
          }
         else {
            Vector o2 = new JVectorAdapter();
            for (int i=0;i<getSize();i++){
            newVar = getElement(i) + o1.getElement(i);  
            o2.setElement(i, newVar);
            System.out.println(o2.getElement(i));}
            }
   }

    public String toString() {
        {  StringBuilder contents = new StringBuilder();
            for (int i = 0; i < getSize(); i++) {
            contents.append("+ " + getElement(i) + " ");
            }
           return contents.toString();
        }
    }

    @Override
    public boolean equals(Object obj) {
         int i = 0;
        if (obj == null)
            return false;
        if (!(obj instanceof Vector))
            return false;
        Vector newvector = (Vector) obj;
        if (newvector.getSize()!= this.vector.size()){
            return false;}
        for (Iterator it = vector.iterator(); it.hasNext();) {
           double z = (double)it.next();
           return (z == newvector.getElement(i));
         }i++;
        return false;
    }

    public int hashCode() {
     return  vector.hashCode();
    }

    public Object clone()throws CloneNotSupportedException  {
      JVectorAdapter object = (JVectorAdapter)super.clone();
       object.vector = (java.util.Vector)vector.clone();
       return object;
    }
    
     @Override
    public Iterator iterator() {
        return vector.iterator();
    }
    
}
