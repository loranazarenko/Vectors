package com.netcracker.teachclub.vectors.web;


import com.netcracker.teachclub.vectors.Vector;
import com.netcracker.teachclub.vectors.Vectors;
import com.netcracker.teachclub.vectors.allvectors.ArrayVector;
import com.netcracker.teachclub.vectors.streams.FillRunable;
import com.netcracker.teachclub.vectors.streams.Tablo;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client1   extends Thread{
    
 public static void main(String[] arg) throws EOFException, IOException{ 
     String f1;
     String f2;
     f1 = "E:/A1.txt";
     f2 = "E:/A2.txt";
     DataInputStream in   = null;
     DataOutputStream out = null;
     PrintWriter bw       = null;
     Socket clientSocket  = null;
     
    try {
   
       System.out.println("server connecting....");
       clientSocket = new Socket("127.0.0.1",9999);
       System.out.println("connection established....");

       in = new DataInputStream(clientSocket.getInputStream()); 
       out = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
       bw = new PrintWriter(new BufferedWriter(new FileWriter("E:/A2.txt")));
       BufferedReader br = new BufferedReader(new FileReader("E:/A1.txt"));
        
        while (true) {

                 Vector vectorFirst = Vectors.readVector(br);
                 Vector vectorSecond = Vectors.readVector(br);
                 Vectors.outputVector(vectorFirst, out);
                 Vectors.outputVector(vectorSecond, out);
                 out.flush();
     
                 Vector trio = Vectors.inputVector(in);
                 Vectors.writeVector(trio, bw);
                 System.out.println("echo: " + trio);
                 if (trio.getSize()==0){
                     break;}
                 
          }
           }
        catch(Exception e)	{
             e.printStackTrace();}
        
        out.close();
        in.close();
        bw.close();
        clientSocket.close();
}
 

}
