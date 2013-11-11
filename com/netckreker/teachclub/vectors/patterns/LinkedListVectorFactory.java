
package com.netckreker.teachclub.vectors.patterns;

import com.netckreker.teachclub.vectors.Vector;
import com.netckreker.teachclub.vectors.allvectors.LinkedListVector;

public class LinkedListVectorFactory implements VectorFactory{
    
    public Vector createVector()
    { return  new LinkedListVector();}
    
    public Vector createSizeVector(int size)
    { return  new LinkedListVector(size);}

 }