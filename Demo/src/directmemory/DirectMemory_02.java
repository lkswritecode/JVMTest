package directmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用反射机制获取Unsafe
 *
 * Unsafe在区获取直接内存
 *
 * Unsafe不建议使用，此类为JVM使用的私有类
 * 构造方法为  private Unsafe()
 * 相关简书 https://www.jianshu.com/p/db8dce09232d
 *
 * ByteBuffer 底层就使用Unsafe对象完成直接内存的分配回收，并主动调用freeMemory方法
 * ByteBuffer底层就是使用了Cleaner(虚引用)来监测ByteBuffer对象
 * 一旦ByteBuffer对象被垃圾回收了那么就会由一个叫ReferenceHandler的线程通过freeMemory来释放直接内存
 */
public class DirectMemory_02 {
     static int SIZE_1G = 1024*1024*1024;

    public static void main(String[] args) {

        Unsafe unsafe=getUnsafe();
        if(unsafe!=null){
            //获取分配的直接内存地址
            long base = unsafe.allocateMemory(SIZE_1G);
            unsafe.setMemory(base,SIZE_1G,(byte) 0);
            //释放内存
            unsafe.freeMemory(base);
        }
    }

    public static Unsafe getUnsafe(){
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            return unsafe;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
