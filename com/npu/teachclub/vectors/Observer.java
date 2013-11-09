package com.npu.teachclub.vectors;




import java.util.ArrayList;
import java.util.Iterator;

    public interface Observer {
        public void elementModified(int index);
        public void objectModified(Object obj);
    }

    class Observers implements Observer {
        
    @Override
    public void elementModified(int index) {
       
    }

    @Override
    public void objectModified(Object obj) {
       System.out.println(789);
    }
}
