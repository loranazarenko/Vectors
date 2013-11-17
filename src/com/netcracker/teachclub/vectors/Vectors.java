package com.netcracker.teachclub.vectors;


import com.netcracker.teachclub.vectors.streams.SynchronizedVector;
import com.netcracker.teachclub.vectors.exceptions.IncompatibleVectorSizesException;
import com.netcracker.teachclub.vectors.patterns.ArrayVectorFactory;
import com.netcracker.teachclub.vectors.patterns.VectorFactory;
import com.netcracker.teachclub.vectors.patterns.JVectorAdapter;
import com.netcracker.teachclub.vectors.patterns.ProtectedVector;
import java.io.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vectors {

    public static VectorFactory vf = new ArrayVectorFactory();

    public static void setVectorFactory(VectorFactory factory){
    Vectors.vf =  factory;
    }
    
public static Vector createInstance(int size){
      return vf.createSizeVector(size);
 } 

public static Vector createInstance(){
      return vf.createVector();
 }    

public static Vector createInstance(Class cl, int size) {
   Object res = null;
    try {
    Class c = cl; 
    Constructor[] constructors = c.getConstructors();
    Class[] paramTypes = new Class[] {int.class }; 
    Constructor aConstrct = c.getConstructor(paramTypes); 
    res = aConstrct.newInstance(size);
   
   }    catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
          System.out.println("Метод недоступен");
        } catch (IllegalArgumentException ex) {
            return createInstance(size);
        } catch (InvocationTargetException ex) {
            System.out.println("При вызове возникло исключение");
        }
          catch (NoSuchMethodException ex) {
            System.out.println("Метод не найден");
        }
    
      return (Vector) res;
      
 } 

public static Vector getAdaptedJVector(java.util.Vector jVector){
      return new JVectorAdapter(jVector);
 }

public static Vector getProtectedVector(Vector vector){
       return new ProtectedVector(vector); 
}
      
   public static Vector fillVector(int size) {
       
        Vector array = createInstance(size);
        Random rnd = new Random();
        int constBase = 1000;
        int seed = 2 * (constBase / size);
        for (int i = 0; i < size; i++) {
            int randomBase = rnd.nextInt(seed);
            array.setElement(i, (constBase + randomBase));
            constBase += seed;
        }
        for (int i = size - 1; i > 0; i--) {
            int j = rnd.nextInt(i);
            double tmp = array.getElement(i);
            array.setElement(i, array.getElement(j));
            array.setElement(j, tmp);           
        }
        return array;
    }


    public static Vector Mult(Vector o1, double x) {
        double newVar;
        for (int i = 0; i < o1.getSize(); i++) {
            newVar = o1.getElement(i) * x;
            o1.setElement(i, newVar);
            System.out.println(o1.getElement(i));
        }
        return o1;
    }

    public static Vector Sum(Vector o1, Vector o2)  throws IncompatibleVectorSizesException {
        if (o1.getSize() != o2.getSize()){
        throw new IncompatibleVectorSizesException("The vectors are of different sizes");}
        double newVar;
        Vector o3 = createInstance(o1.getClass(), o1.getSize());
            for (int i = 0; i < o2.getSize(); i++) {
                newVar = o1.getElement(i) + o2.getElement(i);
                o3.setElement(i, newVar);
            }
        return o3;
    }

    public static void Sort(Vector o1) {
        int first = 0;
        int last = o1.getSize() - 1;
        int i = first;
        int j = last;
        int s = (first + last) / 2;

        while (i < j) {
            while (o1.getElement(i) < o1.getElement(s)) i++;
            while (o1.getElement(j) > o1.getElement(s)) j--;
            if (i <= j) {
                double prom = o1.getElement(i);
                o1.setElement(i, o1.getElement(j));
                o1.setElement(j, prom);
                i++;
                j--;
            }
            if (first < j) {
                Sort(o1);
            }
            if (i < last) {
                Sort(o1);
            }
        }
        for (int f = 0; f < o1.getSize(); f++) {
            System.out.println(o1.getElement(f));
        }
    }
// final  int sizeB; 
  static public void outputVector(Vector v, OutputStream out) throws IOException {
           DataOutputStream  outD = new DataOutputStream(out);
           int sizeB = v.getSize();
           outD.writeDouble(sizeB);
           try {
               for (int i = 0; i <  v.getSize(); i++)
               {
                   outD.writeDouble(v.getElement(i));
                   System.out.println(v.getElement(i));
               }
              outD.flush();
            }
           catch(IOException e) {
           System.out.println("Some error occurred!");
      }
 }

      
  static public Vector inputVector(InputStream in) throws IOException{
      DataInputStream inB = new DataInputStream(in);
      int sizeB = (int)inB.readDouble();
      Vector v = createInstance(sizeB);
      try {
         for(int i= 0; i<sizeB; i++){
           double f = inB.readDouble(); 
           v.setElement(i,f);
           System.out.println(f + " ");
           }

         } 
        catch(IOException e) {
        System.out.println("Some error occurred!");
      }
     return v;
 }
  static public  void writeVector(Vector v, Writer out)throws IOException{
        String  inputString = new String();
        String inputSize = Double.toString(v.getSize());
        for (int i = 0; i < v.getSize();i++) {
        inputString += " " + Double.toString(v.getElement(i));
        } 
        try {
            out.write(inputSize+inputString + "\n");
            out.flush();
        } catch (IOException e1) {
	e1.printStackTrace();
    }
  }

  static public Vector readVector(Reader in) throws IOException{
      StreamTokenizer nums = new StreamTokenizer(in);
      nums.nextToken();
      int size = (int) nums.nval;
      Vector result = createInstance(size);
      for (int i = 0; i < size;i++) {
          nums.nextToken();
          result.setElement(i,nums.nval); }
      return result;
  }
  
  static public Vector synchronizedVector(Vector vector){
    return new SynchronizedVector(vector); 
 } 

}