package com.netcracker.teachclub.vectors.patterns;

import com.netcracker.teachclub.vectors.Vector;
import com.netcracker.teachclub.vectors.allvectors.LinkedListVector;
import com.netcracker.teachclub.vectors.allvectors.ArrayVector;

public interface VectorFactory {

    public Vector createVector();
    public Vector createSizeVector(int size);

}

