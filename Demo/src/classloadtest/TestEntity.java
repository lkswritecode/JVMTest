package classloadtest;

public class TestEntity {
    static {
        System.out.println("静态代码块");
    }
    public static void TestMethod(final int a){
        System.out.println("这是第："+a+"次");
    }
}
