
package com.netcracker.teachclub.vectors.streams;

import com.netcracker.teachclub.vectors.streams.FillRunable;
import com.netcracker.teachclub.vectors.streams.ReadRunable;
import com.netcracker.teachclub.vectors.allvectors.ArrayVector;
import java.io.*;
import java.util.*;
        
public class TestTread {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int sizeSize = 3;
        com.netcracker.teachclub.vectors.Vector o1 = new ArrayVector(sizeSize);
        com.netcracker.teachclub.vectors.Vector o2 = new ArrayVector(sizeSize);
        com.netcracker.teachclub.vectors.Vector o3 = new ArrayVector(sizeSize);
        
         com.netcracker.teachclub.vectors.streams.TreadFill tf1 = new com.netcracker.teachclub.vectors.streams.TreadFill(o1);
         tf1.setPriority(Thread.MAX_PRIORITY);
         tf1.start();
         com.netcracker.teachclub.vectors.streams.TreadFill tf2 = new com.netcracker.teachclub.vectors.streams.TreadFill(o2);
         tf2.start();
         com.netcracker.teachclub.vectors.streams.TreadFill tf3 = new com.netcracker.teachclub.vectors.streams.TreadFill(o3);
         tf3.start();
        
         com.netcracker.teachclub.vectors.streams.TreadRead tr1 = new com.netcracker.teachclub.vectors.streams.TreadRead(o1);
         tr1.start();
         com.netcracker.teachclub.vectors.streams.TreadRead tr2 = new com.netcracker.teachclub.vectors.streams.TreadRead(o2);
         tr2.start();
         com.netcracker.teachclub.vectors.streams.TreadRead tr3 = new com.netcracker.teachclub.vectors.streams.TreadRead(o3);
         tr3.start();
   
         Tablo obj = new Tablo();
         Runnable run = new com.netcracker.teachclub.vectors.streams.ReadRunable(obj);
         com.netcracker.teachclub.vectors.streams.FillRunable frr = new com.netcracker.teachclub.vectors.streams.FillRunable(obj);
         Thread tab1 = new Thread(frr);
         Thread tab2 = new Thread(run);
         tab1.start();
         tab2.start();
        
        
        
        
    }
    
    
}
