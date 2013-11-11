package com.netckreker.teachclub.vectors.allvectors;

import com.netckreker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import com.netckreker.teachclub.vectors.patterns.Observer;
import com.netckreker.teachclub.vectors.Vector;
import com.netckreker.teachclub.vectors.exceptions.VectorIndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JArrayListVector implements Vector {

        private ArrayList elements = new ArrayList();
        public List<Observer> listeners = new ArrayList<Observer>();
        
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
        
            
    JArrayListVector() {
        super();
        elements = new ArrayList(0); 
    }

    JArrayListVector(int size) {
        elements = new ArrayList(size); 
    }
    
    public void add(double m) {
        elements.add(m);
    }

    JArrayListVector(int size, double... n) {
        Vector elements = new JArrayListVector(size);
        for (int i = 0; i < n.length; i++) {
            elements.add(n[i]);
        }
    }

    public double getElement(int index) {
        if (0 > index || index > getSize()-1)
           throw new VectorIndexOutOfBoundsException();
        return (Double) elements.get(index);
    }

    public void setElement(int index, double element) {
        if (0 > index || index > getSize()-1)
           throw new VectorIndexOutOfBoundsException();
        if (0 <= index && index <= getSize()) {
            elements.add(index, element);
        }
    }

    public int getSize() {
        return elements.size();
    }

    public void fillElements(double[] arr)  {
        this.elements = new ArrayList(arr.length);
        for (int i = 0; i < getSize(); i++) {
            setElement(i, arr[i]);
        }
      }

    public void fillElementsObj(Vector o1) {
        this.elements = new ArrayList(o1.getSize());
        for (int i = 0; i < o1.getSize(); i++) {
            setElement(i, (Double) o1.getElement(i));
        }
    }

    @Override
    public void ecualsElementsObj(Vector o1)throws IncompatibleVectorSizesException {
         if (getSize() != o1.getSize()){
            throw new IncompatibleVectorSizesException("The vectors are of different sizes");
         } else
            for (int i = 0; i < getSize(); i++) {
                if (!(getElement(i) == o1.getElement(i))) {
                    System.out.println("False");
                    break;
                } else
                    System.out.println("True");
         }
    }

    @Override
    public void Mult(double x) {
        double newVar;
        int i = 0;
        for (Object it : elements)
        {
            newVar = (Double) it * x;
            setElement(i, newVar);
            System.out.println(getElement(i));
            i++;
        }
     }

    @Override
    public void Sum(Vector o1) throws IncompatibleVectorSizesException {
         double newVar;
         Vector o2 = new JArrayListVector(getSize());
         if (getSize() != o1.getSize()){
            throw new IncompatibleVectorSizesException("The vectors are of different sizes");}
         else
              for (int i = 0; i < getSize(); i++) {
              newVar = getElement(i) + o1.getElement(i);
              o2.setElement(i, newVar);
              System.out.println(o2.getElement(i));
            }
    }

    @Override
    public Iterator iterator() {
        return elements.iterator();
    }

}
