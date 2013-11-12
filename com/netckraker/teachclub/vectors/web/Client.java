
package com.netckraker.teachclub.vectors.web;

import com.netckraker.teachclub.vectors.Vector;
import static com.netckraker.teachclub.vectors.Vectors.createInstance;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
 
 public static void main(String[] args) throws IOException {
     String f1;
     String f2;
 
//     f1 = args[0];
//     f2 = args[1];
    f1 = "D:/A1.txt";
    f2 = "D:/A2.txt";
    
    
    Socket fromserver = null;
    fromserver = new Socket("localhost",4444);

    
    BufferedReader in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
    PrintWriter    out = new PrintWriter(fromserver.getOutputStream(),true);
      
    ObjectOutputStream coos = new ObjectOutputStream(fromserver.getOutputStream());
    
    
     FileReader fin = new FileReader(f1);
     Scanner text = new Scanner(fin);
        int countLine = 0;
        String print  = "";
        while (text.hasNext()) {
          countLine++;  
          print += text.nextLine()+ "\n";
          if(countLine%2==0){
//            out.write(print);
           coos.writeObject(print);   
            print  = ""; 
           coos.flush();
         
           PrintWriter bw = new PrintWriter(new BufferedWriter(new FileWriter(f2)));
           StreamTokenizer nums = new StreamTokenizer(in);         
           String  inputString = new String();
             while ( nums.nextToken() != StreamTokenizer.TT_EOF ) {
            if ( nums.ttype == StreamTokenizer.TT_NUMBER ) {
              inputString += " " + Double.toString(nums.nextToken());  }
             bw.write(inputString + "\n"); 
            }
            if (nums.ttype == StreamTokenizer.TT_WORD) {nums.nextToken();}
          
          }
        }
    out.close();
    in.close();
    fromserver.close();
  }
}
    


