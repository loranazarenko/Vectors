package com.netckraker.teachclub.vectors.web;
import java.net.*;
import java.io.*;
public class Client2 {
    private static String kl,kname;
    public static void main(String args[])
    {
        try
        {
            // открываем сокет и коннектимся к localhost:3128
            // получаем сокет сервера
            Socket s = new Socket("localhost", 3128);
            // берём поток вывода и выводим туда первый аргумент
            // заданный при вызове, адрес открытого сокета и его порт
            String g;
            g="Danniye ot clienta1";
            s.getOutputStream().write(g.getBytes());
            // читаем ответ
            byte buf[] = new byte[64*1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);
            // выводим ответ в консоль
            System.out.println(data);
            //запрос на выход
             kl="350";
            s.getOutputStream().write(kl.getBytes());
             kl="1";
            switch (Integer.parseInt(kl))
            {
            case 0:
            {
                s.getOutputStream().write(kl.getBytes());
                 r = s.getInputStream().read(buf);
                 data = new String(buf, 0, r);
                // выводим ответ в консоль
                System.out.println("Client 1 "+data);
            }
            case 1:
            {
                s.getOutputStream().write(kl.getBytes());
                r = s.getInputStream().read(buf);
                 data = new String(buf, 0, r);
                s.getOutputStream().write("250".getBytes());
                 r = s.getInputStream().read(buf);
                 data = new String(buf, 0, r);
                 s.getOutputStream().write("hello client 2 from client 1".getBytes());
                 /*r = s.getInputStream().read(buf);
                 data = new String(buf, 0, r);
                 if(Integer.parseInt(data)==1){
                     s.getOutputStream().write("hello client 2 from client 1".getBytes());
                     System.out.println("Mess send");
                 }*/
            }
            case 2:
            {
                s.getOutputStream().write(kl.getBytes());
                r = s.getInputStream().read(buf);
                 data = new String(buf, 0, r);
                //---------------write  data to file-----------
                try {
                    PrintWriter out = new PrintWriter(new File("Client1(incom message).txt").getAbsoluteFile());
                    try {
                    out.print(data);
                    } finally {
                    out.close();
                    }
                    } catch(IOException e) {
                    throw new RuntimeException(e);
                    } 
               //------------------------------------------------------
            }
            default:
            }
            
        }
        catch(Exception e)
        {System.out.println("init error(Client): "+e);} // вывод исключений
    }
 
}
 