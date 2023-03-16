package mysocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream output = null;
        InputStream inputStream = null;
        ServerSocket server = null;
        try {
            //ip默认为本机
             server = new ServerSocket(9999);
            //接受连接，线程为阻塞状态
             socket = server.accept();
            //服务端向客户端发送消息
             output = socket.getOutputStream();
            String msg = "hello";
            output.write(msg.getBytes());
             inputStream = socket.getInputStream();
            byte[] bytes = new byte[100];
            inputStream.read(bytes);
            System.out.println("客户端消息:"+new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                output.close();
                inputStream.close();
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
