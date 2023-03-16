package classloadtest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * 类加载器
 * 加载随意路径下的class
 */
public class MyClassLoad extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String  path = "D:\\test1\\"+ name +".class";//获取class路径
        try (   //创建数组缓冲区
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ){
            //复制字节码文件到缓冲区
            Files.copy(Paths.get(path),outputStream);
            //得到字节数组
            byte[] bytes = outputStream.toByteArray();
            //返回加载到的类对象
            return defineClass(name,bytes,0,bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("未找到文件",e);
        }
    }
}
