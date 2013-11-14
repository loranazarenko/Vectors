package com.netcracker.teachclub.vectors.web;


import com.netcracker.teachclub.vectors.streams.FillRunable;
import com.netcracker.teachclub.vectors.streams.Tablo;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client1   extends Thread{
    
 public static void main(String[] arg) throws EOFException{ 
     String f1;
     String f2;
     f1 = "D:/A1.txt";
     f2 = "D:/A2.txt";
    try {
       System.out.println("server connecting....");
       Socket clientSocket = new Socket("127.0.0.1",9999);
       System.out.println("connection established....");

       BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
       PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));
       Scanner text  = new Scanner(new FileReader(f1)); 
       FileWriter fw = new FileWriter(f2);
       String result = "";
       
          
       int countLine = 0;
       String print  = "";
        while (text.hasNext()) {
          countLine++;  
          print += text.nextLine();
          if(countLine%2==0){
                 out.println(print);
                 out.flush();
                 print  = ""; 
    
                 String inputString; 
                 inputString = in.readLine();
                 result += inputString +"\n";
                 System.out.println("echo: " + result);
            }
           }
            
        fw.write(result);
         
        out.close();
        in.close();
        text.close();
        fw.close();
        clientSocket.close();
        }
        catch(Exception e)	{
             e.printStackTrace();}
        
    
}

}
