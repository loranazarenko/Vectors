
package com.netckraker.teachclub.vectors.patterns;

import com.netckraker.teachclub.vectors.Vector;
import com.netckraker.teachclub.vectors.allvectors.ArrayVector;


public class ArrayVectorFactory implements VectorFactory{
    
    public Vector createVector()
    { return  new com.netckraker.teachclub.vectors.allvectors.ArrayVector();}
    
    public Vector createSizeVector(int size)
    { return  new ArrayVector(size);}

 }
