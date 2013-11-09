
package com.npu.teachclub.vectors.allvectors;

import com.npu.teachclub.vectors.Vector;
import static com.npu.teachclub.vectors.Vectors.createInstance;
import java.io.*;
import java.net.*;

public class Client {
 
 public static void main(String[] args) throws IOException {
     String f1;
     String f2;
 
     f1 = "E:/"+ args[0]+".txt";
     f2 = "E:/"+ args[1]+".txt";
    
 
    Socket fromserver = null;
    fromserver = new Socket("localhost",4444);
    
//    if (args.length==0) {
//      System.out.println("use: client hostname");
//      System.exit(-1);
//    }
//
//    System.out.println("Connecting to... "+args[0]);

//    fromserver = new Socket(args[0],4444);
    
    
    BufferedReader in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
    PrintWriter    out = new PrintWriter(fromserver.getOutputStream(),true);
    BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

    
//    InputStream ints;
    DataInputStream inB = new DataInputStream(new FileInputStream(f1));
     
      try {
         for(int i= 0; i<sizeB; i++){
           double f = inB.readDouble(); 
           v.setElement(i,f);
           System.out.println(f + " ");
           }

         } 
        catch(IOException e) {
        System.out.println("Some error occurred!");
      }
     
    
    
    
    
    String fuser,fserver;

    while ((fuser = inu.readLine())!=null) {
      out.println(fuser);
      fserver = in.readLine();
      System.out.println(fserver);
      if (fuser.equalsIgnoreCase("close")) break;
      if (fuser.equalsIgnoreCase("exit")) break;
    }

    out.close();
    in.close();
    inu.close();
    fromserver.close();
  }
}
    


