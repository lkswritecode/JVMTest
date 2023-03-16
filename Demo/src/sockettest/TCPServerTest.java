package sockettest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPServiceTest
 * @Author 一个经常熬夜的程序员
 * @CreateDate 2020/8/5 15:02
 * @Version 1.0
 **/
public class TCPServerTest {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("正在等待连接。。。。");
            Socket s = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String mag = br.readLine();
            System.out.println("客户端发送来的消息："+mag);
            br.close();
            s.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
