
package com.netcracker.teachclub.vectors.web;

import com.netcracker.teachclub.vectors.Vector;
import com.netcracker.teachclub.vectors.Vectors;
import com.netcracker.teachclub.vectors.allvectors.ArrayVector;
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class Server1 
    {public static void main(String[] arg) {
        ServerSocket serverSocket = null;
        Socket clientAccepted     = null;
        DataInputStream in    = null;
        DataOutputStream out  = null;
        
        try {
         System.out.println("server starting....");
         serverSocket = new ServerSocket(9999); 
         
         clientAccepted = serverSocket.accept();
         System.out.println("connection established....");
          
         in  = new DataInputStream(clientAccepted.getInputStream()); 
         out = new DataOutputStream(new BufferedOutputStream(clientAccepted.getOutputStream()));
       
          while (true) {
           Vector vectorFirst = Vectors.inputVector(in);
           Vector vectorSecond = Vectors.inputVector(in);
                   
                Vector trio = Vectors.Sum(vectorFirst, vectorSecond);
                Vectors.outputVector(trio, out);
                out.flush();
               
            } 
              }catch(Exception e)	{
                } finally {
                try {
        in.close();
        out.close();
        clientAccepted.close();
        serverSocket.close();
        } catch(Exception e) {
                e.printStackTrace();
        }
      }
   }	
}

