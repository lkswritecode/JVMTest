package mysocket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream output = null;
        try {
            //链接服务端
             socket = new Socket("127.0.0.1",9999);
            //接收服务端发送的消息
             inputStream = socket.getInputStream();
            byte [] bytes = new byte[100];
             inputStream.read(bytes);
            System.out.println("接收到服务端消息"+new String(bytes));
             output = socket.getOutputStream();
            output.write("word".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                output.close();
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
