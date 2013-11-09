package com.npu.teachclub.vectors;

import com.npu.teachclub.vectors.allvectors.LinkedListVector;
import com.npu.teachclub.vectors.allvectors.ArrayVector;

public interface VectorFactory {

    public Vector createVector();
    public Vector createSizeVector(int size);

}

class ArrayVectorFactory implements VectorFactory{
    
    public Vector createVector()
    { return  new com.npu.teachclub.vectors.allvectors.ArrayVector();}
    
    public Vector createSizeVector(int size)
    { return  new ArrayVector(size);}

 }

class LinkedListVectorFactory implements VectorFactory{
    
    public Vector createVector()
    { return  new LinkedListVector();}
    
    public Vector createSizeVector(int size)
    { return  new LinkedListVector(size);}

 }