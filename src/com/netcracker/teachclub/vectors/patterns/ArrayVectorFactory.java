
package com.netcracker.teachclub.vectors.patterns;

import com.netcracker.teachclub.vectors.Vector;
import com.netcracker.teachclub.vectors.allvectors.ArrayVector;


public class ArrayVectorFactory implements VectorFactory{
    
    public Vector createVector()
    { return  new com.netcracker.teachclub.vectors.allvectors.ArrayVector();}
    
    public Vector createSizeVector(int size)
    { return  new ArrayVector(size);}

 }
