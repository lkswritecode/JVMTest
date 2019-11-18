package directmemory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * JVM中 四种引用（有的人认为是五种） ：
 *  强引用(Strong Reference):就是在代码中普遍存在的，类似“Object obj = new Object()”这类的引用，
 *                          只要强引用还存在，垃圾收集器永远不会回收被引用的对象。
 *
 *  软引用(Soft Reference):是用来描述有用非必需的对象。
 *                        软引用关联的对象，在系统将要发生内存溢出之前，将会对这些对象进行二次回收。
 *                        如果这次回收后还没有足够的内存，才会抛出内存溢出异常。
 *                        上面所说的“食之无味，弃之可惜”的对象就是属于软引用。
 *
 *  弱引用(Weak Reference): 是用来描述非必需的对象，但是比软引用更弱一些，弱引用关联的对象只能生存到下一次垃圾收集发生之前。
 *                         当下一次垃圾收集时，无论内存是否足够，都会回收掉被弱引用关联的对象。
 *
 *  虚引用(Phantom Reference):也称为幽灵引用或者幻影引用，它是最弱的一种引用。
 *                           一个对象是否有虚引用存在，完全不会对其生存时间造成任何影响，也无法通过虚引用获得一个对象实例。
 *                           为对象设置虚引用的目的，就是能在这个对象被收集器回收时收到一个系统通知。
 *
 * （终结引用Final Reference）:   FinalReference<T> 一般使用他的子类 Finalizer。 这两个类访问权限并非公开的，
 *                              对象至少经历两次GC才能被回收，因为只有在FinalizerThread执行完了f对象的finalize方法的情况下才有可能被下次GC回收，
 *                              而有可能期间已经经历过多次GC了，但是一直还没执行f对象的finalize方法
 *
 * 所有引用在回收之前都要进入引用队列（ReferenceQueue）
 * ReferenceQueue： java提供了4种引用类型，在垃圾回收的时候，都有自己各自的特点。
 *                  ReferenceQueue是用来配合引用工作的，没有Referencequeue一样可以运行（Referencequeue并非必须的）
 *                 创建引用的时候可以指定关联的队列，当GC释放对象内存的时候，会将引用加入到引用队列，
 *                 如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动，这相当于一种通知机制。
 *
 */
public class ReferenceDome_1 {

    public static void main(String[] args) {


    }

    /**
     * 强引用 如果list对象不为null ,JVM永远不会回收这种对象
     */
    private void  strong_Reference(){
        List<byte[]> list = new ArrayList<>();
        for (int i = 0;i<5;i++){
            byte [] bytes = new byte[4];
            list.add(bytes);
            System.out.println(list.size());
        }
        System.out.println(list.size());
    }

    /**
     * 软引用  当内存不足时就就回收一些不必要的对象
     *
     * -Xmx 20M调整JVM内存大小方便演示  -XX:+PrintGCDetails -verbose:gc打印垃圾回收GC详细信息
     *
     * 不到内存耗尽该测试不会退出
     */
    private void soft_Reference(){
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0;i<5;i++){
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[4*1024*1024]);
            System.out.println(softReference.get());
            list.add(softReference);
            System.out.println(list.size());
        }
        System.out.println(list.size());
        for (SoftReference soft : list){
            System.out.println(soft.get());
        }
    }

    /**
     * 弱引用 与软引用相似 但是比软引用更弱一些
     */
    private void weak_Reference(){
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0;i<5;i++){
            WeakReference<byte[]> softReference = new WeakReference<>(new byte[4*1024*1024]);
            System.out.println(softReference.get());
            list.add(softReference);
            System.out.println(list.size());
        }

        System.out.println(list.size());

        for (WeakReference soft : list){
            System.out.println(soft.get());
        }
    }

    /**
     * 虚引用 一般是调用本地方法（native）时JVM是使用
     *       因为JVM的垃圾回收无法回收非JVM管理的系统内存
     */
    private  void phantom_Reference(){
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue();//引用队列
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=====================");

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }


}
