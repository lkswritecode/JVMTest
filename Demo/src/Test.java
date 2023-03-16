import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.util.List;

/**
 * @ClassName Test
 * @Author 一个经常熬夜的程序员
 * @CreateDate 2020/10/28 17:13
 * @Version 1.0
 **/
public class Test {

    public class Test1{
        private int a = 1;
    }

    public int a(){
        Test1 t = new Test1();
        return t.a;
    }
    public Test1 getTest1(){
        return new Test1();
    }

    public static void main(String[] args) {
//        Test t = new Test();
//        t.a1(null);
//        Test2 t1 = new Test2();
//        t1.setS1("嘿嘿");
//        Test2 t2 = t1;
//        t1.setS1(null);
//        System.out.println(t2.getS1());

    }





    public void a1(int s){
        System.out.println(s+" int");
    }
    public void a1(byte s){
        System.out.println(s+" byte");
    }
    public void a1(char s){
        System.out.println(s+" char");
    }
    public void a1(String s){
        System.out.println(s+" String");
    }
    public void a1(Object o){
        System.out.println(o+" Object");
    }
}
