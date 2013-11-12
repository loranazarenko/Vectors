package com.netckraker.teachclub.vectors;

import com.netckraker.teachclub.vectors.streams.Tablo;
import com.netckraker.teachclub.vectors.streams.ReadRunable;
import com.netckraker.teachclub.vectors.streams.FillRunable;
import com.netckraker.teachclub.vectors.patterns.Observers;
import com.netckraker.teachclub.vectors.allvectors.LinkedListVector;
import com.netckraker.teachclub.vectors.allvectors.ArrayVector;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MVector {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int sizeSize = 3;
        double[] arr = {16, 18, 99, 94, 22,45};
        
        double c = 3.1;
        double d = 7.1;
        double t = 5.1;

        Vector o1 = new ArrayVector(sizeSize);
        Vector o2 = new ArrayVector(sizeSize);
        Vector o3 = new ArrayVector(sizeSize);

        Vector l1 = new LinkedListVector();
        Vector l2 = new LinkedListVector();
        Vector l3 = new LinkedListVector();
        
//        o1.fillElements(arr);
//        o1.getElement(54);
        
        Observers ob1 = new Observers();
          
//        o1.addObserver(ob1);
        
//        l1.fillElements(arr);
//        System.out.println(l1);
        
        
//         TreadFill tf1 = new TreadFill(o1);
//         tf1.setPriority(Thread.MAX_PRIORITY);
//         tf1.start();
//         TreadFill tf2 = new TreadFill(o2);
//         tf2.start();
//         TreadFill tf3 = new TreadFill(o3);
//         tf3.start();
//         
//        
//         TreadRead tr1 = new TreadRead(o1);
//         tr1.start();
//         TreadRead tr2 = new TreadRead(o2);
//         tr2.start();
//         TreadRead tr3 = new TreadRead(o3);
//         tr3.start();
         
//           FillRunable fr = new FillRunable(o1);    
//           Runnable r = new ReadRunable(o1);
//           Thread thrd = new Thread(fr);
//           Thread thr = new Thread(r);
//           thrd.start();
//           thr.start();
         
           Tablo obj = new Tablo();
           Runnable r = new ReadRunable(obj);
           FillRunable fr = new FillRunable(obj);
           Thread thrd = new Thread(fr);
           Thread thr = new Thread(r);
           thrd.start();
           thr.start();
         
//        JVectorAdapter j1 = new JVectorAdapter();
//        JVectorAdapter j2 = new JVectorAdapter();
//        JVectorAdapter j3 = new JVectorAdapter();
//        
//        j1.add(c);
//        j1.add(d);
//        j1.add(t);
//        j2.fillElements(arr);
//        System.out.println(j1.hashCode());
//        
//        try {
//            System.out.println(j1.clone());
//             } catch (CloneNotSupportedException ex) {
//            Logger.getLogger(MVector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       j3.fillElementsObj(j1); 
//        boolean equals = j3.equals(j1);
//        System.out.println(equals);
        
    
        
        
//                o2.fillElementsObj(o1);
                
                
        //        Vectors.Sort(o1);
        //        o1.Mult(sizeSize);
        //        o1.Sum(o2);
        //        o1.ecualsElementsObj(o2);
        //
        //        l1.add(c);
        //        l1.add(d);
        //        l1.add(t);
        //        l2.fillElements(arr);
        //        l3.fillElementsObj(l1);
        //        Vectors.Sort(l1);
        //            l1.Sum(l1, l2, l3);
        //            l1.Mult(sizeSize);
        //            l1.ecualsElementsObj(l1);
        //         l1.hashCode();
        //         l3.hashCode();
        //        l1.remove(2);
        //         l2.fillElements(arr);
        //
        //         BufferedOutputStream bos =  new BufferedOutputStream(new FileOutputStream("E:/A8.txt"));
        //         Vectors.outputVector(o1, bos);
        //         Vectors.outputVector(o1, bos);
        //         FileInputStream fr = new FileInputStream("E:/A8.txt");  ///InputStreamReader(System.in));
        //         Vectors.inputVector(fr);
        //         Vectors.inputVector(fr);
        //
        //         for ( int i = 0; i<o1.getSize(); i++ ) {
        //         System.out.println("vvvv "+i+"="+o1.getElement(i));}
        //
        //        PrintWriter bw = new PrintWriter(new BufferedWriter(new FileWriter("E:/A9.txt")));
        //        Vectors.writeVector(o1, bw);
        //        Vectors.writeVector(o1, bw);
        ////
        //        BufferedReader br =  new BufferedReader(new FileReader("E:/A9.txt"));
        //        System.out.println(Vectors.readVector(br));
        //        System.out.println(Vectors.readVector(br));
        //         ObjectOutputStream out = null;
        //         try {
        //         out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("E:/A.txt")));
        //         out.writeObject(l1);
        //        } catch ( IOException ex ) {
        //           ex.printStackTrace();
        //        }
        ////
        //         out.flush();
        //
        //         ObjectInputStream in = null;
        //         try {
        //         in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("E:/A.txt")));
        //
        //          o1 = (LinkedListVector)in.readObject();
        //           } catch ( IOException ex ) {
        //           ex.printStackTrace();}
        //
        //
        //        for ( int r = 0; r<l1.getSize(); r++ ) {
        //            System.out.println("uuuu "+r+"="+l1.getElement(r)); }
        //        for ( int r = 0; r<3; r++ ) {
        //        System.out.println(o1.getElement(r)); }
        //        o1 = Vectors.getProtectedVector(o1);
        //        o1.setElement(1, 99);
        //        for ( int r = 0; r<2; r++ ) {
        //          System.out.println(o1.getElement(r)); }
       
        
     
       
       
       }
   
   }

