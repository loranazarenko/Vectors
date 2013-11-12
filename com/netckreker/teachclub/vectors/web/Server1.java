
package com.netckreker.teachclub.vectors.web;

import com.netckreker.teachclub.vectors.allvectors.ArrayVector;
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class Server1 
    {public static void main(String[] arg) {
        ServerSocket serverSocket = null;
        Socket clientAccepted     = null;
        BufferedReader in         = null;
        PrintWriter out           = null;
        try {
         System.out.println("server starting....");
         serverSocket = new ServerSocket(9999); 
         
         clientAccepted = serverSocket.accept();
         System.out.println("connection established....");
          
         in  = new BufferedReader(new InputStreamReader(clientAccepted.getInputStream())); 
         out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientAccepted.getOutputStream())),true);
          while (true) {
         String inputStringN; 
         inputStringN = in.readLine();
          
         int size = inputStringN.length();
          
         com.netckreker.teachclub.vectors.Vector o1 = new ArrayVector(size/2);
         com.netckreker.teachclub.vectors.Vector o2 = new ArrayVector(size/2);
         com.netckreker.teachclub.vectors.Vector o3 = new ArrayVector(size/2);
          
          
         for(int i=0;i<size/2; i++){
         o1.setElement(i, Double.parseDouble(String.valueOf(inputStringN.charAt(i))));}
         int j = size/2; 
         for(int i=0;i<size/2; i++){
           
         o2.setElement(i, Double.parseDouble(String.valueOf(inputStringN.charAt(j)))); j++;}
         o3 = com.netckreker.teachclub.vectors.Vectors.Sum(o1, o2);
        
          String  inputString = new String();
          for (int t = 0; t < o3.getSize();t++) {
          inputString += "" + Double.toString(o3.getElement(t));
          } 
          out.println(inputString+"\n"); 
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

