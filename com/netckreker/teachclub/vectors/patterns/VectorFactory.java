package com.netckreker.teachclub.vectors.patterns;

import com.netckreker.teachclub.vectors.Vector;
import com.netckreker.teachclub.vectors.allvectors.LinkedListVector;
import com.netckreker.teachclub.vectors.allvectors.ArrayVector;

public interface VectorFactory {

    public Vector createVector();
    public Vector createSizeVector(int size);

}

