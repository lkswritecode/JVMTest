package springbeanTest;

import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.transaction.TransactionRequiredException;
import javax.transaction.TransactionalException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Bean的生命周期
 *
 * bean工厂后处理器初始化-->
 * bean工厂后处理器的postProcessBeanFactory方法-->
 * Bean后置处理器初始化-->
 * 实例化感知Bean后处理器初始化-->
 * 实例化感知Bean后处理器的postProcessBeforeInstantiation方法-->
 * （我们的类）静态代码块-->
 * （我们的类）普通代码块-->
 * （我们的类）构造方法代码块-->
 * 实例化感知Bean后处理器的postProcessPropertyValues方法-->
 * 调用BeanNameAware的setBeanName设置beanmingc-->
 * 调用BeanFactoryAware的setBeanFactory方法设置Bean工厂-->
 * Bean后置处理器的postProcessBeforeInitialization方法 -->
 * 调用InitializingBean的afterPropertiesSet方法-->
 * （我们的类）初始化代码块-->
 * Bean后置处理器的postProcessAfterInitialization方法-->
 * 实例化感知Bean后处理器的postProcessAfterInitialization方法 -->
 * (我们的类)销毁方法
 *
 * ApplicationContext 使用的类加载器：Launcher$AppClassLoader
 *
 *
 */
@SpringBootApplication
public class TestMain {
    public static void main(String[] args) throws IOException {
            //Map<String,Object> concurrentHashMap = new ConcurrentHashMap<>();
//       Jedis jedis = new Jedis("192.168.137.131",3679);
//        System.out.println(jedis.ping());


//        System.out.println("--------------【初始化容器】---------------");
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("springbeanTest/springBeanTest.xml");
//        System.out.println("-------------------【容器初始化成功】------------------");
//        //得到studentBean，并显示其信息
//        TestBean testBean = context.getBean("TestBean",TestBean.class);
//        System.out.println(context.getClassLoader());
//        System.out.println(testBean);
//        System.out.println("--------------------【销毁容器】----------------------");
//        ((ClassPathXmlApplicationContext)context).registerShutdownHook();


        SpringApplication.run(TestMain.class,args);
    }
}
