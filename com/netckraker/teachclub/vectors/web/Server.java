
package com.netckraker.teachclub.vectors.web;

import com.netckraker.teachclub.vectors.allvectors.ArrayVector;
import com.netckraker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import java.io.*;
import java.net.*;


public class Server {

  public static void main(String[] args) throws IOException, IncompatibleVectorSizesException, ClassNotFoundException {

    BufferedReader in = null;
    PrintWriter    out= null;

    ServerSocket servers = null;
    Socket       fromclient = null;
    ObjectInputStream  sois   = null;//объявление байтового потока ввода
    ObjectOutputStream soos   = null;//объявление байтового потока вывода

    try {
      servers = new ServerSocket(4444);
    } catch (IOException e) {
      System.out.println("Couldn't listen to port 4444");
      System.exit(-1);
    }

    try {
      System.out.print("Waiting for a client...");
      fromclient = servers.accept();
      System.out.println("Client connected");
    } catch (IOException e) {
      System.out.println("Can't accept");
      System.exit(-1);
    }

    in  = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
    
//    StreamTokenizer nums = new StreamTokenizer(in);
//    out = new PrintWriter(fromclient.getOutputStream(),true);
  
    com.netckraker.teachclub.vectors.Vector o1 = new ArrayVector();
    com.netckraker.teachclub.vectors.Vector o2 = new ArrayVector();
    com.netckraker.teachclub.vectors.Vector o3 = new ArrayVector();
    
    sois = new ObjectInputStream(fromclient.getInputStream()); 
    soos = new ObjectOutputStream(fromclient.getOutputStream());//создание потока 
    //вывода
    String clientMessageRecieved = (String)sois.readObject();//объявление 
    //строки и присваивание ей данных потока ввода, представленных 
    //в виде строки (передано клиентом)
    while(!clientMessageRecieved.equals("quite"))//выполнение цикла: пока 
    //строка не будет равна «quite»
    {
    System.out.println("message recieved: '"+clientMessageRecieved+"'");}
    
//    
//    
//                int j = 0;
////                ((input = in.readLine()) != null) 
//                while ( nums.nextToken() != StreamTokenizer.TT_EOF ) {
//                if ( nums.ttype == StreamTokenizer.TT_NUMBER ) {
//                o1.setElement(j , nums.nval);
//                j++;}
//                if ( nums.ttype == StreamTokenizer.TT_WORD) {nums.nextToken();}
//                if ( nums.ttype == StreamTokenizer.TT_NUMBER ) {
//                o2.setElement(j , nums.nval);
//                j++;}
//                }  
//            
   o3 = com.netckraker.teachclub.vectors.Vectors.Sum(o1, o2);
    
        String  inputString = new String();
        for (int t = 0; t < o3.getSize();t++) {
        inputString += " " + Double.toString(o3.getElement(t)) + "\n";
        } 
    
//        out.write(inputString + "\n");
//        out.flush();
      

   
    out.close();
    in.close();
    fromclient.close();
    servers.close();
 
  
  
  }

    
}
  

    

