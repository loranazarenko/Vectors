package com.npu.teachclub.vectors.allvectors;


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
//       BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//       ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());
//       ObjectInputStream  cois = new ObjectInputStream(clientSocket.getInputStream());
       BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  
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
//write(print);
                 out.flush();
                 
//           coos.writeObject(print);   
                 print  = ""; 
//           coos.flush();
                 
                 
//          StreamTokenizer nums = new StreamTokenizer(cois); 
//          String  inputString = new String();
//             while ( nums.nextToken() != StreamTokenizer.TT_EOF ) {
//            if ( nums.ttype == StreamTokenizer.TT_NUMBER ) {
//              inputString += " " + Double.toString(nums.nextToken());  }
//          }
        
               String inputString; 
               inputString = in.readLine();
//               while ((inputString = in.readLine()) != null) {
               result += inputString +"\n";
              
              System.out.println("echo: " + result);
//               }
           
            
//          String serverMessageRecieved = (String) cois.readUTF();
          
               }
          
          }
//          (String)readUTF().readObject()
        
//        System.out.println("Enter any string to send to server \n\t('quite' − programme terminate)");
//        String clientMessage = stdin.readLine();
//        System.out.println("you've entered: "+clientMessage); while(!clientMessage.equals("quite")) {
//
//        coos.writeObject(clientMessage);
//
//        System.out.println("~server~: "+cois.readObject());
//        System.out.println("---------------------------");
//        clientMessage = stdin.readLine();
//        System.out.println("you've entered: "+clientMessage);
//}
     
        
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
