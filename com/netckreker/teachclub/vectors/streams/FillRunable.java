
package com.netckreker.teachclub.vectors.streams;

import static com.netckreker.teachclub.vectors.Vectors.createInstance;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FillRunable implements Runnable{
    private Tablo tablo;
    public FillRunable(Tablo vec){
      this.tablo = vec;}
     
    @Override
    public void run() {
         Random rnd = new Random();
         for (int i = 0;i<tablo.vector.getSize(); i++) {
             try {
                 tablo.putElement(rnd.nextDouble());
             } catch (InterruptedException ex) {
                 Logger.getLogger(FillRunable.class.getName()).log(Level.SEVERE, null, ex);
             }
         System.out.println("Write: + " + rnd.nextDouble() + "to position " + i);
         //try {
                //Thread.sleep(1000);
            //} catch (InterruptedException e) {}
      }  
     }
     
    
}
