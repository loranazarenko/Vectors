package com.netckraker.teachclub.vectors.allvectors;

import com.netckraker.teachclub.vectors.exceptions.VectorIndexOutOfBoundsException;
import com.netckraker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import java.util.*;
import java.io.*;

public class ArrayVector  implements com.netckraker.teachclub.vectors.Vector {
    
        private double[] elements = null;
        private List<com.netckraker.teachclub.vectors.patterns.Observer> listeners = new ArrayList<com.netckraker.teachclub.vectors.patterns.Observer>();
        
        public void addObserver(com.netckraker.teachclub.vectors.patterns.Observer observer) {
              listeners.add(observer);
}
        
           public void notifyObjectModified(){
             for (com.netckraker.teachclub.vectors.patterns.Observer listener : listeners) { 
               listener.objectModified(this);
           }
       }
       
           public void notifyElementModified(int index){
           for (com.netckraker.teachclub.vectors.patterns.Observer listener : listeners) {
               listener.elementModified(index);
          }
      }
         public ArrayVector() {
              super();
              elements = new double[0];
      }          
           
    public ArrayVector(int size) {
        elements = new double[size];
        notifyObjectModified();
    }

    public ArrayVector(int size, double... n) {
        elements = new double[size];
        for (int i = 0; i < n.length; i++) {
            elements[i] = n[i];
        }
        notifyObjectModified();
    }
 
    
     public void remove(int index) {   
        int size = getSize();  
         if (0 > index ||  index > size-1)
            throw new VectorIndexOutOfBoundsException("");
             int numMoved = size - index - 1;
             if (numMoved > 0)
         System.arraycopy(elements, index+1, elements, index,numMoved);
         notifyObjectModified();
         notifyElementModified(index);
     }

    public void add(int index, double element) {
           if (0 > index || index > getSize()-1)
           throw new VectorIndexOutOfBoundsException();
           System.arraycopy(elements, index, elements, index + 1, 1);
           elements[index] = element;
           notifyObjectModified();
           notifyElementModified(index);
      }

    public void add(double element) {
           int size = getSize();
            this.add(size++, element);
            notifyObjectModified();
      }
    
    public double getElement(int index) {
        if (0 > index || index > getSize()-1) 
            throw new VectorIndexOutOfBoundsException("The vectors are of different sizes");
        return elements[index];
    }

    public void setElement(int index, double element) {
        if (0 <= index || index < this.getSize()) {  
            elements[index] = element;
        }
        notifyObjectModified();
        notifyElementModified(index);
    }

    public int getSize() {
        return elements.length;
    }

    @Override
    public void fillElements(double[] arr) {
        this.elements = new double[arr.length];
        for (int i = 0; i < getSize(); i++) {
            setElement(i, arr[i]);
        }
        notifyObjectModified(); 
    }

    @Override
    public void fillElementsObj(com.netckraker.teachclub.vectors.Vector o1) {
        this.elements = new double[o1.getSize()];
        for (int i = 0; i < getSize(); i++) {
            setElement(i, o1.getElement(i));
        }
        notifyObjectModified(); 
    }

    @Override
    public void ecualsElementsObj(com.netckraker.teachclub.vectors.Vector o1) throws IncompatibleVectorSizesException {
          int i = 0;
          if (this.elements.length != o1.getSize()){
            throw new IncompatibleVectorSizesException("The vectors are of different sizes");
        } else
            for (double it : elements)
            {
                if (!(it == o1.getElement(i))) {   
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
        for (double it : elements) {
            newVar = it * x;  
            setElement(i, newVar);
            System.out.println(getElement(i));
            i++;
        }
       notifyObjectModified();  
    }


    @Override
    public void Sum(com.netckraker.teachclub.vectors.Vector o1) throws IncompatibleVectorSizesException{
        double newVar = 0.0;
        if (this.elements.length != o1.getSize()){
            throw new IncompatibleVectorSizesException("The vectors are of different sizes");}
       else {
            com.netckraker.teachclub.vectors.Vector o2 = new ArrayVector(getSize());
            for (int i=0;i<getSize();i++){
                newVar = getElement(i) + o1.getElement(i);  
                o2.setElement(i, newVar);
            }
        }
   }

    public String toString() {
            StringBuilder contents = new StringBuilder();
            if(this!=null){
             for (int i = 0; i < getSize(); i++) {
                contents.append("+ " + getElement(i) + " ");
            }}
            return contents.toString();
    }

    @Override
    public boolean equals(Object obj) {
        int i = 0;
        if (this == null)
            return false;
        if (!(obj instanceof com.netckraker.teachclub.vectors.Vector))
            return false;
        for (double it : elements) {
            if (it == getElement(i))
                i++;
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = 0;
        int i = 0;
        for (double it : elements)
        {
            long bits = Double.doubleToRawLongBits(it);   
            result ^= ((int) (bits & 0x00000000FFFFFFFFL)) ^ ((int) ((bits & 0xFFFFFFFF00000000L)>>32));
            i++;
        }
        return result;
    }

    public Object clone() throws CloneNotSupportedException{
        com.netckraker.teachclub.vectors.Vector clone = null;
        clone = (com.netckraker.teachclub.vectors.Vector) super.clone();
        clone.fillElementsObj(this);
        return clone;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
             int cursor = -1;
             int size = getSize();
             
            @Override
            public boolean hasNext() {
                 return cursor != size;
            }

            @Override
            public Object next() {
                if (cursor < size) {
                cursor++;
                return (double) elements[cursor];
                } else return null;
            }

            @Override
            public void remove() {}
        };
    }
}