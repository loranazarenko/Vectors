
package com.netckreker.teachclub.vectors.patterns;

import com.netckreker.teachclub.vectors.Vector;
import com.netckreker.teachclub.vectors.allvectors.ArrayVector;


public class ArrayVectorFactory implements VectorFactory{
    
    public Vector createVector()
    { return  new com.netckreker.teachclub.vectors.allvectors.ArrayVector();}
    
    public Vector createSizeVector(int size)
    { return  new ArrayVector(size);}

 }
