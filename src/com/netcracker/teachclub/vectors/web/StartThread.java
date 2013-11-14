package com.netcracker.teachclub.vectors.web;
import com.netcracker.teachclub.vectors.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class StartThread extends Thread{
  
    public static void main(String[] args)  throws EOFException, IOException{
//        ServerSocket serverSocket = null;
//        Socket clientAccepted     = null;
        try
        {
           System.out.println("server starting....");
           ServerSocket serverSocket = new ServerSocket(9999); 

            while(true)
            {
                
                ServerThread serverT = new ServerThread(serverSocket.accept());
                System.out.println("Got a client.");
                System.out.println();
                serverT.start();
            }
//           serverSocket.close(); 
//       clientAccepted.close();
         }
        catch(Exception e)
        {System.out.println("init error: "+e);}  
       
    }
   
   
}
     

  