package com.netckraker.teachclub.vectors.patterns;

import com.netckraker.teachclub.vectors.Vector;
import com.netckraker.teachclub.vectors.allvectors.LinkedListVector;
import com.netckraker.teachclub.vectors.allvectors.ArrayVector;

public interface VectorFactory {

    public Vector createVector();
    public Vector createSizeVector(int size);

}

