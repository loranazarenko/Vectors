package com.npu.teachclub.vectors;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadRunable  implements Runnable{
     private Tablo tablo;
     public ReadRunable(Tablo vec){
      this.tablo = vec;}
     
         
    public void run(){
         try {  
             readNew(tablo);
         } catch (InterruptedException ex) {
             Logger.getLogger(ReadRunable.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
 
    
    public void readNew(Tablo vec) throws InterruptedException{
     for (int i =0;i <vec.vector.getSize(); i++) {
     System.out.println("Read: + " + vec.getElement() + "to position " + i);  
    //try {
            //Thread.sleep(1000);
        //} catch (InterruptedException e) {}
    }
     
}
    
    
}
