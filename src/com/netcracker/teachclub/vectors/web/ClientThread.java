package com.netcracker.teachclub.vectors.web;
import com.netcracker.teachclub.vectors.*;
import java.io.*;
import java.net.*;
 
public class ClientThread extends Thread{
 
    public static void main(String[] args) throws EOFException, IOException{
         String f1;
         String f2;
         f1 = "d:/A1.txt";
         f2 = "d:/A2.txt";
         DataInputStream in   = null;
         DataOutputStream out = null;
         PrintWriter bw       = null;
         Socket clientSocket  = null;
        
        
    try
        {
            System.out.println("server connecting....");
            clientSocket = new Socket("127.0.0.1",9999);
             System.out.println("connection established....");

            in = new DataInputStream(clientSocket.getInputStream()); 
            out = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
            bw = new PrintWriter(new BufferedWriter(new FileWriter("d:/A2.txt")));
            BufferedReader br = new BufferedReader(new FileReader("d:/A1.txt"));
          
       while (true) {

                 Vector vectorFirst = Vectors.readVector(br);
                 Vector vectorSecond = Vectors.readVector(br);
                 Vectors.outputVector(vectorFirst, out);
                 out.flush();
                 Vectors.outputVector(vectorSecond, out);
                 out.flush();
     
                 Vector trio = Vectors.inputVector(in);
                 
                 System.out.println("echo: " + trio);
                 if (trio.getSize()==0){
                     break;}
                 Vectors.writeVector(trio, bw);
                 
          }
           out.close();
           in.close();
           bw.close();
           clientSocket.close();
           }
        catch(Exception e)	{
             e.printStackTrace();
             System.exit(1);}
        
       
}
 

}
