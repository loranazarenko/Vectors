
package com.netcracker.teachclub.vectors.web;

import com.netcracker.teachclub.vectors.*;
import java.io.*;
import java.net.*;

 public class ServerThread   extends Thread{
    private  Socket socket;
    
  public  ServerThread(Socket s){
          this.socket = s;
      }

    public void run(){
    
//            DataInputStream in   = null;
//            DataOutputStream out = null;
         try {
               DataInputStream in  = new DataInputStream(socket.getInputStream());
               DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
               
              while(true) {
                   Vector vectorFirst = Vectors.inputVector(in);
                   Vector vectorSecond = Vectors.inputVector(in);
                   Vector trio = Vectors.Sum(vectorFirst, vectorSecond);
                   Vectors.outputVector(trio, out);

                   out.flush();  
                   if (vectorFirst.getSize()==0){
                     break;}
                 }
                   in.close();
                   out.close();
                   socket.close();
            } catch(Exception e) {
                    e.printStackTrace();
               
            }
//         finally {
//                try {
       
      
//        } 
//           catch(Exception e) {
//                System.exit(1);
//        }
//       }
    
    }
}