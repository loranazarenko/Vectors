package com.netcracker.teachclub.vectors.patterns;

public class Observers implements Observer {
        
    @Override
    public void elementModified(int index) {
       
    }

    @Override
    public void objectModified(Object obj) {
       System.out.println(789);
    }
}