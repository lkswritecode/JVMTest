package JMM;

public class happens_before {
    static int x;
    volatile int y;
    static Object m = new Object();
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
            happens_before.class.newInstance().method_3();
    }

    //线程锁可保证 读写正常
    protected void method_1(){
        new Thread(()->{
            synchronized(m){
                x = 1;

            }
        },"t1").start();

        new Thread(()->{
            synchronized(m){
                System.out.println(x);
            }
        },"t2").start();
    }
    //volatile可保证 读写正常
    protected  void method_2(){
        new Thread(()->{
                y = 1;

        },"t1").start();

        new Thread(()->{
                System.out.println(y);
        },"t2").start();
    }
    //在线程start()之前赋值，可保证 读写正常
    protected void  method_3(){
        int z = 1;
        new Thread(()->{
            System.out.println(z);
        },"t1").start();
    }
    //等待对变量修改的线程结束后（join，isAlive），对这个变量的读写正常
    protected void  method_4() throws InterruptedException {
        int z = 1;
       Thread t1= new Thread(()->{
            System.out.println(z);
        });
        t1.start();
        t1.join();
        System.out.println(x);
    }
    //在线程1被打断(interrupt)前进行赋值,这样这个值是可以被读到的
    protected void  method_5(){
            int z;
            Thread t1 = new Thread(()->{
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println(x);
                        break;
                    }
                }
            },"t1");
            t1.start();
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x = 10;
                t1.interrupt();
            },"t2").start();
            while (!t1.isInterrupted()){
                Thread.yield();
            }
            System.out.println(x);
    }
}
