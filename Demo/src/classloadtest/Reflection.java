package classloadtest;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射优化测试
 */
public class Reflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, InstantiationException, ClassNotFoundException {
        Class<?> aClass = Class.forName("classloadtest.TestEntity");
        Constructor  constructor = aClass.getConstructor();
        TestEntity testEntity = (TestEntity) constructor.newInstance();
        Method testMethod = aClass.getMethod("TestMethod",int.class);
        for (int i = 0; i < 14; i++) {
            testMethod.invoke(testEntity,i);
        }
        System.in.read();
    }
}
