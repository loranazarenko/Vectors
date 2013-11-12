
package com.netckraker.teachclub.vectors.patterns;

import com.netckraker.teachclub.vectors.Vector;
import com.netckraker.teachclub.vectors.allvectors.LinkedListVector;

public class LinkedListVectorFactory implements VectorFactory{
    
    public Vector createVector()
    { return  new LinkedListVector();}
    
    public Vector createSizeVector(int size)
    { return  new LinkedListVector(size);}

 }