package com.netcracker.teachclub.vectors;
import com.netcracker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import com.netcracker.teachclub.vectors.patterns.Observer;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface Vector extends Iterable, Serializable,Cloneable {
      
    public void addObserver(Observer observer);
    public void notifyObjectModified();
    public void notifyElementModified(int index);
           
    public void add(double element);
    
    public void fillElements(double[] x);

    public void fillElementsObj(Vector o1);

    public void ecualsElementsObj(Vector o1) throws IncompatibleVectorSizesException ;

    public void Mult(double x);

    public void Sum(Vector o2) throws IncompatibleVectorSizesException ;

    public int getSize();

    public void setElement(int index, double element);

    public double getElement(int index);
    
    

}

