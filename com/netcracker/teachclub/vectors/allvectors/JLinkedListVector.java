
package com.netcracker.teachclub.vectors.allvectors;

import com.netcracker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import com.netcracker.teachclub.vectors.patterns.Observer;
import com.netcracker.teachclub.vectors.Vector;
import com.netcracker.teachclub.vectors.exceptions.VectorIndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JLinkedListVector implements Vector {
    int size = 0;
    private LinkedList elements = new LinkedList();
    private List<Observer> listeners = new ArrayList<Observer>();
    
    public void add(double m) {
        elements.add(m);
        notifyObjectModified();  
    }
        
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
      public JLinkedListVector(int size) {
        for (int i = 0; i < size; i++) {
            add(0);
        }
    }    
   
    JLinkedListVector(double... n) {
        JLinkedListVector elements = new JLinkedListVector();
        for (int i = 0; i < n.length; i++) {
            elements.add(n[i]);
        }
      notifyObjectModified();  
    }

    public double getElement(int index) {
         if (0 > index || index > getSize()-1)
         throw new VectorIndexOutOfBoundsException();
         return (Double) elements.get(index);
    }

    public void setElement(int index, double element) {
        if (0 > index || index > getSize()-1)
        throw new VectorIndexOutOfBoundsException();
        if (0 <= index && index <= size) {
            elements.add(index, element);
        }
       notifyObjectModified(); 
       notifyElementModified(index);
    }

    public int getSize() {
        return elements.size();
    }

    public void fillElements(double[] arr) {
         this.elements = new LinkedList();
         for (int i = 0; i < arr.length; i++) {
              setElement(i, arr[i]);
        }
       notifyObjectModified(); 
    }

    @Override
    public void fillElementsObj(Vector o1) {
        this.elements = new LinkedList();
        for (int i = 0; i < o1.getSize(); i++) {
            setElement(i, o1.getElement(i));
        }
       notifyObjectModified(); 
    }

    public void Mult(double x) {
        double newVar;
        for (int i = 0; i < getSize(); i++) {
            newVar = getElement(i) * x;
            setElement(i, newVar);
            System.out.println(getElement(i));
        }
      notifyObjectModified();  
    }


    @Override
    public void Sum(Vector o1)  {
            if (getSize() != o1.getSize()){
                try {
                    throw new IncompatibleVectorSizesException("The vectors are of different sizes");
                } catch (IncompatibleVectorSizesException ex) {
                    Logger.getLogger(JLinkedListVector.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            double newVar;
              Vector o2 =  new JLinkedListVector(getSize());
            for (int i = 0; i < getSize(); i++) {
              newVar = getElement(i) + o1.getElement(i);
              o2.setElement(i, newVar);
              System.out.println(o2.getElement(i));
            }
    }

    public void ecualsElementsObj(Vector o1){
            if (getSize() != o1.getSize()){
                try {
                    throw new IncompatibleVectorSizesException("The vectors are of different sizes");
                } catch (IncompatibleVectorSizesException ex) {
                    Logger.getLogger(JLinkedListVector.class.getName()).log(Level.SEVERE, null, ex);
                }
}
              for (int i = 0; i < getSize(); i++) {
              if (!(getElement(i) == o1.getElement(i))) {
                    System.out.println("False");
                    break;
                } else
                    System.out.println("True");
            }
    }

    @Override
    public Iterator iterator() {
        return elements.iterator();
    }

}
