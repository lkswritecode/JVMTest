package sockettest;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

/**
 * @ClassName TCPClientTest
 * @Author 一个经常熬夜的程序员
 * @CreateDate 2020/8/5 15:12
 * @Version 1.0
 **/
public class TCPClientTest {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",6666);
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
            bos.write("哇哈哈".getBytes());

            bos.flush();
            bos.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
