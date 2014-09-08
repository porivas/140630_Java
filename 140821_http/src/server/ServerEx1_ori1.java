package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1_ori1 {

   public static void main(String[] args) throws Exception {

      ServerSocket server = new ServerSocket(5555);
      System.out.println("ready......");

      byte[] arr = new byte[1024];

      Socket socket = server.accept();

      InputStream in = socket.getInputStream();
      OutputStream out = socket.getOutputStream();

      int count = in.read(arr);

      System.out.println(count);
      System.out.println(new String(arr));

      String msg = "sending message";
      byte[] msgArr = msg.getBytes("UTF-8");

      out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); // 200:��������
      //out.write(new String("Cache-Control: private\r\n").getBytes()); // ������������ �����ִ� ���� ����
      out.write(new String("Content-Length: " + msgArr.length + "\r\n").getBytes()); // contents ����?
      out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n") // contents type(MIME type)
            .getBytes());

      out.write(msgArr);
      out.flush();
   }
}