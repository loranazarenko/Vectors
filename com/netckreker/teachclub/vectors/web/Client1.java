package com.netckreker.teachclub.vectors.web;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client1 {
public static void main(String[] arg) throws EOFException{ 
     String f1;
     String f2;
//    BufferedReader in = null;
    f1 = "D:/A1.txt";
    f2 = "D:/A2.txt";
    
    try {
       System.out.println("server connecting....");
       Socket clientSocket = new Socket("127.0.0.1",9999);
       System.out.println("connection established....");

       DataInputStream  in = new DataInputStream (clientSocket.getInputStream());  
       DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
       FileReader fin = new FileReader(f1);
       Scanner text = new Scanner(fin); 
        
       String result = "";
                 
       int countLine = 0;
       String print  = "";
        while (text.hasNext()) {
          countLine++;  
          print += text.nextLine();
          if(countLine%2==0){
                 out.writeUTF(print);
                 out.flush();
                 print  = ""; 
    
                 String inputString; 
                 inputString = in.readUTF();
                 result += inputString +"\n";
                 System.out.println("echo: " + result);
            }
        }
        
        FileWriter fw = new FileWriter(f2);
        fw.write(result);
         
        in.close();
        fw.close();
        out.close();
//        coos.close();
//        cois.close();
        clientSocket.close();
        }
        catch(Exception e)	{
             e.printStackTrace();}
        
    
}

}
