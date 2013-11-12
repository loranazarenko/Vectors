package com.netckreker.teachclub.vectors.web;
import java.net.*;
import java.io.*;
 
 class Server2 extends Thread{
      Socket s;
      private static Socket sd[]=new Socket[100];
      private static Integer xsd[]=new Integer[100];
      private static String ssd[][]=new String[2][100];
      private  static int  i=0,j,h=0;
      static Socket a;
    int num;
    
    //-----------------
    //-----------------
    public static void main(String args[])
    {
        try
        {
            
         //i = 1; // счётчик подключений
            // привинтить сокет на локалхост, порт 3128
            ServerSocket server = new ServerSocket(3128, 0,InetAddress.getByName("localhost"));
            System.out.println("server is started");
            // слушаем порт
            while(true)
            {
                // ждём нового подключения, после чего запускаем обработку клиента
                // в новый вычислительный поток и увеличиваем счётчик на единичку
                i++;
                sd[i]=server.accept();
                new Server2(i,sd[i]);
                
            }
        }
        catch(Exception e)
        {System.out.println("init error(Server/main): "+e);} // вывод исключений
    }
    public Server2(int num, Socket s)
    {
        // копируем данные
        this.num = num;
        this.s = s;
        // и запускаем новый вычислительный поток (см. ф-ю start())
        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }
    public void start()
    {
        try
        {
            System.out.println("Run");
            // из сокета клиента берём поток входящих данных
            InputStream is = s.getInputStream();
            // и оттуда же - поток данных от сервера к клиенту
            OutputStream os = s.getOutputStream();
            // буффер данных в 64 килобайта
            byte buf[] = new byte[64*1024];
            // читаем 64кб от клиента, результат - кол-во реально принятых данных
            int r = is.read(buf);
            // создаём строку, содержащую полученную от клиента информацию
            String data = new String(buf, 0, r);
            // добавляем данные об адресе сокета:
            data = ""+num+": "+"\n"+data;
            // выводим данные:
            os.write(data.getBytes());
            // далее слушатель
            //принимаем имя пользователя
            r = is.read(buf);
            data = new String(buf, 0, r);
            r=0;
            xsd[i-1]=Integer.parseInt(data);
            //слушаем действие от него
            r = is.read(buf);
            data = new String(buf, 0, r);
            r=0;
            switch ( Integer.parseInt(data) )
            {
            case 0: 
            {
                os.write("You are disconnected".getBytes());
                s.close();
                break;
            }
            case 1: 
            {
                os.write("0".getBytes());
                r = is.read(buf);
                data = new String(buf, 0, r);
                r=0;
                ssd[1][0]=data;
                os.write("2".getBytes());
                r = is.read(buf);
                data = new String(buf, 0, r);
                r=0;
                ssd[0][0]=data;
                h++;
                break;
            }
            case 2: 
            {
                        os.write(ssd[0][0].getBytes()); 
                break;
            }
            case 3:
            {
                break;
            }
            default:
                //os.write("There is no like this".getBytes());
            }
            //s.close();
        }
        catch(Exception e)
        {System.out.println("init error(Server/run): "+e);} // вывод исключений
    }
}
 