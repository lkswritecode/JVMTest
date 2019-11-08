package directmemory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试字节内存 01
 * ByteBuffer
 */
public class DirectMemory_01 {
    static final String FROM="D:";
    static final String CLONE = "D:";
    static final int SIZE_1M=1024*1024;
    public static void main(String[] args) {
        byteBuffer();
        io();
    }
    //使用ByteBuff模式复制文件
    private static void byteBuffer(){
        long start = System.nanoTime();
        try ( FileChannel from = new FileInputStream(FROM).getChannel();
              FileChannel clone = new FileOutputStream(CLONE).getChannel();)
        {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(SIZE_1M);//直接内存缓存
            while (true){
                int length = from.read(byteBuffer);
                if(length == -1){
                    from.close();
                    clone.close();
                    break;
                }
                byteBuffer.flip();
                clone.write(byteBuffer);
                byteBuffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("ByteBuffer 用时:"+(end-start)/1000_00.0);
    }
    //传统模式下复制文件
    private static void io(){
        long start = System.nanoTime();
        try(FileInputStream from = new FileInputStream(FROM);
            FileOutputStream clone = new FileOutputStream(CLONE);)
        {
            byte [] bytes = new byte[SIZE_1M];//java缓存
            while (true){
                int length = from.read(bytes);
                if(length == -1){
                    from.close();
                    clone.close();
                    break;
                }
                clone.write(bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("byte[] 用时:"+(end-start)/1000_00.0);
    }
}