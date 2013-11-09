/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npu.teachclub.vectors.allvectors;


import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class Server1 
    {public static void main(String[] arg) {
        ServerSocket serverSocket = null;
        Socket clientAccepted     = null;
//        ObjectInputStream  sois   = null;
//        ObjectOutputStream soos   = null;
        DataOutputStream out           = null;
        BufferedReader in = null;
        try {
        System.out.println("server starting....");
        serverSocket = new ServerSocket(9999); 
        
        clientAccepted = serverSocket.accept();
        System.out.println("connection established....");
       
//        sois = new ObjectInputStream(clientAccepted.getInputStream()); 
//        soos   = new ObjectOutputStream(clientAccepted.getOutputStream());
//        String clientMessageRecieved = (String)sois.readObject();
         out = new DataOutputStream(clientAccepted.getOutputStream());
         in = new BufferedReader(new InputStreamReader(clientAccepted.getInputStream()));  
        
//        StringTokenizer st = new StringTokenizer(clientMessageRecieved);
//        while (st.hasMoreTokens()) {
//        System.out.println(st.nextToken().trim() + " -> " + st.nextToken().trim());
//        }
//        Double.parseDouble(String.valueOf(st.nextToken().charAt(1)));
//        int size = clientMessageRecieved.length();
        
//        com.npu.teachclub.vectors.Vector o1 = new ArrayVector(size/2);
//        com.npu.teachclub.vectors.Vector o2 = new ArrayVector(size/2);
//        com.npu.teachclub.vectors.Vector o3 = new ArrayVector(size/2);
//        in.toString();
        String inputStringN; 
        
//        StreamTokenizer nums = new StreamTokenizer(in);
          inputStringN = in.readLine();
//        nums.nextToken();
//        for(int i=0;i<size/2; i++){
//        o1.setElement(i, Double.parseDouble(String.valueOf(clientMessageRecieved.charAt(i))));}
//        int j = size/2; 
//        for(int i=0;i<size/2; i++){
//           
//        o2.setElement(i, Double.parseDouble(String.valueOf(clientMessageRecieved.charAt(j)))); j++;}
//        o3 = com.npu.teachclub.vectors.Vectors.Sum(o1, o2);
        
//        while(!clientMessageRecieved.equals("quite"))
//        {
//        System.out.println("message recieved: '"+clientMessageRecieved+"'");
//        clientMessageRecieved = clientMessageRecieved.toUpperCase();
//        soos.writeObject(clientMessageRecieved);
        
//          String  inputString = new String();
//          for (int t = 0; t < o3.getSize();t++) {
//          inputString += "" + Double.toString(o3.getElement(t));
//          } 
//          soos.writeUTF(inputString+"\r\n"); 
           
//                writeObjectclientMessageRecieved = (String)sois.readObject();//строке 
//                   out.write(inputString + "\n");
                   out.flush();
                 
                  }catch(Exception e)	{
                } finally {
                try {
//        sois.close();
//        soos.close();
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

