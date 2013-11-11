package com.netckreker.teachclub.vectors.allvectors;

import com.netckreker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import com.netckreker.teachclub.vectors.patterns.Observer;
import com.netckreker.teachclub.vectors.Vector;
import com.netckreker.teachclub.vectors.exceptions.VectorIndexOutOfBoundsException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class LinkedListVector implements Vector {

    int size = 0;
    Elements first = null;
    private List<Observer> listeners = new ArrayList<Observer>();
   
    public LinkedListVector() {
        super();
         add(0);
      }
    
      public LinkedListVector(int size) {
        for (int i = 0; i < size; i++) {
            add(0);
        }
    }
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
    public LinkedListVector(double... n) {
        LinkedListVector elements = new LinkedListVector();
        for (int i = 0; i < n.length; i++) {
            elements.add(n[i]);
        }
     }

    public void add(double element) {
        Elements e = first;
        Elements newEl = new Elements(e, element, null);
        if (size == 0) {
            first = newEl;
            newEl.prev = newEl;
            newEl.next = newEl;
        }
        newEl.prev = first.prev;
        newEl.next = first;
        first.prev = newEl;
        newEl.prev.next = newEl;
        size++;
    }

    public void remove(int index) {
        if (0 < index || index > getSize()-1)
           throw new VectorIndexOutOfBoundsException();
        Elements el = getInd(index);
        Elements next = el.next;
        Elements prev = el.prev;
        prev.next = next;
        el.prev = null;
        next.prev = prev;
        el.next = null;
        size--;
   
    }

    public void removeAll() {
        for (int i = 0; i < getSize(); i++) {
            Elements el = getInd(i);
            Elements next = el.next;
            Elements prev = el.prev;
            prev.next = null;
            next.prev = null;
        }
        size = 0;
        first = null;
     }

    public void setElement(int index, double q) {
        if (0 > index || index > getSize()-1)
            throw new VectorIndexOutOfBoundsException();
        Elements t = getInd(index);
        t.mid = q;
     }

    public double getElement(int index) {
        if (0 > index && index > getSize()-1)
            throw new VectorIndexOutOfBoundsException();
        return getInd(index).mid;
    }
    
    private static class Elements implements Serializable {
        double mid;
        Elements next;
        Elements prev;

        Elements(Elements prev, double element, Elements next) {
            this.mid = element;
            this.next = next;
            this.prev = prev;
        }
    }

    Elements getInd(int index) {
         if (0 > index || index > size-1)
            throw new VectorIndexOutOfBoundsException();
        if (index < size) {
            Elements x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            throw new NoSuchElementException("no such element");
        }
    }

    @Override
    public void fillElements(double[] arr)  throws VectorIndexOutOfBoundsException {
        this.first = null;
        this.size  = 0;
        for (int i = 0; i <arr.length; i++) {
            add(arr[i]);
        }
    }

    @Override
    public void fillElementsObj(Vector o1)  throws IndexOutOfBoundsException {
        this.first = null;
        this.size  = 0;
        for (int i = 0; i < o1.getSize(); i++) {
            add(o1.getElement(i));
        }
      }

    public void Mult(double x) {
        double newVar;
        for (int i = 0; i < getSize(); i++)
        {
            newVar = getElement(i) * x;
            setElement(i, newVar);
            System.out.println(getElement(i));
        }
     }

    @Override
    public void Sum(Vector o1)  throws IncompatibleVectorSizesException {
        if (getSize() != o1.getSize()){
        throw new IncompatibleVectorSizesException("The vectors are of different sizes");}
        double newVar;
        Vector o2 = new LinkedListVector(getSize());
         for (int i = 0; i < getSize(); i++) {
                newVar = getElement(i) + o1.getElement(i);
                o2.setElement(i, newVar);
                System.out.println(o2.getElement(i));
            }
      }

    @Override
    public void ecualsElementsObj(Vector o1)  throws IncompatibleVectorSizesException {
        if (getSize() != o1.getSize()){
        throw new IncompatibleVectorSizesException("The vectors are of different sizes");}
            for (int i = 0; i < getSize(); i++) 
                if (!(getElement(i) == o1.getElement(i))) { 
                    System.out.println("False");
                    break;
                }
        System.out.println("True");
    }

    public int getSize() {
        return size;
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
        if (obj == null)
            return false;
        if (!(obj instanceof Vector))
            return false;
        Vector myClass = (Vector) obj;
        for (int i = 0; i < getSize(); i++) {
            if (getElement(i) == myClass.getElement(i))
                return true;
        }
        return false;
    }

    public int hashCode() {
        int result = 0;
        for (int i = 0; i < getSize(); i++) 
        {
            long bits = Double.doubleToRawLongBits(getElement(i));
            result ^= ((int) (bits & 0x00000000FFFFFFFFL)) ^ ((int) ((bits & 0xFFFFFFFF00000000L)>>32));
        }
        System.out.println(result);
        return result;
    }

    public Object clone()  throws CloneNotSupportedException{
        LinkedListVector clone = null;
        try {
            clone = (LinkedListVector) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(LinkedListVector.class.getName()).log(Level.SEVERE, null, ex);
        }
        clone.fillElementsObj(this);
        return clone;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int index;
            
            @Override
            public boolean hasNext() {
            return  (index == size) ? false:true;
            }

            @Override
            public Object next() {
              return getInd(index++);
          }

            @Override
            public void remove() {};
     };
   }
 }

