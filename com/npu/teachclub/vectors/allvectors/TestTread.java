
package com.npu.teachclub.vectors.allvectors;

import com.npu.teachclub.vectors.FillRunable;
import com.npu.teachclub.vectors.ReadRunable;
import com.npu.teachclub.vectors.Tablo;
import java.io.*;
import java.util.*;
        
public class TestTread {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int sizeSize = 3;
        com.npu.teachclub.vectors.Vector o1 = new ArrayVector(sizeSize);
        com.npu.teachclub.vectors.Vector o2 = new ArrayVector(sizeSize);
        com.npu.teachclub.vectors.Vector o3 = new ArrayVector(sizeSize);
        
        
         com.npu.teachclub.vectors.TreadFill tf1 = new com.npu.teachclub.vectors.TreadFill(o1);
         tf1.setPriority(Thread.MAX_PRIORITY);
         tf1.start();
         com.npu.teachclub.vectors.TreadFill tf2 = new com.npu.teachclub.vectors.TreadFill(o2);
         tf2.start();
         com.npu.teachclub.vectors.TreadFill tf3 = new com.npu.teachclub.vectors.TreadFill(o3);
         tf3.start();
        
         com.npu.teachclub.vectors.TreadRead tr1 = new com.npu.teachclub.vectors.TreadRead(o1);
         tr1.start();
         com.npu.teachclub.vectors.TreadRead tr2 = new com.npu.teachclub.vectors.TreadRead(o2);
         tr2.start();
         com.npu.teachclub.vectors.TreadRead tr3 = new com.npu.teachclub.vectors.TreadRead(o3);
         tr3.start();
   
         Tablo obj = new Tablo();
         Runnable run = new com.npu.teachclub.vectors.ReadRunable(obj);
         com.npu.teachclub.vectors.FillRunable frr = new com.npu.teachclub.vectors.FillRunable(obj);
         Thread tab1 = new Thread(frr);
         Thread tab2 = new Thread(run);
         tab1.start();
         tab2.start();
        
        
        
        
    }
    
    
}
