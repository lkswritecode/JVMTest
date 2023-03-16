package JMM;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

/**
 * 指令重排-并发测试
 * 使用 mvn  clean install打包
 * 然后在cmd使用 java -jar target/jcstress-learning.jar
 *
 */

//并发测试
@JCStressTest
//不感兴趣的值 这里的id就是下面r.r1的值
@Outcome(id = {"1","4"},expect = Expect.ACCEPTABLE,desc = "ok")
//感兴趣的值 这里的id就是下面r.r1的值
@Outcome(id = "0",expect = Expect.ACCEPTABLE_INTERESTING,desc = "!!!")
//状态
@State
public class jcstressTest {
    int num = 0;
    boolean ready = false;

    @Actor //使用多线程测试这个方法
    public  void actor_1(I_Result r){
        if (ready){
            r.r1 = num + num;
        }else {
            r.r1 = 1;
        }
    }
    @Actor //使用多线程测试这个方法
    public void  actor_2(I_Result r){
        num = 2;
        ready = true;
    }
}
