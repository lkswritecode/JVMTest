package classloadtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * bootstrap Classload加载需要使用此命令，可用此命令替换核心类
 * java -Xbootclasspath/a: + 类路径
 *
 *  bootstrap Classload 加载目录JAVA_HOME/jre/lib下的类
 *  Extension Classload 加载目录JAVA_HOME/jre/lib/ext下的类
 *  Application Classload 加载我们一般创建的类
 *  自定义Classload 加载任意class文件
 *
 *  ClassLoader 线程安全
 */
public class ClassLoadMain {
    volatile  int a = 1;
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //使用bootstrap ClassLoad
        Class<?> Class1 = Class.forName("classloadtest.TestEntity");
        //sun.misc.Launcher$AppClassLoader@18b4aac2 表示使用的ApplicationClassload
        System.out.println(Class1.getClassLoader());
        //sun.misc.Launcher$ExtClassLoader@2503dbd3 表示使用的Extension Classload
        Class<?> Class2 = Class.forName("sun.text.resources.cldr.aa.FormatData_aa");
        System.out.println(Class2.getClassLoader());
        MyClassLoad myClassLoad = new MyClassLoad();
        //使用自定义类加载器 加载类里没有包信息 如果有则会报错NoClassDefFoundError
        Class<?> aClass = myClassLoad.loadClass("test");
        aClass.newInstance();//获取实例对象
        System.out.println(aClass.getClassLoader());
        //修改反射调用本地方法（native）获取对象的次数的阈值
        System.setProperty("sun.reflect.inflationThreshold","15");
        //禁用反射调取本地方法（native）获取对象
        System.setProperty("sun.reflect.noInflation","false");
        Integer a = 1;
    }

}
