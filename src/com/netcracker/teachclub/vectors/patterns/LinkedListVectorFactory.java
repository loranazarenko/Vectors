
package com.netcracker.teachclub.vectors.patterns;

import com.netcracker.teachclub.vectors.Vector;
import com.netcracker.teachclub.vectors.allvectors.LinkedListVector;

public class LinkedListVectorFactory implements VectorFactory{
    
    public Vector createVector()
    { return  new LinkedListVector();}
    
    public Vector createSizeVector(int size)
    { return  new LinkedListVector(size);}

 }